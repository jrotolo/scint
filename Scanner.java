// Scanner.java -- the implementation of class Scanner

import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

class Scanner {
  private PushbackInputStream in;
  private byte[] buf = new byte[1000];

  public Scanner(InputStream i) { in = new PushbackInputStream(i); }

  public Token getNextToken() {
    int bite = -1;

    // It would be more efficient if we'd maintain our own input buffer
    // and read characters out of that buffer, but reading individual
    // characters from the input stream is easier.
    try {
      bite = in.read();
    } catch (IOException e) {
      System.err.println("We fail: " + e.getMessage());
    }

    if (bite == -1)
      return null;

   char ch = (char) bite;
	if (ch == ' ')
		return getNextToken();
	else if (ch == ';') {
		do {
			try {
				bite = in.read();
			} catch (IOException e) {
				System.err.println("We fail: " + e.getMessage());
			}
			ch = (char) bite;
		} while (!(ch == '\n'));
		return getNextToken();
	}
    // Special characters
    if (ch == '\'')
      return new Token(Token.QUOTE);
    else if (ch == '(')
      return new Token(Token.LPAREN);
    else if (ch == ')')
      return new Token(Token.RPAREN);
    else if (ch == '.')
      // We ignore the special identifier `...'.
      return new Token(Token.DOT);

    // Boolean constants
    else if (ch == '#') {
      try {
			bite = in.read();
      } catch (IOException e) {
			System.err.println("We fail: " + e.getMessage());
      }

      if (bite == -1) {
	System.err.println("Unexpected EOF following #");
	return null;
      }
      ch = (char) bite;
      if (ch == 't')
	return new Token(Token.TRUE);
      else if (ch == 'f')
	return new Token(Token.FALSE);
      else {
	System.err.println("Illegal character '" + (char) ch + "' following #");
	return getNextToken();
      }
    }

    // String constants
    else if (ch == '"') {
      StringBuilder str = new StringBuilder();

      try {
        bite = in.read();
      } catch (IOException e) {
        System.err.println("We fail: " + e.getMessage());
      }
      ch = (char) bite;

  		while (!(ch == '"')) {
        str.append(ch);
  			try {
  				bite = in.read();
  			} catch (IOException e) {
  				System.err.println("We fail: " + e.getMessage());
  			}
        ch = (char) bite;
  		}

      return new StrToken(str.toString());
    }

    // Integer constants
    else if (ch >= '0' && ch <= '9') {
      int i = 0;
  		Stack<Integer> intStack = new Stack();

  		do {
  			i = ch - '0';
  			System.out.println("push = " + i);
  			intStack.push(new Integer(i));
  			System.out.println("Stack = " + intStack);
  			try {
  				bite = in.read();
  			} catch (IOException e) {
  				System.err.println("We fail: " + e.getMessage());
  			}
  			ch = (char) bite;
  		} while ((ch >= '0' && ch <= '9'));

  		int intValue = 0;
  		int j = 0;

  		while (!intStack.empty()) {
  			intValue += intStack.pop() * Math.pow(10, j++);
  		}

  		try {
  			in.unread(ch);
  		} catch (IOException e) {
  			System.err.println("We fail: " + e.getMessage());
  		}

      return new IntToken(intValue);
    }

    // Identifiers
    else if (ch >= 'A' && ch <= 'Z') {
      StringBuilder str = new StringBuilder();
      str.append(ch);
  		do {
  			try {
  				bite = in.read();
  			} catch (IOException e) {
  				System.err.println("We fail: " + e.getMessage());
  			}
  			ch = (char) bite;
        str.append(ch);
  		} while (ch >= 'a' && ch <= 'z');
      // put the character after the identifier back into the input
      try {
        in.unread(ch);
      } catch (IOException e) {
        System.err.println("We fail: " + e.getMessage());
      }

      return new IdentToken(str.toString());
    }

    // Illegal character
    else {
      System.err.println("Illegal input character " + (char) ch);
      return getNextToken();
    }
  };
}
