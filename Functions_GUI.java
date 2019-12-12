package myMath;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Functions_GUI implements functions {

	Collection<function> collection = new ArrayList<function>(); //Configuring the ArrayList
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK}; 
	// Class Params
	int width,height,resolution;
	double[] RangeX = new double[2];
	double[] RangeY = new double[2];

//Start of Collection Methods wrapped with Try&Catch//
	
	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if(collection.contains(o))
			return true;
		return false;

	}

	@Override
	public Iterator<function> iterator() {
		return collection.iterator();
	}

	@Override
	public Object[] toArray() {
		try {
			collection.toArray();
		}
		catch(NullPointerException ex) {
			throw new NullPointerException("An NullPointerException occured, please re-check");
		}
		catch(  ArrayStoreException  ex ) {
			throw new ArrayStoreException("An ArrayStoreException occured, please re-check");
		}

		return collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		try {
			collection.toArray(a);
		}
		catch(NullPointerException ex) {
			throw new NullPointerException("An NullPointerException occured, please re-check");
		}
		catch(  ArrayStoreException  ex ) {
			throw new ArrayStoreException("An ArrayStoreException occured, please re-check");
		}
		return collection.toArray(a);
	}

	@Override
	public boolean add(function e) {
		try {
			collection.add(e);
		}
		catch(ClassCastException | NullPointerException | UnsupportedOperationException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		try {
			collection.remove(o);
		}
		catch(  NullPointerException | ClassCastException  ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		try {
			collection.containsAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException |IllegalStateException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		try {
			collection.addAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException  ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		try {
			collection.removeAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException  ex ) {
			return false;
		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		try {
			collection.retainAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException  ex ) {
			return false;
		}

		return true;
	}

	@Override
	public void clear() {
		try {
			collection.clear();
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException  ex ) {
			System.out.println("An error occured clearing the collection. Please check");
		}

	}
	
	//End of collection's Methods
	
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		SetParams(width,height,rx,ry,resolution);
		//Canvas and X&Y scales creation
		StdDraw.setCanvasSize(this.width, this.height);
		StdDraw.setXscale(this.RangeX[0] , this.RangeY[1]);
		StdDraw.setYscale(this.RangeY[0] , this.RangeY[1]);

		//X axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(this.RangeX[0], 0 , this.RangeX[1], 0);
		
	    //Y axis
		StdDraw.line(0, this.RangeY[0], 0, this.RangeY[1]);
		int funcNum=0; //giving each function a number
		Iterator<function> itr = collection.iterator();
		while(itr.hasNext()) { //Iterating over the collection and drawing each function.
			DrawFunction(itr.next(),funcNum);		
			funcNum++;
			collection.iterator().next();
		}
	}

	public void DrawFunction(function a,int funcNum) {
		double x_distance = Math.abs(this.RangeX[1] - this.RangeX[0]); //absolute distance
		double x_step = x_distance/this.resolution; // Calcing the Steps to draw
		double x_curr = this.RangeX[0];
		int col_num = (int)(Math.random() *7); //Randomizing a num 0-6 for the ColorArray.
		StdDraw.setPenColor(Colors[col_num]); //Setting the random color.
		StdDraw.setPenRadius(0.005); //Setting pen radius
		int sample_value = (int)(x_distance/x_step+1);
		//The actual x,y charts to draw
		double[] x = new double[sample_value];
		double[] y = new double[sample_value];

		//inserting values simultaneously  (x, f(x)
		for (int i = 0; i < sample_value; i++) {
			x[i] = x_curr;
			y[i] = a.f(x[i]);
			x_curr += x_step;
		}

		//Drawing the line  in the sample value range
		for (int i = 1; i < sample_value; i++) {
			StdDraw.line(x[i-1], y[i-1], x[i], y[i]);
		}
		//Output to screen
		System.out.println(funcNum+GetRGB(Colors[col_num]) + a.toString());

	}
	//Get RGB string to display form Color.
	public String GetRGB(Color color) {
		int R = color.getRed();
		int G = color.getGreen();
		int B = color.getBlue();
		String res = ") Java.awt.Color[r="+R+",g="+G+",b="+B+"] f(x)= ";
		return res;
	}

//Basic setter for this.variables
	public void SetParams(int width, int height, Range rx, Range ry, int resolution) {
		this.width = width;
		this.height = height;
		RangeX[0] =rx.get_min();
		RangeX[1] = rx.get_max();
		RangeY[0] = ry.get_min();;
		RangeY[1] = ry.get_max();
		this.resolution = resolution;
	}
	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initFromFile(String file) throws IOException {
	
		
	}

	@Override
	public void saveToFile(String file) throws IOException {
		String content = this.toString();
		try {
		Files.write( Paths.get(file), content.getBytes());
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException | SecurityException |IllegalArgumentException  ex ) {
			System.out.println("An Error occured during saveToFile execution. please check your ");
		}
		catch(IOException ex) {
			System.out.println("IOException Occured during saveToFile execution.");
		}
	}
	
	public String toString() {
		String result = "";
		Iterator<function> itr = collection.iterator();
		while(itr.hasNext()) {
			result += itr.next().toString() + "\n";
			collection.iterator().next();
		}
		return result;
		
	}
	//Check for balanced Parenthesis for each line
	//Part of the LineValidators
	public static boolean BalancedParenthesis(String line)
	 {
	 if (line.isEmpty())
	 return true;
	 
	 Stack<Character> ParentesisStack = new Stack<Character>();
	 for (int i = 0; i < line.length(); i++)
	 {
	 char current = line.charAt(i);
	 if (current == '(')
	 {
	 ParentesisStack.push(current);
	 }
	 if (current == ')')
	 {
	 if (ParentesisStack.isEmpty())
	 return false;
	 char last = ParentesisStack.peek();
	 if (current == ')' && last == '(')
	 ParentesisStack.pop();
	 else 
	 return false;
	 }
	 }
	 return ParentesisStack.isEmpty()?true:false;
	 }

}
