import java.io.*;

class Quote extends Special {
 
	 public Quote() {
	 }

    void print(Node t, int n, boolean p) {
		System.out.print("'");
		t.getCdr().print(0, true);
	 }
}
