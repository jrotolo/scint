import java.io.*;

class Define extends Special {
 
	public Define(Node t){

	}

    void print(Node t, int n, boolean p) {
    	  Printer.printDefine(t, n, p);
    }

    public Node eval(Node t, Environment env) { return null; }
}
