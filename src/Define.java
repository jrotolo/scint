import java.io.*;

class Define extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public Define() {
	 }


    void print(Node t, int n, boolean p) {
	   for (int i = 0; i < n; i++)
			System.out.print(' ');
		System.out.print("(define ");

		Node cadr = t.getCdr().getCar();
		if (!cadr.isNull())
			cadr.print(0, false);
		
		Node caddr = t.getCdr().getCdr().getCar();
		if (!caddr.isNull()) {
			System.out.println();
			indent(3);
			caddr.print(0, false);
		}
    }
}
