import java.util.ArrayList;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;


public class Maze implements GraphInterface {
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
				List.add(maze[i][j]);
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
	
	public final void initFromTextFile(String fileName){
		
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			while((ligne = br.readLine()) != null){
				System.out.println(ligne);
			}
			try{
				br.close();
			}catch (Exception e){}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
