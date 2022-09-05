import java.util.Random;
import java.util.Arrays;
public class calderon_ana_lab6{
	
	public static void main(String args[]) {
		
		int[] n = {2500, 5000, 10000, 20000, 40000};
		
		for(int i=0; i<n.length; i++) {
			int[] arr1 = getRandIntArray(n[i]);
			//sorts array
			Arrays.sort(arr1);
	
			//gives time starting from this point of code
			long startTime = System.nanoTime();
			//linear search_item1
			linearSearch(arr1, 50);
			// search 50 (this number is not in array)
			linearSearch(arr1, 200);
			// search a number outside the range (-10, 200)
			linearSearch(arr1, -10);
			linearSearch(arr1, 100);
			// search a number that is inside the array (100)
			
			//gives time after linearSearch is executed
			long stopTime = System.nanoTime();
			System.out.println("For array size: "+n[i]+" Execution time linear: "+(stopTime - startTime)/1000.0 + " microSec");
			
			startTime = System.nanoTime();
			// binary
			binarySearch(arr1, 50);
			// search 50 (this number is not in array)
			binarySearch(arr1, 200);
			// search a number outside the range (-10, 200)
			binarySearch(arr1, -10);
			binarySearch(arr1, 100);
			// search a number that is inside the array (100)
			stopTime = System.nanoTime();
			System.out.println("For array size: "+n[i]+" Execution time binary: "+(stopTime - startTime)/1000.0 + " microSec");
		}

	}
	
	public static int linearSearch(int[] arr, int search_item) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == search_item){
				return i;
			}
		}
		return -1;
	}
	
	public static void binarySearch(int[] arr, int search_item) {
		int low = 0;
		int high = arr.length-1;
		recursiveBinarySearch(arr, search_item, low, high);
	}
	
	public static int recursiveBinarySearch(int[] arr, int search_item, int low, int high){
		if(low > high){
			return -low -1;
		}

		int mid = (low+high)/2;
		if(search_item < arr[mid]){
			return recursiveBinarySearch(arr, search_item, low, mid-1);
		}else if(search_item == arr[mid]){
			return mid;
		}else{
			return recursiveBinarySearch(arr, search_item, mid+1, high);
		}
	}

	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static int[] getRandIntArray(int n) {
		//creates array
		int[] arr = new int[n];
		// Random array that doesn't contain 50
		for(int i=0; i<n; i++) {
			//generate random number in range
			int num = getRandomNumberInRange(1,100);
			if(num == 50) {
				num+=1;
			}
			arr[i]=num;
		}
		return arr;
	}
	
	
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        //creating object of random class
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}