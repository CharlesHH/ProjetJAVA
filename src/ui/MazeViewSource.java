package ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface MazeViewSource
{

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract String getSymbolForBox(int i, int j);

    public abstract void setSymbolForBox(int i, int j, String s);

    public abstract boolean drawMaze(Graphics g, MazeView mazeview);

    public abstract boolean handleClick(MouseEvent mouseevent, MazeView mazeview);

    public abstract boolean handleKey(KeyEvent keyevent, MazeView mazeview);
}
