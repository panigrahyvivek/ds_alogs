package ds_algos;

import java.util.Stack;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReverseString {
	
	private static Logger log = LoggerFactory.getLogger(ReverseString.class);

	public static void main(String args[]) {
		String str = "helloworld!";
		log.info(new StringBuilder(str).reverse().toString());
		
		String sentence = "Master Yoda is the best!";
		Stack<String> myStack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(sentence, " ");
		
		while(st.hasMoreTokens()) {
			myStack.push(st.nextToken());
		}
		
		StringBuilder reverseSenetence = new StringBuilder();
		
		while(!myStack.isEmpty()) {
			reverseSenetence.append(myStack.pop() + " ");
		}
		
		log.info(reverseSenetence.toString());
		
	}
}
