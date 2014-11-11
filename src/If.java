import java.io.*;

class If extends Special {

	public If(Node t){	}
    void print(Node t, int n, boolean p) {
    	  Printer.printIf(t, n, p);
    }

    public Node eval(Node t, Environment env) { return null; }
}
