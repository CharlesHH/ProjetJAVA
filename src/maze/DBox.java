package maze;

public class DBox extends MBox {
	public DBox(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean isWall(){
		return false;
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
		return true;
	}

}
