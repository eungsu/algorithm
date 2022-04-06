package com.sample.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] src = new int[7];
        
        Random random = new Random();
        for (int i = 0; i < src.length; i++) {
            src[i] = random.nextInt(50) + 1;
        }
        
        System.out.println();
        System.out.println("정렬 전");
        System.out.println(Arrays.toString(src));

        int[] sorted = QuickSort.sort(src);

        System.out.println();
        System.out.println("정렬 후");
        System.out.println(Arrays.toString(sorted));
	}
	
	/**
	 * 배열을 전달받아서 오름차순으로 정렬된 새 배열을 반환한다.
	 * @param src 정렬되지 않은 배열
	 * @return 오름차순으로 정렬된 새 배열
	 */
	public static int[] sort(int[] src) {
		// 원본 배열을 복사해서 새 배열을 생성한다.
        int[] arr = Arrays.copyOf(src, src.length);
        
		QuickSort.quickSort(arr, 0, arr.length - 1);
		
		return arr;
	}
	
	
	/**
	 * 배열을 전달받아서 기준값을 중심으로 왼쪽 부분 집합에는 기준 값보다 작은 원소들을 이동시키고, 오른쪽 부분 집합에는 기준값보다 큰 원소들을 이동시킨다.
	 * <p>
	 * 전달받은 배열에서 begin과 end 범위에 속하는 배열의 부분집합에 대해서만 위의 작업을 수행한다.
	 * @param arr 정렬되지 않은 배열
	 * @param begin 배열에서 정렬할 대상 원소들의 첫번째 원소의 저장위치
	 * @param end 배열에서 정렬할 대상 원소들의 마지막번째 원소의 저장위치
	 */
	public static void quickSort(int[] arr, int begin, int end) {
		// 시작위치와 끝위치 사이의 중간위치를 계산한다.
		int middle = begin + (end -begin)/2;
		// 위에서 계산된 중간위치에 저장된 값을 기준값으로 정한다.
		// 기준값이 저장된 위치를 기준으로 왼쪽에는 기준값보다 작은 값을 위치시키고, 오른쪽에는 기분값보다 큰 값을 위치시킬 것이다.
		int pivot = arr[middle];
		// left와 right의 초기값은 왼쪽집합의 시작위치와 오른쪽 집합의 끝 위치를 나타낸다.
		// left는 1씩 증가시키면서 왼쪽 집합에서 기준값보다 큰 값을 찾는다.
		// right는 1씩 감소시키면서 오른쪽 집합에서 기준값보다 작은 값을 찾는다.
		int left = begin;
		int right = end;
		
		// left값이 right값보다 크면 반복을 중단한다.
		while (left <= right) {
			// arr[left]값이 기준값보다 작으면 left를 1증가시킨다.
			// arr[left]값이 기준값보다 크거나 같은 값이면 반복을 중단하고 해당 left 위치의 값이 이동 대상이 된다.
			while (arr[left] < pivot) {
				left++;
			}
			
			// arr[right]값이 기준값보다 크면 right를 1감소시킨다.
			// arr[right]값이 기준값보다 작거나 같은 값이면 반복을 중단하고 해당 right 위치의 값이 이동 대상이 된다.
			while (arr[right] > pivot) {
				right--;
			}
			
			// left위치의 값과 right위치의 값을 서로 교환하고, left와 right을 1증가/1감소시킨다.
			if (left <= right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				
				left++;
				right--;
			}
			
			// 전달받은 배열을 두 개의 부분 집합으로 나누어서 위의 작업을 반복수행시킨다.
			if (begin < right) {
				quickSort(arr, begin, right);
			}
			
			if (end > left) {
				quickSort(arr, left, end);
			}
		}
		
	}
}
