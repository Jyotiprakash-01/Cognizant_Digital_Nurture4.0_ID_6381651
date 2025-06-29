import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
public class LoggingTest {
	public static final Logger logger=LoggerFactory.getLogger(LoggingTest.class);
	public static void main(String[] args) {
		logger.error("This is an Error message");
		logger.warn("This is an Warning message");
	}

}
