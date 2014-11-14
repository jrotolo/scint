import java.io.*;

class Begin extends Special {
 
	public Begin(Node t){
		
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printBegin(t, n, p);

    }

    public Node eval(Node t, Environment env) { 
    	Node exp = t.getCdr();
    	Node value = exp.getCar().eval(env);
    	exp = exp.getCdr();

    	while (!exp.isNull()) {
    		value = exp.getCar().eval(env);
    		exp = exp.getCdr();
    	}

    	return value;
    }
}
