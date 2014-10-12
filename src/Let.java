import java.io.*;

class Let extends Special {
 
	 public Let() {
	 }

    void print(Node t, int n, boolean p) {
	 	if (!p)
			System.out.print("(");
		t.getCar().print(0);
		indent(1);
		t.getCdr().print(0, true); 
    }
}
