import java.io.*;

class Cond extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Cond() {
	 	System.out.println("Cond node made"); 
	 }

    void print(Node t, int n, boolean p) {
	 	if (!p)
			System.out.print("(");
		t.getCar().print(0);
		t.getCdr().print(0, true);
    }
}
