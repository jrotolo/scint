import java.io.*;

class Set extends Special {
 
	public Set(Node t){

	}
	
    void print(Node t, int n, boolean p) {
    	Printer.printSet(t, n, p);
    }

    public Node eval(Node t, Environment env) {
    	return t;
    }

}
