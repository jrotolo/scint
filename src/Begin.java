import java.io.*;

class Begin extends Special {
 
	 public Begin() {
	 }

    void print(Node t, int n, boolean p) {
	 	for (int i = 0; i < n; i++) 
			System.out.print(' ');

  		System.out.println("(begin");
    	Node cdr = t.getCdr();
		indent(1);
    	if (cdr != null) {
    		cdr.print(n+2, true);
		}
    	System.out.println("");
    }
}
