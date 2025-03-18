package test;
import java.io.*;
import java.util.*;

public class Day0MeanMedianMode {


	    private static final Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	       
	        int[] c2Sort = new int[n];

	        String[] cItems = scanner.nextLine().split(" ");
	        //Arrays.sort(cItems);
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        int m = cItems.length;
	        double mean = 0; double median=0;
	        double total=0;
	        int mode=0;
	        int meanRange = n/2;
	        int modeCounter =0;
	        
	        for (int i = 0; i < cItems.length; i++) {
	            int cItem = Integer.parseInt(cItems[i]);
	            c2Sort[i] = cItem;
	            total = cItem + total;
	            if(i == 0){mode = cItem;}
	            if(cItem<mode){ mode = cItem;
	            }else if(cItem == mode){
	                modeCounter++;
	                //looking for the amount of times the value occures in the sample set.
	                }
	        }
	  
	        scanner.close();
	        
	        
	        mean = total/n;
	        Arrays.sort(c2Sort);

	        //iff odd then only middle value
	        if((n%2)==0){ 
	            median = ((double)(c2Sort[meanRange-1] + c2Sort[meanRange]))/2;
	        }else {
	            median = (double)c2Sort[meanRange];
	         }
	        if(modeCounter > 1){
	            // means the value of mode appears more than once. 
	            // mode is to output how many occurances but it is not working
	             mode = modeCounter; 

	        }
	           
	        System.out.println(mean);
	        System.out.println(median);
	        System.out.println(mode); 


	    }
	}


int n = scanner.nextInt();
scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

int[] c2Sort = new int[n];

String[] cItems = scanner.nextLine().split(" ");
//Arrays.sort(cItems);
scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
int m = cItems.length;
double mean = 0; double median=0;
double total=0;
int mode=0;
int meanRange = n/2;
int modeCounter =0;
int topMCount=0;
int modeVal =0;
for (int i = 0; i < cItems.length; i++) {
    int cItem = Integer.parseInt(cItems[i]);
    c2Sort[i] = cItem;
    total = cItem + total;

    if(cItem == mode){
        modeCounter++;
     }

    if(i == 0){
        mode = cItem;
    }
    if ( ( modeCounter > topMCount || modeCounter == topMCount) && cItem < mode) {     //means hit end of same mode/item value
        
            mode = cItem;
    
        topMCount = modeCounter;
    }
}

scanner.close();


mean = total/n;
Arrays.sort(c2Sort);

//iff odd then only middle value
if((n%2)==0){ 
    median = ((double)(c2Sort[meanRange-1] + c2Sort[meanRange]))/2;
}else {
    median = (double)c2Sort[meanRange];
 }
	

