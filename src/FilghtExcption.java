public class FilghtExcption extends Exception{
private String msg;
	
	public FilghtExcption(String msg) {
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	} 

}
