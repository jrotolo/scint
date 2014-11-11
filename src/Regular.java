import java.io.*;

class Regular extends Special {
 
    // TODO: Add any fields needed.

    
    // TODO: Add an appropriate constructor.

    public Regular(Node t){

	}

    void print(Node t, int n, boolean p) {
    	  Printer.printRegular(t, n, p);
    } 

    public Node eval(Node t, Environment env) { 
    	Node first = t.getCar();
    	Node args = t.getCdr();

    	while ( first.isSymbol() ) {
			first = env.lookup(first);
    	}

    	if (first.isNull() || first == null) {
    		return null;
    	}
    	
    	if (first.isProcedure()) {
    		return first.apply(args);
    	} else {
    		return first.eval(env).apply(args);
    	} 
    }   
}
