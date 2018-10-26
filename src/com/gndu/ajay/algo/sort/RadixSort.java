package com.gndu.ajay.algo.sort;

public class RadixSort {

	/** Radix Sort function **/
	public static void sort(int[] a) {
		int i, m = a[0], exp = 1, n = a.length;

		int[] b = new int[n];

		// Loop to assign the largest value to m
		for (i = 1; i < n; i++)
			if (a[i] > m)
				m = a[i];

		while (m / exp > 0) {
			int[] bucket = new int[10];

			for (i = 0; i < n; i++)
				bucket[(a[i] / exp) % 10]++; // calculating one digits slot
			for (i = 1; i < 10; i++) // #this FOR loop changes bucket to show the cumulative # of digits up to that index of bucket
				bucket[i] += bucket[i - 1];
			for (i = n - 1; i >= 0; i--)
				b[--bucket[(a[i] / exp) % 10]] = a[i];
			for (i = 0; i < n; i++)  // re-assigning back to array a[]
				a[i] = b[i];
			exp *= 10;
		}
	}

//	public static void radixSort(int[] input) {
//		final int RADIX = 10;
//		// declare and initialize bucket[]
//
//		List<Integer>[] bucket = new ArrayList[RADIX];
//		
//		for (int i = 0; i < bucket.length; i++) {
//			bucket[i] = new ArrayList<Integer>();
//		}
//
//		// sort
//		boolean maxLength = false;
//		int tmp = -1, placement = 1;
//		while (!maxLength) {
//			maxLength = true;
//			// split input between lists
//			for (Integer i : input) {
//				tmp = i / placement;
//				bucket[tmp % RADIX].add(i);
//				if (maxLength && tmp > 0) {
//					maxLength = false;
//				}
//			}
//			// empty lists into input array
//			int a = 0;
//			for (int b = 0; b < RADIX; b++) {
//				for (Integer i : bucket[b]) {
//					input[a++] = i;
//				}
//				bucket[b].clear();
//			}
//			// move to next digit
//			placement *= RADIX;
//		}
//	}

	/** Main method **/
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// System.out.println("Radix Sort Test\n");
		// int n, i;
		// /** Accept number of elements **/
		// System.out.println("Enter number of integer elements");
		// n = scan.nextInt();
		// /** Create integer array on n elements **/
		// int arr[] = new int[n];

		// /** Accept elements **/
		// System.out.println("\nEnter " + 10 + " integer elements");
		// for (i = 0; i < n; i++)
		// arr[i] = scan.nextInt();

		/** Call method sort **/
		int arr[] = { 877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567 };
		sort(arr);
		/** Print sorted Array **/
		System.out.println("\nElements after sorting ");
		for (int i = 0; i < 10; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}