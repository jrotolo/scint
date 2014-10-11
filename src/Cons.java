class Cons extends Node {
    private Node car;
    private Node cdr;
    private Special form;


    public Cons(Node a, Node d) {
    	car = a;
    	cdr = d;
    	parseList(car);
	 }

    // parseList() `parses' special forms, constructs an appropriate
    // object of a subclass of Special, and stores a pointer to that
    // object in variable form.  It would be possible to fully parse
    // special forms at this point.  Since this causes complications
    // when using (incorrect) programs as data, it is easiest to let
    // parseList only look at the car for selecting the appropriate
    // object from the Special hierarchy and to leave the rest of
    // parsing up to the interpreter.
    void parseList(Node a) {
		if (car.isSymbol()) {
	   	String name = car.getName();
			if (name.equals("quote")) form = new Quote();
			else if (name.equals("lambda")) form = new Lambda();
			else if (name.equals("begin")) form = new Begin();
			else if (name.equals("if")) form = new If();
			else if (name.equals("let")) form = new Let();
			else if (name.equals("cond")) form = new Cond();
			else if (name.equals("define")) form = new Define();
			else if (name.equals("set!")) form = new Set();
			else form = new Regular();
		} else {
	   	form = new Regular();	
		}
    }

	 public Node getCar() {
		if (car != null)
	 		return car;
		else
			System.err.println("Nothing in car!");
		return null;
	 }

	 public Node getCdr() {
		if (cdr != null)
			return cdr;
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
