
import java.io.BufferedReader;
import java.io.FileReader;

import maze.Maze;
import maze.MazeReadingException;
import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;



public class MazeController implements MazeViewController{
	private Maze maze;
	
	public MazeController(int h, int w) {
		this.maze = new Maze(h,w);  //upon creation of a maze controller, a corresponding maze is created
	}
	
	@Override
	public MazeViewSource getMazeViewSource() {
		MazeViewSource mazeVS = (MazeViewSource) this.maze; //casting of the maze as a maze view source
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
		try{
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
			
				String line;
				int w=0;
				int h =0;
				for(int y=0; (line = br.readLine()) != null ; y++){
					if (y==0) {
						w = line.length(); //initialization of the laby's width depending of the file
					}
					else if(w != line.length()) throw new Exception("File format incorrect"); //if the file is not a rectangle , exception
					
					h=y+1;
				}
				try{
					br.close();
				}catch (Exception e){}
			
				this.maze = new Maze(h,w);	//the dimensions of the maze are adapted to correspond these specified in the file
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		try {
			maze.initFromTextFile(fileName); //the maze is initialized
		} catch (MazeReadingException e) {
			e.printMessage();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
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
