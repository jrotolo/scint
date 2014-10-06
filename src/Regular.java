import java.io.*;

class Regular extends Special {
	 private Node n;
    // TODO: Add any fields needed.


    // TODO: Add an appropriate constructor.
	 public Regular(Node node) {
	 	n = node;
		System.out.println("Regular Node Made");
		n.print(1);
	 }

    void print(Node t, int n, boolean p) {
//	 	indent(n);
		//t.print(n, p);
		//System.out.println("In print(t,n,p) of regular.java ");
		//t.getCar().print(0);
    }

	 void print(int n, boolean p) {
	 	System.out.println("In Regular.java");
	 }

}
