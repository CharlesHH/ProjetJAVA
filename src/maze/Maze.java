package maze;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import fr.enst.inf103.ui.MazeView;
import fr.enst.inf103.ui.MazeViewSource;




public class Maze implements GraphInterface, MazeViewSource {
	private final int Height;
	private final int Width;
	private MBox[][] maze;
	
	public Maze (int h, int w){
		this.Height = h;
		this.Width = w;
		this.maze = new MBox[w][h];
		
		for(int i = 0; i< Width ;i++){
			for(int j = 0; j<Height;j++){
				maze[i][j] = new EBox(i,j);
			}
		}
		
	}
	
	public Maze (MBox[][] maze ){
		this.maze = maze.clone();
		this.Width = maze[0].length;
		this.Height = maze.length;
	}

	@Override
	public double p(VertexInterface v1, VertexInterface v2) {
		MBox box1 = (MBox)v1;
		MBox box2 = (MBox)v2;
		
		String xy1 = box1.getLabel();
		String xString1 = xy1.split(",")[0];
		String yString1 = xy1.split(",")[1];
		int x1 = Integer.parseInt(xString1);
		int y1 = Integer.parseInt(yString1);	
		
		String xy2 = box2.getLabel();
		String xString2 = xy2.split(",")[0];
		String yString2 = xy2.split(",")[1];
		int x2 = Integer.parseInt(xString2);
		int y2 = Integer.parseInt(yString2);
		
		if(box1.isWall()==false && box2.isWall()==false){
			if (x1 == x2 && y1 == y2){
				return 0.0;
			}
			else if (Math.abs(x1-x2)+Math.abs(y1-y2)==1){
				return 1.0;
			}
		}
		
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> List = new ArrayList<VertexInterface>();
		
		
		for(int j = 0 ; j < Height ; j++){
			for(int i = 0 ; i < Width ; i++){
				if(maze[i][j].isEmpty()==true) List.add(maze[i][j]);
			}
		}
		
		return List;
	}

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface v) {
		ArrayList<VertexInterface> List = new ArrayList<VertexInterface>();
		String xy = v.getLabel();
		String xString = xy.split(",")[0];
		String yString = xy.split(",")[1];
		
		int x = Integer.parseInt(xString);
		int y = Integer.parseInt(yString);		
		
		if (x > 0 && x < Width-1){
			if(maze[x-1][y].isWall()==false) List.add(maze[x-1][y]);
			if(maze[x+1][y].isWall()==false) List.add(maze[x+1][y]);
		}
		else if (x == 0){
			if(maze[x+1][y].isWall()==false) List.add(maze[x+1][y]);
		}
		else if (x == Width-1){
			if(maze[x-1][y].isWall()==false) List.add(maze[x-1][y]);
		}
		
		
		if (y > 0 && y < Height-1){
			if(maze[x][y-1].isWall()==false) List.add(maze[x][y-1]);
			if(maze[x][y+1].isWall()==false) List.add(maze[x][y+1]);
		}
		else if (y == 0){
			if(maze[x][y+1].isWall()==false) List.add(maze[x][y+1]);
		}
		else if (y == Height-1){
			if(maze[x][y-1].isWall()==false) List.add(maze[x][y-1]);
		}
		
		
		return List;
	}
	
	public final void initFromTextFile(String fileName)
		throws MazeReadingException
	{
		
		try{
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
			
				String line;		
				for(int y=0; (line = br.readLine()) != null ; y++){
				
					if(y >= Height) throw new MazeReadingException(fileName,y+1,"Too many lines.");
				
					for(int x=0; x<line.length(); x++){
						if(x >= Width) throw new MazeReadingException(fileName,y+1,"Line too long.");
						else if(line.charAt(x) == 'E') maze[x][y]=new EBox(x,y);
						else if(line.charAt(x) == 'D') maze[x][y]=new DBox(x,y);
						else if(line.charAt(x) == 'W') maze[x][y]=new WBox(x,y);
						else if(line.charAt(x) == 'A') maze[x][y]=new ABox(x,y);
					}
				}
				try{
					br.close();
				}catch (Exception e){}
			
		} catch (MazeReadingException e){
			e.printMessage();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public final void saveToTextFile(String fileName){
		try{
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName)) ;
			
			for(int y = 0 ; y < Height; y++){
				for(int x = 0 ; x < Width; x++){
					if(maze[x][y].isWall()==true) pw.print('W');
					else if(maze[x][y].isDepart()==true) pw.print('D');
					else if(maze[x][y].isArrivee()==true) pw.print('A');
					else if(maze[x][y].isEmpty()==true) pw.print('E');
				}
				pw.println();
			}
		
			try{
				pw.close();
			}catch (Exception e){}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean drawMaze(Graphics arg0, MazeView arg1) {
		// A modifier pour overrider l'affichage de base
		return false;
	}

	@Override
	public int getHeight() {
		return this.Height;
	}

	@Override
	public String getSymbolForBox(int row, int column) {
		int x = column;
		int y = row;
		
		if(0 <= x && x < Width && 0 <= y && y < Height){
			if(maze[x][y].isArrivee()==true) return "A";
			else if(maze[x][y].isDepart()==true) return "D";
			else if(maze[x][y].isWall()==true) return "W";
			else if(maze[x][y].isEmpty()==true){
				if(maze[x][y].isHL()==true) return "*";
				else return "E";
			}
		}
		
		return null;
	}

	@Override
	public int getWidth() {
		return this.Width;
	}

	@Override
	public void setSymbolForBox(int row, int column, String symbol) {
		int x = column;
		int y = row;
		
		if(0 <= x && x < Width && 0 <= y && y < Height){
			if(symbol.equals("E")) maze[x][y]=new EBox(x,y);
			else if(symbol.equals("D")) maze[x][y]=new DBox(x,y);
			else if(symbol.equals("W")) maze[x][y]=new WBox(x,y);
			else if(symbol.equals("A")) maze[x][y]=new ABox(x,y);
			else if(symbol.equals("*")) maze[x][y]=new EBoxHL(x,y);
		}
	}

	@Override
	public boolean handleClick(MouseEvent mouseEvent, MazeView mazeView) {

		for(int j = 0 ; j < Height ; j++){
			for(int i = 0 ; i < Width ; i++){
				if(this.getSymbolForBox(j, i) =="*") this.setSymbolForBox(j, i, "E");
			}
		}
		
		if (this.maze == null) {
			return false;
		}
		
		double xClic = mouseEvent.getPoint().getX();
		double viewWidth = mazeView.getWidth();
		double xPos = (xClic / viewWidth) * this.Width;
		int xPosInt = (int)xPos;
		
		double yClic = mouseEvent.getPoint().getY();
		double viewHeight = mazeView.getHeight();
		double yPos = (yClic / viewHeight) * this.Height;
		int yPosInt = (int)yPos;
    
		String symbol = getSymbolForBox(yPosInt, xPosInt);
		
		if (symbol.equals("E") || symbol.equals("D") || symbol.equals("A")) {
			setSymbolForBox(yPosInt, xPosInt, "W");
		} else if (symbol.equals("W")) {
			setSymbolForBox(yPosInt, xPosInt, "E");
		}
		
		if ((mouseEvent.getModifiersEx() & MouseEvent.SHIFT_DOWN_MASK) == MouseEvent.SHIFT_DOWN_MASK) {
			if (symbol.equals("E")|| symbol.equals("A")|| symbol.equals("W")) {
				setSymbolForBox(yPosInt, xPosInt, "D");
			} else if (symbol.equals("D")) {
				setSymbolForBox(yPosInt, xPosInt, "A");
			}
		}

		mazeView.repaint();
		
		return true;
	}

	@Override
	public boolean handleKey(KeyEvent arg0, MazeView arg1) {
		// A changer pour overrider le default
		return false;
	}
	
	public void shortestPath(){
		int compteur = 0;
		MBox depart = null;
		MBox arrivee = null;
		
		ArrayList<VertexInterface> list = getAllVertices();
		for(VertexInterface v:list){
			MBox m = (MBox) v;
			if(m.isDepart()==true){
				if(compteur ==0){
					depart = m;
					compteur ++;
				}
				else return;
			}
		}
		
		compteur = 0;
		for(VertexInterface v2:list){
			MBox m2 = (MBox) v2;
			if(m2.isArrivee()==true){
				if(compteur ==0){
				 arrivee = m2;
				 compteur ++;
				}
				else return;
			}
		}
		
		ArrayList<VertexInterface> result = Dijkstra.dijkstra((GraphInterface) this, (VertexInterface) depart).shortPath((VertexInterface) arrivee);
		
		for(VertexInterface vr:result){
			MBox mr = (MBox)vr;
			
			String xy = mr.getLabel();
			String xString = xy.split(",")[0];
			String yString = xy.split(",")[1];
			int x = Integer.parseInt(xString);
			int y = Integer.parseInt(yString);	
			
			if(mr.isEmpty()==true&& mr.isArrivee() == false) this.setSymbolForBox(y, x, "*"); //le test permet de ne pas colorer l'arrivée (cf. Previous)
		}
	}

}
