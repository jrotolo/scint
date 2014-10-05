import java.io.*;

class Regular extends Special {
	 private Node n; 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Regular(Node node) {
	 	n = node; 
	 }

    void print(Node t, int n, boolean p) {
	 	indent(n);
		t.print(n, p);
    }
}
