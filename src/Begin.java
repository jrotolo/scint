import java.io.*;

class Begin extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.

    void print(Node t, int n, boolean p) {
    	System.out.println("(begin");
    	Node cdr = t.getCdr();
    	if (cdr != null)
    		cdr.print(n, p);
    	System.out.println("");
    }
}
