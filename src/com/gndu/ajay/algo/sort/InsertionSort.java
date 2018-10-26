package com.gndu.ajay.algo.sort;

public class InsertionSort {

	public static int[] doInsertionSort(int[] arr) {

		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				// if arr[5] < arr[4] then swap
				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String a[]) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doInsertionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}
	
}