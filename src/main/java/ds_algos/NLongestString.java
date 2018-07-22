package ds_algos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NLongestString {
	private static Logger log = LoggerFactory.getLogger(NLongestString.class);
	
	
	private static List<String> findNthLongestElement(List<String> inputs, int n){
		TreeMap<Integer, List<String>> tm = new TreeMap<>(); 
		
		for(String str: inputs) {
			Integer len = str.length();
			List<String> tempList = tm.get(len) != null ? tm.get(len): new ArrayList<String>();
			tempList.add(str);
			tm.put(len, tempList);
					
		}
		
		log.info(tm.toString());
		log.info(tm.descendingKeySet().toString());
		return tm.get(tm.descendingKeySet().toArray()[n-1]);
	}
	
	public static void main(String args[]) {
		List<String> inputs = new ArrayList<String>();
		inputs.add("hello");
		inputs.add("world");
		inputs.add("panigrahy");
		inputs.add("viv");
		inputs.add("chintu");
		
		log.info(""+ findNthLongestElement(inputs, 3));
		
	}
	
}
