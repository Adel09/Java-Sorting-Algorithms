import java.util.Random;
import java.util.Scanner;

public class Algorithms {

    static void bubbleSort(int[] arr) {
        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        long startTime = System.currentTimeMillis();
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\n");
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }


    public static void insertionSort(int array[]) {
        System.out.println("Array Before Insert Sort");
        for(int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        long startTime = System.currentTimeMillis();
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\n");
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        System.out.println("Array After Insertion Sort");
        for(int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you want in the array? ");
        int length = Integer.parseInt(in.nextLine());

        Random random = new Random();
        int arr[] = new int[length];
        for(int i = 0; i<length; i++){
            arr[i] = random.nextInt(100);
        }

        //bubbleSort(arr);//sorting array elements using bubble sort
        //insertionSort(arr);
        //selectionSort(arr);

        {
            Algorithms a = new Algorithms();
            System.out.println("\nBefore sorting array elements are - ");
            a.printMergeArray(arr, arr.length);
            long startTime = System.currentTimeMillis();

            a.mergeSort(arr, 0, arr.length - 1);
            System.out.println("\n");
            a.printMergeArray(arr, arr.length);

            long endTime = System.currentTimeMillis();

            System.out.println("That took " + (endTime - startTime) + " milliseconds");
        }



    }

    //Selection sort
    public static void selectionSort(int[] arr){
        System.out.println("Array Before Selection Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\n");
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        System.out.println("Array After Selection Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    //MERGE SORT
    /* Function to merge the subarrays of a[] */
    void merge(int a[], int beg, int mid, int end)
    {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        /* temporary Arrays */
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];

        i = 0; /* initial index of first sub-array */
        j = 0; /* initial index of second sub-array */
        k = beg;  /* initial index of merged sub-array */

        while (i < n1 && j < n2)
        {
            if(LeftArray[i] <= RightArray[j])
            {
                a[k] = LeftArray[i];
                i++;
            }
            else
            {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1)
        {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<n2)
        {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void mergeSort(int a[], int beg, int end)
    {

        if (beg < end)
        {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    /* Function to print the array */
    void printMergeArray(int a[], int n)
    {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

}
