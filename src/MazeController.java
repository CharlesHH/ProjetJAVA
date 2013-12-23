
import maze.Maze;
import maze.MazeReadingException;
import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;


public class MazeController implements MazeViewController{
	private Maze maze;
	
	public MazeController(int h, int w) {
		this.maze = new Maze(h,w);
	}
	
	@Override
	public MazeViewSource getMazeViewSource() {
		MazeViewSource mazeVS = (MazeViewSource) this.maze;
		return mazeVS;
	}

	@Override
	public MazeViewSource newMaze() {
		int h = maze.getHeight();
		int w = maze.getWidth();
		
		this.maze = new Maze(h,w);
		MazeViewSource mazeVS = (MazeViewSource) this.maze;
		
		return mazeVS;
	}

	@Override
	public MazeViewSource openMaze(String fileName) {
		try {
			maze.initFromTextFile(fileName);
		} catch (MazeReadingException e) {e.printStackTrace();}
		
		
		return (MazeViewSource) this.maze;
	}

	@Override
	public void saveMazeAs(String fileName) {
		maze.saveToTextFile(fileName);	
	}

	@Override
	public void calculateShortestPath() {
		this.maze.shortestPath();
	}

}
