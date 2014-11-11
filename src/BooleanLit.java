import java.io.*;
class BooleanLit extends Node {
  private boolean booleanVal;
  private static BooleanLit True=null;
  private static BooleanLit False=null;
  
  public BooleanLit(boolean b) {
    booleanVal = b;
  }
  
  public static BooleanLit getInstance(boolean val){
  		if(val==true){
  			if(True==null)
  				True=new BooleanLit(true);
  			return True;
   		}
  		else{
  			if(False==null)
  				False=new BooleanLit(false);
  			return False;
  		}
  }
 
   public void print(int n) {
   	
   	if(booleanVal)
   		Printer.printBoolLit(n, 1);
   	else
   		Printer.printBoolLit(n, 0);
  }

  public boolean getValue() {
    return booleanVal;
  }
  
  public Node eval(Environment env) {
    return this;
  }
  

  public boolean isBoolean()   { return true; }

}
