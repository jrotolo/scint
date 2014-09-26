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
  private Node nilNode;
  private Node trueNode;
  private Node falseNode;

  public Parser(Scanner s) { scanner = s; }
  
  public Node parseExp() {
    return parseExp(scanner.getNextToken());
  }

  public Node parseExp(Token inputToken) {
    // TODO: Figure out how to deal with TokenType QUOTE and DOT
    if (inputToken.getType() == Token.LPAREN)
      return parseRest();
    else if (inputToken.getType() == Token.TRUE)
      return this.getTrueNode();
    else if (inputToken.getType() == Token.FALSE)
      return this.getFalseNode();
    else if (inputToken.getType() == Token.INT)
      return new IntLit(inputToken.getIntVal());
    else if (inputToken.getType() == Token.STRING)
      return new StrLit(inputToken.getStrVal());
    else if (inputToken.getType() == Token.IDENT)
      return new Ident(inputToken.getName());
    return null;
  }
  
  protected Node parseRest() {
    return parseRest(scanner.getNextToken());
  }

  protected Node parseRest(Token inputToken) {
    // TODO: write code for parsing rest
    if (inputToken.getType() == Token.RPAREN)
      return getNilNode();
    else
      return new Cons(parseExp(inputToken), parseRest()); 
  }
  

  // Methods for singleton node objects
  public Node getNilNode() {
    if (nilNode == null)
      nilNode = new Nil();
    return nilNode;
  }

  public Node getTrueNode() {
    if (trueNode == null)
      trueNode = new BooleanLit(true);
    return trueNode;
  }

  public Node getFalseNode() {
    if (falseNode == null)
      falseNode = new BooleanLit(false);
    return falseNode;
  }
};
