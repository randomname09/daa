

// QuickSort using randomized and deterministic methods
import java.util.Arrays;
import java.util.Random;

class QuickSort{

	// deterministicQuickSort
	
	static void deterministicQuickSort(int arr[],int low,int high){

		if(low < high){

			int pivotIndex = deterministicPartition(arr,low,high);

			deterministicQuickSort(arr,low,pivotIndex-1);
			deterministicQuickSort(arr,pivotIndex+1,high);
		}
	}

	// deterministicPartition
	
	static int deterministicPartition(int arr[],int low,int high){

		int pivot = arr[high];
		int i = low - 1;

		for(int j = low; j < high;j++){

			if(arr[j] <= pivot){

				//swap arr[i] and arr[j];
			i++;	
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}

		}

		// swap arr[i+1] and arr[high]

		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// randomizedQuickSort
	
	static void randomizedQuickSort(int arr[],int low,int high){

		if(low < high){

			int pivotIndex = randomizedPartition(arr,low,high);

			randomizedQuickSort(arr,low,pivotIndex-1);
			randomizedQuickSort(arr,pivotIndex+1,high);

		}

		//return deterministicQuickSort(arr,low,high);
	}

	// randomizedPartition
	
	static int randomizedPartition(int arr[],int low,int high){

		Random rand = new Random();

		int randomIndex = rand.nextInt(high-low+1)+low;

		//swap arr[randomIndex] and arr[high];

		int temp = arr[randomIndex];
		arr[randomIndex] = arr[high];
		arr[high] = temp;

	return deterministicPartition(arr,low,high);

	}


	public static void main(String[] args){

		int arr[] = {12,35,3,56,23};
		
		System.out.println(Arrays.toString(arr));

		// deterministicQuickSort
		deterministicQuickSort(arr,0,arr.length-1);
		System.out.println("deterministic Array is: " + Arrays.toString(arr));

		// randomizedQuickSort
		int randArr[] = Arrays.copyOf(arr,arr.length-1);

		randomizedQuickSort(randArr,0,randArr.length-1);
		System.out.println("Randomized Array is : " + Arrays.toString(randArr));

	}
}






