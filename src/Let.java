import java.io.*;

class Let extends Special {

	public Let(Node t){ }

    void print(Node t, int n, boolean p) {
    	Printer.printLet(t, n, p);
    }

    public Node eval(Node t, Environment env) { return null; }
}
