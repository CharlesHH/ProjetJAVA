import fr.enst.inf103.ui.MazeWindow;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		final int WIDTH;
		final int HEIGHT;
		
		for(String arg : args){
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
		
		MazeController mazeController = new MazeController(HEIGHT, WIDTH);
		MazeWindow mazeWindow = new MazeWindow("MonLaby", mazeController ) ;		
	}

}
