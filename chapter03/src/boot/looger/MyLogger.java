package boot.looger;

import java.util.logging.Logger;

public class MyLogger {
	
	public static void printLog(String str) {
		Logger logger = Logger.getLogger("myCustom Log");
		logger.warning(str);
	}

}
