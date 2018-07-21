package ds_algos;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import utils.RandomGenerator;


public class ThreeSum {
	private static Logger log = LoggerFactory.getLogger(ThreeSum.class);
	
	private static void printAll (int[] ar ) {
		int len = ar.length;
		for(int i=0; i<len ; i++){
			for(int j=i+1; j<len; j++) {
				for(int k=j+1; k<len; k++) {
					int sum = ar[i]+ar[j]+ar[k];
					if(ar[i]+ar[j]+ar[k] == 0) {
						log.info(ar[i] +"/"+ ar[j] + "/" + ar[k]);
					}
				} 
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("Hello world!!");
		
		StopWatch watch = new StopWatch();
		watch.start("ThreeSum Problem");
		int[] ar= RandomGenerator.getStreamOfRandomIntsWithRange(-100,100,150).toArray();
		printAll(ar);
		watch.stop();
		log.info("Complete: " + watch.getLastTaskName() + ": "+ watch.getTotalTimeMillis());
		
	}
	
}
