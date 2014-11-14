import java.io.*;

class Cond extends Special {

	public Cond(Node t){

	}
    void print(Node t, int n, boolean p) { 
    	Printer.printCond(t, n, p);
    }

    public Node eval(Node t, Environment env) { 
    	Node exp = t.getCdr();

    	while ((!(exp.getCaar().eval(env).getBoolean()) && (!exp.isNull()))) {
    		exp = exp.getCdr();
    	}

    	return (exp.isNull()) ? null : exp.getCar().getCadr().eval(env);
    }
}
