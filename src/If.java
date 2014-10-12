import java.io.*;

class If extends Special {
 
	 public If() {
	 }

    void print(Node t, int n, boolean p) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
		System.out.print("(if ");
      
		// The condition
		Node cadr = t.getCdr().getCar();
		if (cadr.isPair())
			cadr.print(0, p);
		
		// then clause
		Node caddr = t.getCdr().getCdr().getCar();
		if (!(caddr instanceof Cons) || caddr instanceof Nil) {
			indent(3);
			caddr.print(n, p);
			System.out.println();
		} else if (!caddr.isNull()) {
			indent(3);
			caddr.print(n, p);
		}

		// else clause
		Node cadddr = t.getCdr().getCdr().getCdr().getCar();
		if (!cadddr.isNull()) {
			indent(3);
			cadddr.print(n, p);
		} 
		System.out.println(")");
    }
}
