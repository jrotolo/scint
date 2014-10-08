import java.io.*;
class Ident extends Node {
  private String name;

  public Ident(String n) { name = n; System.out.println("Ident made"); }
  
  public String getName() {
  	return name; 
  }

  public void print(int n) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");
	 
    System.out.print(name);
  }

  public void print(int n, boolean p) {
  	System.out.println(name);
  }

  public boolean isSymbol() {
 		return true; 
  }
}
