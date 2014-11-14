import java.io.*;

class Set extends Special {
 
	public Set(Node t){

	}
	
    void print(Node t, int n, boolean p) {
    	Printer.printSet(t, n, p);
    }

    public Node eval(Node t, Environment env) {
    	Node key = t.getCdr().getCar();
    	Node value = t.getCdr().getCdr().getCar();
    	Node existingKey = env.lookup(key);
    	System.out.println("Key before set: "+env.lookup(key).getValue());
 
    	value = value.eval(env);

    	if (!(existingKey.isNull())) {
    		env.assign(key, value);
    		System.out.println("Key after set: "+env.lookup(key).getValue());
    	} else {
    		System.out.println("Error: can't find bindings for given key.");
    	}

    	return new StrLit("#{Unspecific}");
    }

}
