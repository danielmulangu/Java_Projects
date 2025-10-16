//Daniel Mulangu Kaseya
//dkaseya@unomaha.edu
//72826452

import javafx.util.Pair;
import java.util.*;

public class FindPair
{
	public static Pair <Integer, Integer> findPair(int [] array, int K, int type) {
		if (array == null) {
			return null;
		}

		int n = array.length;

		if (type == 0) {
			// implement your 0 (N^2) algorithm here.
			// you may want to make a funtion
			//function for O (N^2) algorithm
			return findPair0(array, K);
		} else if (type == 1) {
			// implement your 0 (N logN) algorithm here.
			// you may want to make a funtcion
			System.out.println("Implement your 0 (N logN) algorithm here.");
			return findPair1(array, K);
		} else if (type == 2) {
			// implement your 0 (N) algorithm here.
			// you may want to make a funtion
			//O (N) implementation
			return findPair2(array, K);
		} else {
			System.out.println("Not supported algorithm");
		}

		return null;
	}
	//Implementation of O(N^2) algorithm
	private static Pair<Integer, Integer> findPair0(int[] array, int K) {
        int n = array.length;
		//Started a nested loop
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
				// Check the summation of any two numbers that will be equal to K, the number provided in command line
                if (array[i] + array[j] == K) {
					System.out.println("Pair Found");
                    return new Pair<>(array[i], array[j]);
                }
            }
        }
		//The pair is not found return 0
		System.out.println("Pair Not Found");	
        return null;
    }

	//O(N logN) Implementation
	private static Pair<Integer, Integer> findPair1(int[] array, int K){
		//Sort the array first
		Arrays.sort(array);
		int l = 0;
        int r = array.length - 1;
		boolean flag = false;//Help check out if the pair is found
		while(l<r){
			int sum= array[l] + array[r];
			if(K==sum){
				System.out.println("Pair found "+ array[l]+" "+array[r]);
				flag= true;
				return new Pair<>(array[l], array[r]);

			}
			else if(sum<K){
				l++;/*If the sum generated in the function is less than the number provided in the command line move in
				the array from the left side*/
			}
			else{r--; //Otherwise move from right to left(from max element to min)
			}
		}
		if(flag==false){
			System.out.println("Pair Not Found");	//Pair Not found, flag remain false
		}

		return null;
	}

	// O(N) algorithm using a HashSet
    private static Pair<Integer, Integer> findPair2(int[] array, int K) {
        Set<Integer> hash = new HashSet<>();//Make a  hash set
        for (int num : array) {
            int diff = K - num;// Get the difference between K, and every number in the array
            if (hash.contains(diff)) {
				System.out.println("Pair Found");	
                return new Pair<>(num, diff);
            }
            hash.add(num);
        }
        return null;
    }

	public static int[] generateRandomNumbers(int cnt) {
		//This function will generate Integer array of which size is cnt.
		Random ran = new Random();
		int[] num = new int[cnt]; // Create an integer array of size Cnt
		for(int i = 0; i < cnt; i++) {
			num[i] = ran.nextInt(1000000);// Generate a random number between 0~999,999 for every number in the array
		}
		return num;
	}

	public static void printArray(int [] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            System.out.print(arr[index]);
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
		// The parameters from the execution will be used as parameters for the generateRandomNumbers function below.
	    // You must receive parameters, i.e., N, K, Algorithm from the command lines like below.
		// java FindPair 10000 500 0
		//Check if all parameters are provided
		if(args.length<3){
			System.out.println("Wrong parameters please provide java FindPair <N> <K> <Algorithm>");
			return;
		}
		int N = Integer.parseInt(args[0]);
		int K = Integer.parseInt(args[1]);
		int Algorithm = Integer.parseInt(args[2]);

		int [] arr = generateRandomNumbers (N);

		//Print numbers only when the cnt is less than 100
		if (arr != null && arr.length < 100) {
	        System.out.println("Generated numbers:");
	        printArray(arr);
	        System.out.println("\n");
		}

		// Timer Start
		long start_time = System.nanoTime();
		Pair <Integer, Integer> pair = findPair(arr, K, Algorithm);
		
		//Timer end
		long end_time = System.nanoTime();
		// Elapsed time
		long elapsed= end_time-start_time;
		//Print elapsed time for sorting. 
	    System.out.println("The pair is "+pair);	
		System.out.println("Time elapsed is"+elapsed+" nanoseconds");
    }
}