import java.io.*;

class Begin extends Special {
 
	public Begin(Node t){
		
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printBegin(t, n, p);

    }

    // Not working right!
    public Node eval(Node t, Environment env) { 
    	Node exp = t.getCdr().getCar();
    	exp.getCar().eval(env);

    	if (exp.isNull()) {
    		return Nil.getInstance();
    	} else {
    		return (exp.getCdr().getCar().eval(env));
    	}

    }
}
