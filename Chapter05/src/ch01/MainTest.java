package ch01;

public class MainTest {
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[6];
		arr[0] = 3;
		arr[1] = 8;
		arr[2] = 6;
		arr[3] = 4;
		arr[4] = 1;
		arr[5] = 9;

		selectionSort();
	}

	public static void selectionSort() {
		int i, j, maxIndex, tmp;
		for (i = 0; i < arr.length - 1; i++) {
			maxIndex = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			tmp = arr[maxIndex];
			arr[maxIndex] = arr[i];
			arr[i] = tmp;

			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
			System.out.println("===================");

		}

	}

}
