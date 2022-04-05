# 선택정렬

- 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 자리를 교환하는 방식이다.
- 정수 10개를 정렬하는데 45회의 연산이 필요했다.

## 정렬 프로세스

1. 전체 원소 중에서 가장 작은 원소를 찾아 선택하여 첫 번째 원소와 자리를 교환한다.
2. 그 다음 두 번째로 작은 원소를 찾아서 선택하여 두 번째 원소와 자리를 교환한다.
3. 그 다음 세 번째로 작은 원소를 찾아서 선택하여 세 번째 원소와 자리를 교환한다.
4. 이 과정을 반복하면 정렬이 완료된다.

## 정렬된 배열 예시

```java
  [84, 90, 53, 35, 100, 48, 2, 20, 83, 6]
```

- 1번째 정렬 [**2**, 90, 53, 35, 100, 48, **_84_**, 20, 83, 6]
- 2번째 정렬 [2, **6**, 53, 35, 100, 48, 84, 20, 83, **_90_**]
- 3번째 정렬 [2, 6, **20**, 35, 100, 48, 84, **_53_**, 83, 90]
- 5번째 정렬 [2, 6, 20, 35, **48**, **_100_**, 84, 53, 83, 90]
- 6번째 정렬 [2, 6, 20, 35, 48, **53**, 84, **_100_**, 83, 90]
- 7번째 정렬 [2, 6, 20, 35, 48, 53, **83**, 100, **_84_**, 90]
- 8번째 정렬 [2, 6, 20, 35, 48, 53, 83, **84**, **_100_**, 90]
- 9번째 정렬 [2, 6, 20, 35, 48, 53, 83, 84, **90**, **_100_**]