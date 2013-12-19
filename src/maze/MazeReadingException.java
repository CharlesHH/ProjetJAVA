package maze;

public class MazeReadingException extends Exception {
	private final String fileName;
	private final int line;
	private final String message;
	
	public MazeReadingException(String fileName, int line, String message){
		this.message = message;
		this.fileName = fileName;
		this.line = line;
	}
	
	public void PrintMessage(){
		System.out.println("Exception while reading" + fileName + ":");
		System.out.println("	Line "+ line +": "+ message);
	}
}
