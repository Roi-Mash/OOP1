package Ex1;

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
		throw new IllegalArgumentException("An error occured, unrecognized Operation");

	}
	public Operation getOpFromString(String op) {

		op.toLowerCase();
		if(op.equals("plus"))
			return Operation.Plus;
		if(op.equals("mul")||op.equals("times"))
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
		if(op.equals("error"))
			return Operation.Error;


		throw new IllegalArgumentException("An error occured, unrecognized Operation");

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
		double y_l= 0;
		double y_r=left.f(x);;
		if(!(right==null)) {
				 y_r = right.f(x);
	}
		
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
			throw new IllegalArgumentException("An error occured, unrecognized Operation.");	
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
		s = s.replaceAll(" ","");
		if(!s.contains("(")) {
			function Poly = new Polynom(s);
			return Poly;
		}
		int i=0;
		String tempOp="";
		while(s.charAt(i)!='(') {
			tempOp += s.charAt(i);
			i++;
		}
		Operation tempy = getOpFromString(tempOp);
		int temp = i;
		i=(s.length()-1);
		int k=0;
		int j = 0;
		if(tempy==Operation.None) {
			j++;}
		while(i!=0) {
			if(s.charAt(i)==')') {
				k++;
			}
			if(s.charAt(i)==',') {
				j++;
			}
			if(j>0 && k>0 && k==j){
				if(!(tempy==Operation.None)) {
					function lefty = initFromString(s.substring(temp+1,i)).copy();	
					function righty = initFromString(s.substring(i+1,(s.length()-1))).copy();
					this.left=lefty;
					this.right=righty;
					this.op = tempy;
					break;}

				else {
					function lefty = initFromString(s.substring(temp+1,i)).copy();		
					this.left=lefty;
					this.right=null;
					this.op = tempy;
					break;
				}
			}

			i--;
		}



		return this;
	}

	public String toString() {
		String str = "";
		if(this.op != null&&this.right!=null) {
			str += OpToString(this.op) +"(" +this.left.toString();
			str += "," + this.right.toString();
		}
		else if(this.op != null&&this.right==null) {
			str+=this.left.toString();}
		else {
			str += this.toString();
		}
		str += ")";
		return str;
	}

}
