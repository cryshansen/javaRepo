package test;

import java.util.Scanner;

public class BubblesSorting {

	  // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int moves=0;
        int l = a.length-1;
        int first = 0;
        int last = 0;
        int counter =0;



        while(a[0] !=1){
            for (int i = 0; i < l; i++) {
                
                    counter++;
                    if(counter<l){
                    // Swap adjacent elements if they are in decreasing order
                    System.out.println(" starts with: " + a[i] + "counter " + counter);
                        if (a[i] > a[counter]) {
                            moves++;
                            swap( i, counter,a);
                        System.out.println(a[i] + " to   " + a[counter]);
                            
                        }
                }
                System.out.println(" ends with: " + a[i]);
                
            }
    
        }
        System.out.println("Array is sorted in "+ moves + " swaps.");
        System.out.println("First Element: "+a[0]); 
        System.out.println("Last Element: "+a[l]); 
    }
    static void swap(int a, int b, int[] arr){
        int holder =0;
        //want b in a and a in b of array
        holder = arr[b];
        arr[b] = arr[a];
        arr[a] = holder;
    }

private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
        int aItem = Integer.parseInt(aItems[i]);
        a[i] = aItem;
    }

    countSwaps(a);

    scanner.close();
}




}
