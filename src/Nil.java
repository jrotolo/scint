import java.io.*;
import java.lang.String;

class Nil extends Node {
  public Nil() { }

  public void print(int n)		{ print(n, false); }
  public void print(int n, boolean p) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");
    
    if (p) {
      System.out.print(")");
    } else {
      System.out.print("()");
    }
  }
  
  public void print(int n, boolean p, boolean printNewLine) {
     System.out.print(")");
	  System.out.println();
  }

  public boolean isNull() {
 		return true; 
  }
}
