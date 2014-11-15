import java.io.*;

class Set extends Special {
 
	public Set(Node t){

	}
	
    void print(Node t, int n, boolean p) {
    	Printer.printSet(t, n, p);
    }

    public Node eval(Node t, Environment env) {
    	Node key = t.getCadr();
    	Node value = t.getCaddr();
    	Node existingKey = env.lookup(key);
 
    	value = value.eval(env);

    	if (!(existingKey.isNull())) {
    		env.assign(key, value);
            return new StrLit("#{Unspecific}");
    	} else {
    		return new StrLit("Error: can't find bindings for given key.");
    	}

    }

}
