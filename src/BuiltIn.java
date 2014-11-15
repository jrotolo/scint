// BuiltIn.java -- the data structure for function closures

// Class BuiltIn is used for representing the value of built-in functions
// such as +.  Populate the initial environment with
// (name, new BuiltIn(name)) pairs.

// The object-oriented style for implementing built-in functions would be
// to include the Java methods for implementing a Scheme built-in in the
// BuiltIn object.  This could be done by writing one subclass of class
// BuiltIn for each built-in function and implementing the method apply
// appropriately.  This requires a large number of classes, though.
// Another alternative is to program BuiltIn.apply() in a functional
// style by writing a large if-then-else chain that tests the name of
// of the function symbol.
class BuiltIn extends Node {
    private Node symbol;
    protected static Environment interactionEnvironment = new Environment();

    public BuiltIn(Node s)		{ symbol = s; }

    public BuiltIn(Environment env) {
        interactionEnvironment = env;
    }

    public Node getSymbol()		{ return symbol; }

    public boolean isProcedure()	{ return true; }

    public void print(int n) {
	// there got to be a more efficient way to print n spaces
	for (int i = 0; i < n; i++)
	    System.out.print(' ');
	System.out.println("#{Built-in Procedure");
	symbol.print(n+3);
	for (int i = 0; i < n; i++)
	   System.out.print(' ');
	System.out.println('}');
    }

    public Node apply (Node args, Environment env) {
    	if (args == null) {
    		return null;
    	}

    	String symbolName = symbol.getName();
    	Node arg1 = args.getCar();
    	Node arg2 = args.getCadr();
        
        if (symbolName == "b+") {
        	if (arg1.isNumber() && arg2.isNumber()) {
            	return new IntLit(arg1.getValue() + arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number for (b+)");
        		return null;
        	}
        } else if (symbolName == "b-") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new IntLit(arg1.getValue() - arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number for (b-)");
        		return null;
        	}
        } else if (symbolName == "b*") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new IntLit(arg1.getValue() * arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number");
        		return null;
        	}
        } else if (symbolName == "b/") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new IntLit(arg1.getValue() / arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number");
        		return null;
        	}
        }  else if (symbolName == "b=") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new BooleanLit(arg1.getValue() == arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number");
        		return null;
        	}
        } else if (symbolName == "b<") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new BooleanLit(arg1.getValue() < arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number");
        		return null;
        	}
        } else if (symbolName == "b>") {
            if (arg1.isNumber() && arg2.isNumber()) {
            	return new BooleanLit(arg1.getValue() > arg2.getValue());
        	} else {
        		System.err.println("Error: Arguments must be a number");
        		return null;
        	}
        } else if (symbolName == "number?") {
            return new BooleanLit(arg1.isNumber());
        } else if (symbolName == "symbol?") {
            return new BooleanLit(arg1.isSymbol());
        } else if (symbolName == "car") {
        	if (arg1.isNull()) {
        		return arg1;
        	}
        	return arg1.getCar();
        } else if (symbolName == "cdr") {
        	if (arg1.isNull()) {
        		return arg1;
        	}
        	return arg1.getCdr();
        } else if (symbolName == "cons") {
        	return new Cons(arg1, arg2);
    	} else if (symbolName == "set-car!") {
    		arg1.setCar(arg2); return arg1;
    	} else if (symbolName == "set-cdr!") {
    		arg1.setCdr(arg2); return arg1;
    	} else if (symbolName == "null?") {
    		return new BooleanLit(arg1.isNull());
    	} else if (symbolName == "pair?") {
    		return new BooleanLit(arg1.isPair());
    	} else if (symbolName == "eq?") {
            if (arg1.isBoolean() && arg2.isBoolean()) {
                return new BooleanLit(arg1.getBoolean() == arg2.getBoolean());
            } else if (arg1.isNumber() && arg2.isNumber()) {
                return new BooleanLit(arg1.getValue() == arg2.getValue());
            } else if (arg1.isString() && arg2.isString()) {
                return new BooleanLit(arg1.getStrVal() == arg2.getStrVal());
            } if (arg1.isSymbol() && arg2.isSymbol()) {
                return new BooleanLit(arg1.getName() == arg2.getName());
            } else if (arg1.isNull() && arg2.isNull()) {
                return new BooleanLit(true);
    		} else if (arg1.isPair() && arg2.isPair()) {
                Node carArgs = new Cons(arg1.getCar(), new Cons(args.getCar(), Nil.getInstance()));
                Node cdrArgs = new Cons(arg1.getCdr(), new Cons(arg2.getCdr(), Nil.getInstance()));
                return new BooleanLit(false);
                //return new BooleanLit(apply(carArgs).getBoolean() && apply(cdrArgs).getBoolean());
            }
            return new BooleanLit(false);
    	} else if (symbolName == "procedure?") {
    		return new BooleanLit(env.lookup(arg1).isProcedure());
    	} else if (symbolName == "display" || symbolName == "eval") {
    		return arg1;
    	} else if (symbolName == "apply") {
    		return arg1.apply(arg2, env);
    	} else if (symbolName == "newline") {
            return new StrLit("");
        } else if (symbolName == "exit" || symbolName == "quit") {
            System.exit(0);
        } else if (symbolName == "write") {
            arg1.print(0);
        } else if (symbolName == "eval") {
            return arg1;
        } else if (symbolName == "read") {
            Parser parser = new Parser(new Scanner(System.in));
            return parser.parseExp();
        } else if (symbolName == "interaction-environment") {
            interactionEnvironment.print(0);
        } else {
            arg1.print(0);
            return Nil.getInstance();
        }

        return new StrLit("");
    } 
}
