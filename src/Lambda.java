import java.io.*;

class Lambda extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Lambda() {
	 	System.out.println("Lambda node created"); 
	 }

    void print(Node t, int n, boolean p) {
	 	t.getCar().print(0);
		t.getCdr().print(0, true);
    }
}
