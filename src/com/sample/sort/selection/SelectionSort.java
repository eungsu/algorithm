package com.sample.sort.selection;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] src = new int[10];
        
        Random random = new Random();
        for (int i = 0; i < src.length; i++) {
            src[i] = random.nextInt(100) + 1;
        }
        
        System.out.println();
        System.out.println("정렬 전");
        System.out.println(Arrays.toString(src));

        int[] sorted = SelectionSort.sort(src);

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

        // 배열의 길이를 조회해서 변수에 저장한다.
        final int len = arr.length;

        // 배열의 크기만큼 반복작업을 수행한다.
        for (int i = 0; i < len; i++) {
            // position은 기본값은 i값이다.
            // position은 배열에서 최소값이 저장된 칸의 인덱스로 대체된다.
            int position = i;
            // i번째부터 배열의 길이만크 반복수행한다.
            // 0 ~ 9, 1 ~ 9, 2 ~ 9, 3 ~ 9, ...의 순서로 for문이 반복실행된다.
            // for문의 실행이 완료되면 position에는 (i + 1) ~ 9번째 사이에 있는 값 중에서 최소값이 저장된 칸의 인덱스가 저장된다.
            for (int j = i + 1; j < len; j++) {
                // j번째 값이 현재 position의 값보다 작으면 position의 값을 j번째 값으로 대체한다.
                if (arr[j] < arr[position]) {
                    position = j;
                }               
            }
            // postion의 값이 최소 설정한 i값과 같으면 (i + 1) ~ 9번째 사이에 있는 값보다 i번째의 값이 더 작은 경우다.
            // 자리 교환없이 다음 번 반복을 수행한다.
            if (position == i) {
                continue;
            }

            // i번째의 값과 position번째의 값을 교환한다.
            int temp = arr[i];
            arr[i] = arr[position];
            arr[position] = temp;
        }

        return arr;        
    }
}
