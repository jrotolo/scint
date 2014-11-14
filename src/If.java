import java.io.*;

class If extends Special {

	public If(Node t){	}
    void print(Node t, int n, boolean p) {
    	  Printer.printIf(t, n, p);
    }

    public Node eval(Node t, Environment env) { 
    	Node cond = t.getCdr().getCar();
    	Node ifClause = t.getCdr().getCdr().getCar();
    	Node elseClause = t.getCdr().getCdr().getCdr().getCar();
    	Node value = null;

    	return (cond.eval(env).getBoolean()) ? ifClause.eval(env) : elseClause.eval(env);
    }
}
