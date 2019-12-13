package myMath;
import java.awt.Color;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import com.google.gson.*;

public class Functions_GUI implements functions {

	Collection<function> collection = new ArrayList<function>(); //Configuring the ArrayList
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK}; 
	//* Class Parameters*//
	public int Width,Height,Resolution;
	public double[] Range_X = new double[2];
	public double[] Range_Y = new double[2];

	//*Start of all Collection Methods wrapped with Try&Catch//*
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

	//*End of all basic collection Methods//*

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		SetParams(width,height,rx,ry,resolution);
		//* Canvas and X&Y scales creation* //
		StdDraw.setCanvasSize(this.Width, this.Height);
		StdDraw.setXscale(this.Range_X[0] , this.Range_Y[1]);
		StdDraw.setYscale(this.Range_Y[0] , this.Range_Y[1]);
		/**
		 *	X axis
		 */
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(this.Range_X[0], 0 , this.Range_X[1], 0);
		/**
		 * Y axis
		 */
		StdDraw.line(0, this.Range_Y[0], 0, this.Range_Y[1]);
		int funcNum=0; //giving each function a number
		Iterator<function> itr = collection.iterator();
		while(itr.hasNext()) { //Iterating over the collection and drawing each function.
			DrawFunction(itr.next(),funcNum);		
			funcNum++;
			collection.iterator().next();
		}
	}

	public void DrawFunction(function a,int funcNum) {
		double x_distance = Math.abs(this.Range_X[1] - this.Range_X[0]); //absolute distance
		double x_step = x_distance/this.Resolution; // Calcing the Steps to draw
		double x_curr = this.Range_X[0];
		int col_num = (int)(Math.random() *7); //Randomizing a num 0-6 for the ColorArray.
		StdDraw.setPenColor(Colors[col_num]); //Setting the random color.
		StdDraw.setPenRadius(0.005); //Setting pen radius
		int sample_value = (int)(x_distance/x_step+1);
		/**
		 * The actual x,y charts to draw
		 */
		double[] x = new double[sample_value];
		double[] y = new double[sample_value];
		/**
		 * inserting values simultaneously  (x, f(x))
		 */
		for (int i = 0; i < sample_value; i++) {
			x[i] = x_curr;
			y[i] = a.f(x[i]);
			x_curr += x_step;
		}
		/**
		 * Drawing the line  in the sample value range
		 */
		for (int i = 1; i < sample_value; i++) {
			StdDraw.line(x[i-1], y[i-1], x[i], y[i]);
		}
		/**
		 * Output to screen
		 */
		System.out.println(funcNum+GetRGB(Colors[col_num]) + a.toString());

	} // End of DrawFunction

	/**
	 *Get RGB string to display form Color
	 */
	public String GetRGB(Color color) {
		int R = color.getRed();
		int G = color.getGreen();
		int B = color.getBlue();
		String res = ") Java.awt.Color[r="+R+",g="+G+",b="+B+"] f(x)= ";
		return res;
	}

	/*
	 * Basic setter for this.variables
	 */
	public void SetParams(int width, int height, Range rx, Range ry, int resolution) {
		this.Width = width;
		this.Height = height;
		Range_X[0] =rx.get_min();
		Range_X[1] = rx.get_max();
		Range_Y[0] = ry.get_min();;
		Range_Y[1] = ry.get_max();
		this.Resolution = resolution;
	}
	@Override
	public void drawFunctions(String json_file) {
		/*
		 * Creating a gson object with PrettyPrint(easier to read by user)
		 */
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			/*
			 * Creating a new FileReader session
			 */
			Reader readSession = new FileReader(json_file);
			/*
			 * Converting from JSON File to Java Object (using Json_GUI class)
			 */
			Json_GUI temp = gson.fromJson(readSession, Json_GUI.class);
			/*
			 * Setter to this.parameters
			 */
			SetFromJson(temp.Width,temp.Height,temp.Range_X,temp.Range_Y,temp.Resolution);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Helper function
	 */
	public void SetFromJson(int width, int height, double[] rx, double[] ry, int resolution) {
		this.Width = width;
		this.Height = height;
		this.Resolution = resolution;
		Range tempx = new Range(rx[0],rx[1]);
		Range tempy = new Range(ry[0],ry[1]);
		drawFunctions(this.Width,this.Height,tempx,tempy,this.Resolution);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		try{


			FileInputStream fileStream = new FileInputStream(file);


			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fileStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			this.collection.clear();

			while ((strLine = br.readLine()) != null) 	{
				if(lineChecker(strLine)==true){
					if(strLine.contains("(")) {
						ComplexFunction p1 = new ComplexFunction();
						this.add(p1.initFromString(strLine));
					}
					else {
						Polynom strLineP = new Polynom(strLine);
						this.add(strLineP);

					}
				}

			}


		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException | SecurityException |IllegalArgumentException  ex ) {
			System.out.println("Wrong String/Operation input, Please recheck.");
		}
	}


	private boolean lineChecker(String strLine) {
		ComplexFunction HellYeah = new ComplexFunction();
		HellYeah.initFromString(strLine);
		return true;
	}

	@Override
	public void saveToFile(String file) throws IOException {
		String content = this.toString();

		/*
		 * writing content to file using files+paths libs
		 */
		try {
			Files.write( Paths.get(file), content.getBytes());
		}
		/*
		 * Catching all relevant Exceptions
		 */
		catch( UnsupportedOperationException |NullPointerException | ClassCastException | SecurityException |IllegalArgumentException  ex ) {
			System.out.println("An Error occured during saveToFile execution. please check your ");
		}
		catch(IOException ex) {
			System.out.println("IOException Occured during saveToFile execution.");
		}
	}

	/*
	 * Iterating and printing each one of the functions in a newline.
	 */
	public String toString() {
		String result = "";
		Iterator<function> itr = collection.iterator();
		while(itr.hasNext()) {
			result += itr.next().toString() + "\n";
			collection.iterator().next();
		}
		return result;
	}

}
