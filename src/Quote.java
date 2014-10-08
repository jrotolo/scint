import java.io.*;

class Quote extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Quote() {
	 	System.out.println("Quote node made"); 
	 }

    void print(Node t, int n, boolean p) {
		if (!p)
			System.out.print("(");

    	t.getCar().print(0); 
		indent(1);
		t.getCdr().print(0, true);
	 }
}
