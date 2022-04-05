# 삽입정렬

- 정렬되어 있는 부분집합에 정렬할 새로운 원소의 위치를 삽입하는 방식이다.
- 정수 10개를 정렬하는데 평균 22회의 연산이 필요했다.

## 정렬 프로세스

1. 정렬할 자료를 두 개의 부분집합 **sortedElements**와 **unsortedElements**로 가정한다.
2. 부분집합 **sortedElements** : 정렬된 앞 부분의 원소들
3. 부분집합 **unsortedElements** : 아직 정렬되지 않은 나머지 원소들
4. **sortedElements**와 **unsortedElements**는 position을 경계로 구분한다.
5. position 앞부분은 **sortedElements**다.
6. position 뒷부분은 **unsortedElements**다.
7. 정렬되지 않은 부분집합 **unsortedElements**의 원소를 하나씩 꺼내서 이미 정렬되어 있는 부분집합 **sortedElements**의 마지막 원소부터 비교하면서 위치를 찾아 삽입한다.
8. 삽입정렬을 반복하면서 부분집합 **sortedElements**의 원소는 하나씩 늘리고, 부분집합 **unsortedElements**의 원소는 하나씩 감소하게 된다.
9. 부분집합 **unsortedElements**가 공집합이 되면 정렬이 완료된다.

## 정렬된 배열 예시

- key는 부분집합 **unsortedElements**의 첫번째 값이다.
- position은 값을 삽입할 위치다.
- 삽입정렬하기
  - 값 비교하기
    - key값을 부분집합 **sortedElements**의 마지막 원소부터 차례로 비교한다.
    - key값이 부분집합 **sortedElements**의 원소보다 값이 작으면 해당 위치의 값을 position 위치에 대입하고, position값을 1감소시킨다.
    - 위의 작업이 완료되면 **sortedElements**의 가장 큰 값이 position 위치에 저장된다.
  - 위의 갑 비교하기 반복작업은 key값보다 부분집합 **sortedElements**의 원소가 작은 값이 나오거나, postion이 0이 되면 반복은 종료된다.
  - 반복이 완료되면 현재 position이 가르키는 곳에 key값을 삽입한다.
  - 세부 정렬 프로세스 샘플
    - 원본 배열
      - [63, 24, 49, 25]
    - position = 1, key = **24**
      - position = **1**
        - [**63**, 24, 49, 25]
      - pisition = **0**
        - [**63**, **63**, 49, 25]
      - postion이 0이 때문에 값 비교작업이 종료되고, position 위치에 key값이 저장된다.
        - [**_24_**, **63**, 49, 25]
    - position = 2, key = **49**
      - position = **2**
        - [**24**, **63**, 49, 25]
      - position = **1**
        - [**24**, **63**, **63**, 25]
      - 부분집합 **sortedElements**의 남아있는 원소들이 key값보다 작기 때문에 비교작업이 종료되고, position 위치에 key값이 저장된다.
        - [**24**, **_49_**, **63**, 25]
    - position = 3, key = **25**
      - position = **3**
        - [**24**, **49**, **63**, 25]
      - position = **2**
        - [**24**, **49**, **63**, **63**]
      - position = **1**
        - [**24**, **49**, **49**, **63**]
      - 부분집합 **sortedElements**의 남아있는 원소들이 key값보다 작기 때문에 비교작업이 종료되고, position 위치에 key값이 저장된다.
        - [**24**, **_25_**, **49**, **63**]
