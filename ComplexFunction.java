package myMath;

//this class written all by us
public class ComplexFunction implements complex_function{
	function left;
	function right;
	Operation op;

	public ComplexFunction() {
		this.left = null;
		this.right = null;
		this.op = Operation.None;

	}

	public ComplexFunction(function f1){
		this.left =f1.copy();
		this.right = null;
		this.op = Operation.None;

	} 

	public ComplexFunction(String op , function left , function right){
		this.left = left;
		this.right = right;
		this.op = getOpFromString(op);
	} 
	//	Plus, Times, Divid, Max, Min, Comp , None, Error

	public ComplexFunction(Operation op, function left, function right) {
		this.left=left;
		this.right = right;
		this.op = op ;		
	}
	

	public String OpToString(Operation p) {
		Operation O = p;
		
		switch(O) {

		case Plus:
			return "plus";
		case Times:
			return "times";
		case Divid: 
			return "div";
		case Max:
			return "max";
		case Min:	 
			return "min";
		case Comp:
			return "comp";
		case None:           
			return "none"; 
		case Error:
			return "error";

		}
		return "";
	}
	public Operation getOpFromString(String op) {

		op.toLowerCase();
		if(op.equals("plus"))
			return Operation.Plus;
		if(op.equals("times"))
			return Operation.Times;
		if(op.equals("div") || op.equals("divid"))
			return Operation.Divid;
		if(op.equals("max"))
			return Operation.Max;
		if(op.equals("min"))
			return Operation.Min;
		if(op.equals("comp"))
			return Operation.Comp;
		if(op.equals("none"))
			return Operation.None;
		return Operation.Error;
	}

	@Override
	public void plus(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Times;		
	}

	@Override
	public void div(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Divid;		
	}

	@Override
	public void max(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Max;		
	}

	@Override
	public void min(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Min;		
	}

	@Override
	public void comp(function f1) {
		left = this.copy();
		right = f1.copy();
		this.op = Operation.Comp;

	}

	@Override
	public double f(double x) {
		double y = 0 ;
		double y_l = left.f(x) , y_r = right.f(x);
		Operation O = this.getOp();
		switch(O) {

		case Plus:
			y = y_l+y_r;
			break;

		case Times:
			y = y_l*y_r;
			break;

		case Divid:
			y = y_l/y_r;
			break;

		case Max:
			if (y_l>y_r)
				y=y_l;
			else
				y=y_r;
			break;

		case Min:
			if (y_l>y_r)
				y=y_r;
			else
				y=y_l;
			break;

		case Comp:
			y = left.f(y_r);
			break;

		case None:           
			left.f(x); 
			break;

		case Error:
			//throw exception
			break;	
		}
		return y;
	}

	@Override
	public function copy() {
		if(this.right != null) {
			ComplexFunction cf = new ComplexFunction(this.op , this.left,this.right);
			return cf;
		}		
		else {
			return this.left;
		}
	}

	@Override
	public function left() {
		return this.left;
	}

	@Override
	public function right() {
		return this.right;
	}

	@Override
	public Operation getOp() {
		return this.op;
	}

	@Override
	public function initFromString(String s) {
		Polynom p = new Polynom(s);
		this.left = p.copy();
		this.right = new Polynom();
		this.op = op.None;

		return this;
	}

	public String toString() {
		String str = "";
		if(this.op != null) {
			str += OpToString(this.op) +"(" +this.left.toString();
			str += "," + this.right.toString();
		}
		else {
			str += this.toString();
		}
		str += ")";
		return str;
	}

}
