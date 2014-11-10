import java.io.*;
class Ident extends Node {
  private String name;

  public Ident(String n) { name = n; }

  public void print(int n) {
  	Printer.printIdent(n, name);
    
  }

  public Node eval(Environment env) {
  	return env.lookup(this);
  }
  
  public boolean isSymbol() { return true; }
  public String getSymbol() { return name; }
  public String getName() { return name; } 
}
