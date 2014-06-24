package ui;


public interface MazeViewController
{

	public abstract MazeViewSource newMaze();

	public abstract MazeViewSource openMaze(String s);

	public abstract void saveMazeAs(String s);

	public abstract MazeViewSource getMazeViewSource();

	public abstract void calculateShortestPath();
}
