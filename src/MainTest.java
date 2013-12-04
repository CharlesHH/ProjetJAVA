
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
			throws MazeReadingException
	{
		// TODO Auto-generated method stub
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe2.txt");
	}

}
