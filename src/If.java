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
		if (!(caddr instanceof Cons)) {
			caddr.print(n + 4, p);
			System.out.println();
		} else if (!caddr.isNull()) {
			caddr.print(n + 4, p);
		}

		// else clause
		Node cadddr = t.getCdr().getCdr().getCdr().getCar();
		if (!cadddr.isNull()) {
			cadddr.print(n + 4, p);
		} 
		System.out.println(")");
    }
}
