import java.io.*;
class IntLit extends Node {
  private int intVal;

  public IntLit(int i) { intVal = i; System.out.println("IntVal made");}

  public void print(int n) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");

    System.out.print(intVal);
	 indent(1);
  }

  public void print(Node t, int n, boolean p) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");

    t.getCar().print(0);
  }

  public boolean isNumber() {
		return true;
  }
}
