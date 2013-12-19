package maze;

public class WBox extends MBox{
	public WBox(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean isWall(){
		return true;
	}
	
	@Override
	public boolean isEmpty(){
		return false;
	}
	
	@Override
	public boolean isArrivee(){
		return false;
	}

	@Override
	public boolean isDepart(){
		return false;
	}
}
