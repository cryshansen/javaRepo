package test;
import java.io.*;
import java.util.*;


public class Quartiles {



	private static final Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] c2Sort = new int[n];
	        int q1Range,q2Range,q3Range,midpoint=0;
	        String[] cItems = scanner.nextLine().split(" ");
	       
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int median1,median2,median3=0;
	        

	        for (int i = 0; i < n; i++) {
	                //Arrays.sort();
	                //finds median of array as 2nd quartile 
	                c2Sort[i]= Integer.parseInt(cItems[i]);
	        }
	         Arrays.sort(c2Sort);



	        midpoint = n%2; //if this is 1 means its a midpoint else must get two values below and it
	        q2Range = n/2;
	        q1Range = n/4;
	        q3Range = (n - q2Range);
	        q3Range = (q3Range/2) + q2Range;
	       
	       if(midpoint==1){
	           //range is first half and last half with omission of middle so, second half is q2Range+1 ->end of line n is end of line so, array in question is, from midpoint +1 to n

	           //odd number of data points, 
	           //we do not include the median (the central value in the ordered list) 
	           //in either half: total the two halves q1 and q3
	           median1 = (c2Sort[q1Range-1] + c2Sort[q1Range])/2;
	            median2 = c2Sort[q2Range] ;
	            median3 = (c2Sort[q3Range+1]  + c2Sort[q3Range])/2;
	           
	       }else{
	           //even number of data points and assume that makes the first and third even 
	            median1 = c2Sort[q1Range];
	            median2 = (c2Sort[q2Range-1] + c2Sort[q2Range])/2;
	            median3 = c2Sort[q3Range];
	       }
	      
	        System.out.println(median1);
	        System.out.println(median2);
	        System.out.println(median3);
	        
	    }
	}	
	
	
	
	
	
	
	

