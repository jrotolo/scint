import java.io.*;

class Set extends Special {
 
	 public Set() {
	 }

    void print(Node t, int n, boolean p) {
		if (!p)
			System.out.print("(");
		//t.getCar().print(n);
		System.out.print("set!");
		indent(1);
		if (!t.getCdr().isNull()) {
			t.getCdr().print(n, true);
		 } else
			System.out.print(")");
//		System.out.println();

    }
}
