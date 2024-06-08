//O(log n) - O(1)
public class binarySearch {
	static int BinarySearch(int[] arr,int l,int r,int x) {
		if(r>=l) {
			int mid = l+(r-l)/2;
			if(arr[mid]==x) return mid;
			if(arr[mid]>x) return BinarySearch(arr,0,mid-1,x);
			return BinarySearch(arr,mid+1,r,x);
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
		int x=5;
		System.out.println(BinarySearch(arr,0,arr.length-1,x));
	}
}
