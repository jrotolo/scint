import java.io.*;

class Set extends Special {
 
	public Set(Node t){

	}
	
    void print(Node t, int n, boolean p) {
    	Printer.printSet(t, n, p);
    }

    // I Think this works not sure if im testing it right though.
    public Node eval(Node t, Environment env) {
    	Node key = t.getCdr().getCar();
    	Node value = t.getCdr().getCdr().getCar();
    	Node existingKey = env.lookup(key);
 
    	value = value.eval(env);

    	if (!(existingKey.isNull())) {
    		env.assign(existingKey, value);
    	} else {
    		System.out.println("Error: can't find bindings for given key.");
    	}
    	return null;
    }

}
