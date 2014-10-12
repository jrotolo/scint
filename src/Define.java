import java.io.*;

class Define extends Special {
 
	 public Define() {
	 }


    void print(Node t, int n, boolean p) {
		System.out.print("(define ");

		Node cadr = t.getCdr().getCar();
		if (!cadr.isNull())
			cadr.print(0);
		
		Node cddr = t.getCdr().getCdr();
		Node caddr = t.getCdr().getCdr().getCar();
		if (cddr.isNull()) {
			cddr.print(0, true);
			System.out.println();
		}
		else if (!caddr.isNull()) {
			caddr.print(1, false);
			System.out.println(")");
		}
    }
}
