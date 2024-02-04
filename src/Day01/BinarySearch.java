package Day01;

public class BinarySearch {

    // METHOD
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else return middle;
        }
        return -1;
    }


// practicing

    public static int binarySearchCopy(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int BS(int[] arr,int target){
        int start =0;
        int end = arr.length-1;
        while (start <= end){
            int middle = start + (end-start)/2;
            if (target < arr[middle]){
                end = middle-1;
            }
            else if (start > arr[middle]){
                start = middle+1;
            }else return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        System.out.println(binarySearch(arr,target));
    }
    //


}
