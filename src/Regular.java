import java.io.*;

class Regular extends Special {
    // TODO: Add any fields needed.


    // TODO: Add an appropriate constructor.
	 public Regular() {
		System.out.println("Regular Node Made");
		//n.print(1);
	 }

    void print(Node t, int n, boolean p) {
//	 	indent(n);
		//t.print(n, p);
		//System.out.println("In print(t,n,p) of regular.java ");
		if (!p)
			System.out.print("(");
		t.getCar().print(0);
	   if (!(t.getCdr().isNull()))	
			indent(1);
		t.getCdr().print(0, true);
    }

	 void print(int n, boolean p) {
	 	//System.out.println("In Regular.java");
	 }

}
