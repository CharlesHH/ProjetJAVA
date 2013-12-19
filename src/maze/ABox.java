package maze;


public class ABox extends MBox {
	public ABox(int x, int y) {
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
		return true;
	}
	
	@Override
	public boolean isDepart(){
		return false;
	}

}
