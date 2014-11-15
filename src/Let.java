import java.io.*;

class Let extends Special {

	public Let(Node t){ }

    void print(Node t, int n, boolean p) {
    	Printer.printLet(t, n, p);
    }

    public Node eval(Node t, Environment env) { 
    	Node args = t.getCadr();
    	Node exp = t.getCaddr();
    	Environment localEnv = new Environment(env);

    	args = evalBody(args, localEnv);
    	return exp.eval(localEnv);
    }

    public Node evalBody(Node t, Environment env) {
    	if (t == null || t.isNull()) {
			Node list = new Cons(Nil.getInstance(), Nil.getInstance());
			return list;
		} else {
			Node arg, exp, rest;
			arg = t.getCaar();
			exp = t.getCar().getCadr();
			rest = t.getCdr();

			if (arg.isSymbol()) {
				env.define(arg, exp.eval(env));
				return evalBody(rest, env);
			} else if (arg.isPair()) {
				return arg.eval(env);
			} else if (arg == null || arg.isNull()) {
				return Nil.getInstance();
			}
		}
		return null;
    }
}
