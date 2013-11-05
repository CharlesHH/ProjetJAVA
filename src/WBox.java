
public class WBox extends MBox{
	public WBox(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean isWall(){
		return true;
	}
}
