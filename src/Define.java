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
        Environment localScope = new Environment(env);

    	if (key.isSymbol()) {
    		localScope.define(key, value);
    	} else {
    		Closure func = new Closure(t.getCdr().getCdr(), localScope);
    		localScope.define(key.getCar(), func);
    	}
        localScope.print(0);

    	return new StrLit("x has been defined.");
    }
}
