
public abstract class MBox implements VertexInterface {
	private String xy;
	
	public MBox(int x,int y){
		String xString = Integer.toString(x);
		String yString = Integer.toString(y);
		this.xy = xString + "," + yString;
	}
	
	@Override
	public String getLabel(){
		return xy;
	}

	public abstract boolean isWall();
}
