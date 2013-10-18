
public class Maze {
	private int Height;
	private int Width;
	private MBox[][] maze;
	
	public Maze (int h, int w){
		this.Height = h;
		this.Width = w;
		this.maze = new MBox[w][h];
	}
	
	public Maze (MBox[][] maze ){
		this.maze = maze.clone();
		this.Width = maze.length;
		this.Height = maze[0].length;
	}
	
}
