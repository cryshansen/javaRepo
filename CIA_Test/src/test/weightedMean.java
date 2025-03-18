package test;
import java.io.*;
import java.util.*;

public class weightedMean {



	 private static final Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	    
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	           
	            
	            int tempMultipleVal=0;
	            int sum =0;
	            String[] mItems = scanner.nextLine().split(" ");
	             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            String[] wItems = scanner.nextLine().split(" ");
	             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	           

	             for (int i = 0; i < n; i++) {
	                int mItem = Integer.parseInt(mItems[i]);
	                int wItem = Integer.parseInt(wItems[i]);
	                int mult = (mItem * wItem);
	                tempMultipleVal = mult + tempMultipleVal;
	                sum = sum + wItem;
	                
	             }

	            scanner.close();
	    
	    
	      System.out.println((double)tempMultipleVal/sum);
	    
	    
	    
	    }
	}
	
	
	

