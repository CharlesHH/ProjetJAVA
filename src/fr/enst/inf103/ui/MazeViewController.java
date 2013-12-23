package fr.enst.inf103.ui;

public abstract interface MazeViewController
{
	public abstract MazeViewSource newMaze();
  
	public abstract MazeViewSource openMaze(String paramString);
  
	public abstract void saveMazeAs(String paramString);
  
	public abstract MazeViewSource getMazeViewSource();
  
	public abstract void calculateShortestPath();
}