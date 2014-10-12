import java.io.*;

class Regular extends Special {

	 public Regular() {
	 }

    void print(Node t, int n, boolean p) {
	 	for (int i = 0; i < n; i++)
			System.out.print(' ');

		if (!p)
			System.out.print("(");

		t.getCar().print(0);
	   if (!t.getCdr().isNull()) {	
			indent(1);
			t.getCdr().print(n, true);
		} else  {
			t.getCdr().print(n, false, true);
		}
    }

	 void print(int n, boolean p) {
	 }

}
