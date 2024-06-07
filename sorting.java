import java.util.Arrays;

public class sorting {
	
	static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	//O(n^2) - O(1)
	static void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					swap(arr,i,j);
				}
			}
		}
	}
	//O(n^2) - O(1)
	static void insertionSort(int[] arr) {
		int n=arr.length;
		for(int i=1;i<n;i++) {
			int key=arr[i];   //take 0+1 th element as key
			int j=i-1;
			while(j>=0 && arr[j]>key) {  //sort until j=-1 and element greater than key
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;  //After sorting till first element move the key
		}
	}
	//O(n^2) - O(1)
	static void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int min=i;  //At first select an element as smallest element
			for(int j=i+1;j<n;j++) {  //find the smallest element in the remaining array
				if(arr[j]<arr[min]) min=j;
			}  //Then swap the smallest element to the front
			swap(arr,min,i);
		}
	}
	
	//O(nlogn) - O(n)
	static int[] mergeSort(int[] arr) {
		//it is the base condition if there is only one element just return array.
		if(arr.length==1) return arr;
		//find mid to split the array.
		int mid=arr.length/2;
		//we just need the copy array left and right.
		int[] left=mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		//send this 2 arrays to merge into one.
		return merge(left,right);
	}
	
	static int[] merge(int[] first, int[] second) {
		//we are going to store all the elements in this array.
		int[] mix=new int[first.length+second.length];
		//i and j to compare the elements.
		int i=0;
		int j=0;
		//k is for the index of mix array.
		int k=0;
		//while comparing the indexes of both arrays should not exceeds its length.
		while(i<first.length&&j<second.length) {
			if(first[i]<second[j]) {
				mix[k++]=first[i++];
			}else {
				mix[k++]=second[j++];
			}
		}
		//if there is more elements add it to the array(mix).
		while(i<first.length) {
			mix[k++]=first[i++];
		}
		while(j<second.length) {
			mix[k++]=second[j++];
		}
		return mix;
	}
	/*
	  9,6,3,6,1,3,6,7
	  9,6,3,6	1,3,6,7
	  9,6	3,6		1,3		6,7
	  9 6	3 6		1 3 	6 7
	  merge function;
	  merge(9,6),merge(3,6),merge(1,3),merge(6,7)
	  6,9	 3,6	1,3		6,7
	  merge((6,9),(3,6)),merge((1,3),(6,7))
	  3,6,6,9 	 1,3,6,7
	  1,3,3,6,6,6,7,9 
	*/
	
	static int partition(int[] arr,int low,int high) {
		int pivot=arr[high]; //assume as pivot
		int i=low-1;   //to know the position to swap
		for(int j=low;j<arr.length;j++) { //from low to end
			if(arr[j]<pivot) { //check if less than pivot
				i++;  //increase to swap
				swap(arr,i,j); //swap element which is smaller than pivot to front
			}
		}
		swap(arr,i+1,high); // swap pivot element to it's position (i+1) is the position of pivot 
		return i+1; //return position pivot to split the array
	}
	
	static void quickSort(int[] arr,int low,int high) {
		if(low<high) {  //base condition l<h
			int pi=partition(arr,low,high); //find the index of the pivot element
			quickSort(arr,low,pi-1);  //sort lesser than pivot
			quickSort(arr,pi+1,high);  //sort greater than pivot
		} 
	}
	
	public static void main(String[] args) {
		int[] arr= {9,1,8,2,7,3,6,4,5};
		int n=arr.length-1;
		//bubbleSort(arr);
		//insertionSort(arr);
		//selectionSort(arr);
		//arr=mergeSort(arr);
		//quickSort(arr,0,n);
		System.out.println(Arrays.toString(arr));
	}

}
