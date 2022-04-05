package com.sample.sort.insertion;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        int[] src = new int[10];
        
        
        Random random = new Random();
        for (int i = 0; i < src.length; i++) {
            src[i] = random.nextInt(100) + 1;
        }
        
        System.out.println();
        System.out.println("정렬 전");
        System.out.println(Arrays.toString(src));

        int[] sorted = InsertionSort.sort(src);
        
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
        final int len = src.length;
        for (int i = 1; i < len; i++) {
        	// 삽입정렬의 배경지식
        	//   정렬할 자료를 두 개의 부분집합 sortedElements와 unsortedElements로 가정한다.
        	//   부분집합 sortedElements : 정렬된 앞 부분의 원소들
        	//   부분집합 unsortedElements : 아직 정렬되지 않은 나머지 원소들
        	//   sortedElements와 unsortedElements는 position을 경계로 구분한다.
        	//   position 앞부분은 sortedElements다.
        	//   position 뒷부분은 unsortedElements다.
        	
            // position은 값을 삽입할 위치다.
        	// position의 초기값은 i값이다. position의 초기값은 배열 중에서 정렬되지 않는 부분의 첫번째 index이기도 하다.
            int position = i;
            // key는 배열 중에서 정렬되지 않은 부분의 첫번째 값이다.
            final int key = arr[i];

            // while문에서는 key에 저장된 값과 이미 정렬된 배열의 맨 마지막 원소부터 차례로 비교하는 작업을 반복한다.
            // key에 저장된 값보다 이미 정렬된 배열에서 조회한 값(arr[position - 1] 번째 값)이 크면 현재 position 위치에 arr[position - 1]값을 대입하고, position의 1감소시킨다.
            // 위의 작업을 반복하면 key에 저장된 값보다 큰 값들이 position 위치에 저장된다. position값이 1씩 감소하기 때문에 반복을 수행할 수록 저장되는 위치는 계속 앞쪽으로 이동된다. 
            // 위의 작업은 position값이 0이 되거나, 이미 정렬된 배열에서 조회한 값(arr[position - 1] 번째 값)이 key에 저장된 값보다 작으면 종료된다.
            while (position > 0 && key < arr[position - 1]) {
                arr[position] = arr[position - 1];
                position--;
            }
            
            // 반복작업이 완려되면 현재 position 위치에 key값을 삽입한다.
            arr[position] = key;
            
        }
        return arr;
    }
}
