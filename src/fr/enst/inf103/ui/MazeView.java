package fr.enst.inf103.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JPanel;

public class MazeView extends JPanel
					  implements MouseListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private HashMap<String, Color> boxColorMap;
	private MazeViewSource maze = null;
  
	public MazeView()
	{
		this(null);
	}
  
	public MazeView(MazeViewSource paramMazeViewSource)
	{
		this.maze = paramMazeViewSource;
		initBoxColorMap();
		addMouseListener(this);
	}
  
	private void initBoxColorMap()
	{
		this.boxColorMap = new HashMap();
		this.boxColorMap.put("D", Color.GREEN);
		this.boxColorMap.put("E", Color.WHITE);
		this.boxColorMap.put("W", Color.DARK_GRAY);
		this.boxColorMap.put("A", Color.RED);
		this.boxColorMap.put("*", Color.YELLOW);
	}
  
	public MazeViewSource getMazeViewSource()
	{
		return this.maze;
	}
  
	public void setMazeViewSource(MazeViewSource paramMazeViewSource)
	{
		this.maze = paramMazeViewSource;
		repaint();
	}
  
	public void paintComponent(Graphics paramGraphics)
	{
		if (this.maze == null) {
			return;
		}
		if (this.maze.drawMaze(paramGraphics, this)) {
			return;
		}
		int i = getWidth() / this.maze.getWidth();
		int j = getHeight() / this.maze.getHeight();
		for (int k = 0; k < this.maze.getHeight(); k++) {
			for (int m = 0; m < this.maze.getWidth(); m++)
			{
				Color localColor = (Color)this.boxColorMap.get(this.maze.getSymbolForBox(k, m));
				if (localColor == null) {
					localColor = Color.MAGENTA;
				}
				paramGraphics.setColor(localColor);
				paramGraphics.fillRect(m * i, k * j, i, j);
				paramGraphics.setColor(Color.BLACK);
				paramGraphics.drawRect(m * i, k * j, i, j);
			}
		}
	}
  
	public int getColumnForPoint(Point paramPoint)
	{
		int i = (int)paramPoint.getX();
		double d = getWidth() / this.maze.getWidth();
		return (int)(i / d);
	}
  
	public int getRowForPoint(Point paramPoint)
	{
		int i = (int)paramPoint.getY();
		double d = getHeight() / this.maze.getHeight();
		return (int)(i / d);
	}
  
	public void mouseClicked(MouseEvent paramMouseEvent)
	{
		if (this.maze == null) {
			return;
		}
		if (this.maze.handleClick(paramMouseEvent, this)) {
			return;
		}
		int i = getRowForPoint(paramMouseEvent.getPoint());
		int j = getColumnForPoint(paramMouseEvent.getPoint());
    
		String str1 = null;
		String str2 = this.maze.getSymbolForBox(i, j);
		if ((str2.equals("E")) || (str2.equals("D")) || (str2.equals("A"))) {
			str1 = "W";
		} else if (str2.equals("W")) {
			str1 = "E";
		}
		if ((paramMouseEvent.getModifiersEx() & 0x40) == 64) {
			if ((str2.equals("E")) || (str2.equals("A")) || (str2.equals("W"))) {
				str1 = "D";
			} else if (str2.equals("D")) {
				str1 = "A";
			}
		}
		this.maze.setSymbolForBox(i, j, str1);
		repaint();
	}
  
	public void mousePressed(MouseEvent paramMouseEvent) {}
  
	public void mouseReleased(MouseEvent paramMouseEvent) {}
  
	public void mouseEntered(MouseEvent paramMouseEvent) {}
  
	public void mouseExited(MouseEvent paramMouseEvent) {}
  
	public void keyTyped(KeyEvent paramKeyEvent) {}
  
	public void keyPressed(KeyEvent paramKeyEvent)
	{
		if (this.maze == null) {
			return;
		}
		if (this.maze.handleKey(paramKeyEvent, this)) {}
	}
  
	public void keyReleased(KeyEvent paramKeyEvent) {}
}