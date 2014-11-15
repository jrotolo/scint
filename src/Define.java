import java.io.*;

class Define extends Special {
 
	public Define(Node t){

	}

    void print(Node t, int n, boolean p) {
    	  Printer.printDefine(t, n, p);
    }

    public Node eval(Node t, Environment env) { 
    	Node key = t.getCadr();
    	Node value = t.getCaddr();

    	if (key.isSymbol()) {
    		env.define(key, value);
    	} else {
    		Closure func = new Closure(new Cons(t.getCadr().getCdr(), t.getCddr()), env);
            env.define(key.getCar(), func);
    	}

    	return new StrLit("; no values returned");
    }
}
