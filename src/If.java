import java.io.*;

class If extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	 public If() {
	 }

    void print(Node t, int n, boolean p) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
		System.out.print("(if ");

		Node cadr = t.getCdr().getCar();
		if (cadr.isPair())
			cadr.print(0, p);
		
		System.out.println();

		Node caddr = t.getCdr().getCdr().getCar();
		if (!caddr.isNull()) {
			//indent(4);
			caddr.print(n + 4, p);
		}
		
		Node cadddr = t.getCdr().getCdr().getCdr().getCar();
		if (!cadddr.isNull()) {
			System.out.println();
			//indent(4);
			cadddr.print(n + 4, p);
		}
		System.out.println();
    }
}
