package c19502146.pac;

import example.MyVisual;

class Main
{	


	public void cubes()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new TitisVisual());		
	}

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.cubes();			
	}
}