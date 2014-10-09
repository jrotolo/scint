import java.io.*;

class Begin extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Begin() {
	 }

    void print(Node t, int n, boolean p) {
    	System.out.println("(begin");
		System.out.println("here");
    	Node cdr = t.getCdr();
		indent(1);
    	if (cdr != null)
    		cdr.print(n, p);
    	System.out.println("");
    }
}
