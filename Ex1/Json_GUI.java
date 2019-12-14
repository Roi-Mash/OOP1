package Ex1;

public class Json_GUI {
	/*
	 * Class Parameters
	 */
	public int Width,Height,Resolution;
	public double[] Range_X = new double[2];
	public double[] Range_Y = new double[2];
	
	/*
	 * Class setters
	 */
	void set_width(int width) 
	{
		this.Width = width;
	}
	void set_height(int height) 
	{
		this.Height = height;
	}
	void set_resolution(int resolution) 
	{
		this.Resolution = resolution;
	}
	void set_RangeX(double[] RangeX) {
		for (int i = 0; i < RangeX.length; i++) {
			this.Range_X[i] = Range_X[i];
		}
	}
	void set_RangeY(double[] RangeY) {
		for (int i = 0; i < RangeY.length; i++) {
			this.Range_Y[i] = RangeY[i];
		}	
	}
	/*
	 * Class getters
	 */
	int get_width(int width) 
	{
		return this.Width;
	}
	int get_height(int height) 
	{
		return this.Height;
	}
	int get_resolution(int resolution) 
	{
		return this.Resolution;
	}
	double[] get_RangeX(double[] RangeX) {
		for (int i = 0; i < RangeX.length; i++) {
			this.Range_X[i] = RangeX[i];
		}
		return this.Range_X;
	}
	double[] get_RangeY(double[] RangeY) {
		for (int i = 0; i < RangeY.length; i++) {
			this.Range_Y[i] = RangeY[i];
		}
		return this.Range_Y;

	}



}//endofclass