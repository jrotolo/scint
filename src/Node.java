import java.io.*;

class Node {

  // The argument of print(int) is the number of characters to indent.
  public void print(int n) {}

  public void print(int n, boolean p) {
    print(n);
  }

  public boolean isBoolean()   { return false; }  // BooleanLit 

  public boolean isNumber() { return false; }  // IntLit  

  public boolean isString() { return false; }  // StringLit  

  public boolean isSymbol() { return false; }  // Ident  

  public boolean isNull()   { return false; }  // nil  

  public boolean isPair()   { return false; }  // Cons 

  public boolean isProcedure() { return false; }
  
  public static void print(Node t, int n, boolean p) { t.print(n, p); }

  public static Node getCar(Node t) { return t.getCar(); }

  public static Node getCdr(Node t) { return t.getCdr(); }

  public static boolean isNull(Node t) { return t.isNull(); }

  public static boolean isPair(Node t) { return t.isPair(); }

  public Node eval(Environment env) { return null; }

  public Node apply(Node args, Environment env) { System.err.println("Error: cant call apply from Node"); return null; }
  
  public Node getCar() { return null; }

  public Node getCdr() { return null; }

  public void setCar(Node a) {}

  public void setCdr(Node d) {}
  
  public String getName() { return ""; }

  public int getValue() { return 0; }

  public boolean getBoolean() { return false; }
}