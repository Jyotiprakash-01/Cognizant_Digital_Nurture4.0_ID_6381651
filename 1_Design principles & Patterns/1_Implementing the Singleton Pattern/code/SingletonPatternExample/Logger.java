package SingletonPatternExample;

public class Logger {
	private static Logger logger=null;
	private Logger() {
		
	}
	public void logDetails(String str) {
		System.out.println(str);	
	}
	public static Logger getLogInstance() {
		if(logger==null) {
			logger=new Logger();
		}
		return logger;
	}
	
}
