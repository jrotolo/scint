import java.io.*;
class Ident extends Node {
	private String name;

	public Ident(String n) { name = n; }

	public void print(int n) {
		Printer.printIdent(n, name);

	}

	public Node eval(Node t, Environment env) {
		Node args;
		Node list = new Cons(new Ident(t.getName()), Nil.getInstance());
		args = evalList(list, env);

		if (!args.isNull()) {
			if (args.getCar().isPair()) {
				Printer.printQuote(args, 0, true);
			} else if (args.getCar().isNumber()) {
		  		return new IntLit(args.getCar().getValue());
			} else if (args.getCar().isString()) {
		  		return new StrLit(args.getCar().getStrVal());
			} else if (args.getCar().isBoolean()) {
		  		return new BooleanLit(args.getCar().getBoolean());
			} else {
		  		return Nil.getInstance();
			}
		} else { return null; }

		return new StrLit("");
	}

	public Node evalList(Node t, Environment env) {
		if (t == null || t.isNull()) {
			return new Cons(Nil.getInstance(), Nil.getInstance());
		} else {
			Node arg = t.getCar();
			Node rest = t.getCdr();

			if (arg.isSymbol()) {
				arg = env.lookup(arg);
			} else if (arg == null || arg.isNull()) {
				return Nil.getInstance();
			}
			return new Cons(arg.eval(env), evalList(rest, env));
		}
	}

	public boolean isSymbol() { return true; }
	public String getSymbol() { return name; }
	public String getName()   { return name; } 
}
