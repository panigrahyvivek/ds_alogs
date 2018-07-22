package ds_algos;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicatesInArray {
	
	private static Logger log = LoggerFactory.getLogger(DuplicatesInArray.class);
	
	public static void main(String args[]) {
		Integer[] array = {1,2,3,4,4,5,5,6,7,8};  //input 1
        int size = array.length;              //input 2
          
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> duplicates = new HashSet<Integer>();
           
        for(int i = 0; i < size ; i++)
        {
            if(set.add(array[i]) == false)
            {
                duplicates.add(array[i]);
            }
        }
          
        if(duplicates.size() == 0)
        {
            duplicates.add(-1);
        }
          
        log.info(""+duplicates);
	}

}
