package maze;

public class EBoxHL extends MBox{
	public EBoxHL(int x, int y) {
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
		return false;
	}
	
	@Override
	public boolean isDepart(){
		return false;
	}

	@Override
	public boolean isHL() {
		return true;
	}
}
