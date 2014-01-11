import fr.enst.inf103.ui.MazeWindow;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		final int WIDTH;
		final int HEIGHT;
		
		for(String arg : args){  //Allow to specify the dimensions of the laby through the args
			i++;
		}
		if(i != 2) {
			WIDTH = 10;
			HEIGHT = 10;
		}
		else {
			WIDTH = Integer.parseInt(args[0]);
			HEIGHT = Integer.parseInt(args[1]);
		}
		
		MazeController mazeController = new MazeController(HEIGHT, WIDTH);  //creation of the maze controller
		MazeWindow mazeWindow = new MazeWindow("MonLaby", mazeController ) ;	//creation of the window	
	}

}
