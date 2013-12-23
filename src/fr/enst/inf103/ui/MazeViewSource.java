package fr.enst.inf103.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract interface MazeViewSource
{
	public abstract int getWidth();
  
	public abstract int getHeight();
  
	public abstract String getSymbolForBox(int paramInt1, int paramInt2);
  
	public abstract void setSymbolForBox(int paramInt1, int paramInt2, String paramString);
  
	public abstract boolean drawMaze(Graphics paramGraphics, MazeView paramMazeView);
  
	public abstract boolean handleClick(MouseEvent paramMouseEvent, MazeView paramMazeView);
  
	public abstract boolean handleKey(KeyEvent paramKeyEvent, MazeView paramMazeView);
}