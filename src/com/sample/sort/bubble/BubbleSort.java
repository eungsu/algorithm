package com.sample.sort.bubble;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] src = new int[10];
        
        Random random = new Random();
        for (int i = 0; i < src.length; i++) {
            src[i] = random.nextInt(100) + 1;
        }
        
        System.out.println();
        System.out.println("정렬 전");
        System.out.println(Arrays.toString(src));
        
        int[] sorted = BubbleSort.sort(src);
        
        System.out.println();
        System.out.println("정렬 후");
        System.out.println(Arrays.toString(sorted));
    }

    /**
     * 배열을 전달받아서 오름차순으로 정렬된 새 배열을 반환한다.
     * @param src 정렬되지 않은 배열
     * @return 오름차순으로 정렬된 새 배열
     */
    public static int[] sort(final int[] src) {
        // 원본 배열을 복사해서 새 배열을 생성한다.
        int[] arr = Arrays.copyOf(src, src.length);

        // 배열의 길이를 조회해서 변수에 저장한다.
        final int len = src.length;

        // 배열의 크기만큼 반복작업을 수행한다.
        for (int i = 0; i < len; i++) {
            // 배열의 0번째부터 (배열의 길이 - i)번째까지 반복한다.
            // 0 ~ 9, 0 ~ 8, 0 ~ 7, 0 ~ 6 .... 의 순서로 for문이 반복실행된다. 
            // for문이 한 번 실행될 때 마다  인접한 원소를 비교해서 자리를 교환한다.
            // for문의 실행이 완료되면 가장 큰 수가 (배열의 길이 - i)번째 칸에 위치하게 된다.
            for (int j = 0; j < len - i; j++) {
                // j + 1값이 배열의 길이보다 작고, j번째 값이 j + 1번째 값보다 크면 자리를 교환한다.
                if (j + 1 < len && arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
