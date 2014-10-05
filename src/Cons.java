class Cons extends Node {
    private Node car;
    private Node cdr;
    private Special form;

    // parseList() `parses' special forms, constructs an appropriate
    // object of a subclass of Special, and stores a pointer to that
    // object in variable form.  It would be possible to fully parse
    // special forms at this point.  Since this causes complications
    // when using (incorrect) programs as data, it is easiest to let
    // parseList only look at the car for selecting the appropriate
    // object from the Special hierarchy and to leave the rest of
    // parsing up to the interpreter.
    void parseList(Node a) {
	 	if (isRegular(a))
			form = new Regular(a);
		else
			form = parseSpecial(a);
    }
	
	 private boolean isRegular(Node n) {
	 	if (n instanceof StrLit || n instanceof IntLit || n instanceof BooleanLit
			|| n instanceof Nil || n instanceof Cons)
			return true;
		else
			return false;
	 }

	 private Special parseSpecial(Node n) {
	 	Ident i = (Ident)n;
		String identName = i.getName();

		if (identName.equals("quote"))
			return new Quote();
		else if (identName.equals("lambda"))
			return new Lambda();
		else if (identName.equals("begin"))
			return new Begin();
		else if (identName.equals("if"))
			return new If();
		else if (identName.equals("cond"))
			return new Cond();
		else if (identName.equals("let"))
			return new Let();
		else if (identName.equals("define"))
			return new Define();
		else if (identName.equals("set!"))
			return new Set();
		else
			return new Regular(n);
	 }

    public Cons(Node a, Node d) {
    	car = a;
    	cdr = d;
    	parseList(car);
    }

	 public Node getCar() {
		if (this.car != null)
	 		return this.car;
		else
			System.err.println("Nothing in car!");
		return null;
	 }

	 public Node getCdr() {
		if (this.cdr != null)
			return this.cdr;
		else
			System.err.println("Nothing in cdr!");
    	return null; 
	 }

	 public void setCar(Node a) {
	 	this.car = a;
		parseList(a);
	 }

	 public void setCdr(Node d) {
	 	this.cdr = d;
	 }

    void print(int n) {
	   form.print(this, n, false);
    }

    void print(int n, boolean p) {
	   form.print(this, n, p);
    }
	 
	 public boolean isPair() {
	 	return true;	 
	 }

}
