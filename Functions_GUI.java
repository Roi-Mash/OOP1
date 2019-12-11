package myMath;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import myMath.Range;
public class Functions_GUI implements functions {

	Collection<function> collection = new ArrayList<function>(); //Configuring the ArrayList
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK}; 
	//params
	int width,height,resolution;
	double[] RangeX = new double[2];
	double[] RangeY = new double[2];


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
			System.out.println("An error occured. please check");
		}

	}

	
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		SetParams(width,height,rx,ry,resolution);
		StdDraw.setCanvasSize(this.width, this.height);
		StdDraw.setXscale(this.RangeX[0] , this.RangeY[1]);
		StdDraw.setYscale(this.RangeY[0] , this.RangeY[1]);
		////////vertical lines
//		StdDraw.setPenColor(Color.LIGHT_GRAY);
//		for (int i = 0; i <= 100; i=i+10) {
//			StdDraw.line(this.RangeX[0] , this.RangeY[0], this.RangeX[1], this.RangeY[1]);
//		}
		//////horizontal lines
//		for (double i = minY; i <= maxY; i=i+0.5) {
//			StdDraw.line(0, i, Math.PI, i);
//		}
		////////x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(this.RangeX[0], 0 , this.RangeX[1], 0);
		
		////////y axis
		StdDraw.line(0, this.RangeY[0], 0, this.RangeY[1]);
//		
//		//end
		Iterator<function> itr = collection.iterator();
		while(itr.hasNext()) {
			DrawFunction(itr.next());			
			collection.iterator().next();
		}
	}

	public void DrawFunction(function a) {
		double x_distance = Math.abs(this.RangeX[1] - this.RangeX[0]);
		double x_step = x_distance/this.resolution;
		double x_curr = this.RangeX[0];
		int col_num = (int)(Math.random() *7);
		System.out.println(col_num);
		StdDraw.setPenColor(Colors[col_num]);
		StdDraw.setPenRadius(0.005);

		int sample_value = (int)(x_distance/x_step+1);
		double[] x = new double[sample_value];
		double[] y = new double[sample_value];

		for (int i = 0; i < sample_value; i++) {
			x[i] = x_curr;
			y[i] = a.f(x[i]);
			x_curr += x_step;
		}

		for (int i = 1; i < sample_value; i++) {
			StdDraw.line(x[i-1], y[i-1], x[i], y[i]);
		}
	}

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
		
		
	}

}
