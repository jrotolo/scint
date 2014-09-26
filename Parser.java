// Parser.java -- the implementation of class Parser
//
// Defines
//
//   class Parser;
//
// Parses the language
//
//   exp  ->  ( rest
//         |  #f
//         |  #t
//         |  ' exp
//         |  integer_constant
//         |  string_constant
//         |  identifier
//    rest -> )
//         |  exp+ [. exp] )
//
// and builds a parse tree.  Lists of the form (rest) are further
// `parsed' into regular lists and special forms in the constructor
// for the parse tree node class Cons.  See Cons.parseList() for
// more information.
//
// The parser is implemented as an LL(0) recursive descent parser.
// I.e., parseExp() expects that the first token of an exp has not
// been read yet.  If parseRest() reads the first token of an exp
// before calling parseExp(), that token must be put back so that
// it can be reread by parseExp() or an alternative version of
// parseExp() must be called.
//
// If EOF is reached (i.e., if the scanner returns a NULL) token,
// the parser returns a NULL tree.  In case of a parse error, the
// parser discards the offending token (which probably was a DOT
// or an RPAREN) and attempts to continue parsing with the next token.

class Parser {
  private Scanner scanner;

  public Parser(Scanner s) { scanner = s; }
  
  public Node parseExp() {
    Token inputToken = scanner.getNextToken();

    // TODO: Figure out how to deal with TokenType QUOTE and DOT
    if (inputToken.getType() == Token.LPAREN)
      return parseRest();
    else if (inputToken.getType() == Token.RPAREN)
      return new Nil();
    else if (inputToken.getType() == Token.TRUE)
      return new BooleanLit(true);
    else if (inputToken.getType() == Token.FALSE)
      return new BooleanLit(false);
    else if (inputToken.getType() == Token.INT)
      return new IntLit(inputToken.getIntVal());
    else if (inputToken.getType() == Token.STRING)
      return new StrLit(inputToken.getStrVal());
    else if (inputToken.getType() == Token.IDENT)
      return new Ident(inputToken.getName());

    return null;
  }

  public Node parseExp(Token inputToken) {
    return null;
  }
  
  protected Node parseRest() {
    // TODO: write code for parsing rest
    Token inputToken = scanner.getNextToken();

    if (inputToken.getType() == Token.RPAREN)
      return new Nil();
    else
      return parseExp();

    //return null;
  }
  
  // TODO: Add any additional methods you might need.
};
