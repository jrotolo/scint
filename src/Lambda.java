import java.io.*;

class Lambda extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Lambda() {
	 }

    void print(Node t, int n, boolean p) {
	 	t.getCar().print(0);
		indent(1);
		t.getCdr().print(0, true);
    }
}
