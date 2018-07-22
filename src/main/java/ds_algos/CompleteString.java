package ds_algos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompleteString {
	private static Logger log = LoggerFactory.getLogger(CompleteString.class);
	
	private static Boolean checkAllChars(String input) {
		if(input.length()<26) {
			return false;
		}
		
		for(char ch = 'a'; ch< 'z'; ch++) {
			if(input.indexOf(ch) < 0 ) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		log.info("Value: "+ checkAllChars("qwertyuioplkjhgfdsazxcvbna"));
		
	}
}
