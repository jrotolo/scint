import java.io.*;

class Define extends Special {
 
	public Define(Node t){

	}

    void print(Node t, int n, boolean p) {
    	  Printer.printDefine(t, n, p);
    }

    public Node eval(Node t, Environment env) { 
    	Node key = t.getCdr().getCar();
    	Node value = t.getCdr().getCdr().getCar();

    	if (key.isSymbol()) {
    		env.define(key, value);
    	} else {
    		Closure func = new Closure(t.getCdr().getCdr(), env);
    		env.define(key.getCar(), func);
    	}

    	return new StrLit("; no values returned");
    }
}
