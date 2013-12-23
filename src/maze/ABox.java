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
		return true;
	}

	@Override
	public boolean isArrivee(){
		return true;
	}
	
	@Override
	public boolean isDepart(){
		return false;
	}
	
	@Override
	public boolean isHL() {
		return false;
	}

}
