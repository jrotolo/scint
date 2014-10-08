import java.io.*;

class Define extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Define() {
	 	System.out.println("Define node made"); 
	 }

    void print(Node t, int n, boolean p) {
		if (!p)
			System.out.print("(");
		t.getCar().print(0);
		t.getCdr().print(1, true);
    }
}
