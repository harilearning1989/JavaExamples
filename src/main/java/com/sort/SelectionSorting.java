package com.sort;

public class SelectionSorting {

    public static void selectionSortArray(int[] ar){
        //find the minimum value from the array
        int temp = 0;
        for(int i=0;i<ar.length-1;i++){
            for(int j=i+1;j<ar.length;j++){
                if (ar[temp]>ar[j]) {
                    temp=j;
                }
            }
            int small=ar[temp];
            ar[temp] = ar[i];
            ar[i]=small;
        }
        for (int l=0;l<ar.length;l++){
            System.out.println(ar[l]);
        }
    }
    static void bubbleSortArray(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {5,4,3,6,8,2,3,8};
        //selectionSortArray(ar);
        bubbleSortArray(ar);

    }
}
