### **센서**

한국도로공사는 고속도로의 유비쿼터스화를 위해 고속도로 위에 N개의 센서를 설치하였습니다. 각 집중국은 센서의 수신 가능 영역을 조절할 수 있으며, 다음과 같은 규칙을 따릅니다:

1. 각 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타납니다.
2. N개의 센서는 적어도 하나의 집중국과 통신이 가능해야 합니다.
3. 집중국의 유지비 문제로 각 집중국의 수신 가능 영역의 길이의 합을 최소화해야 합니다.

고속도로는 평면상의 직선이며, 센서들은 원점으로부터의 정수 거리의 위치에 놓여 있습니다. 최대 K개의 집중국으로 모든 센서를 커버하는 최소 수신 가능 영역의 길이 합을 구하는 프로그램을 작성하세요.

---

### **입력 형식**

1. 첫째 줄에 센서의 개수 N이 주어집니다. (1 ≤ N ≤ 10,000)
2. 둘째 줄에 집중국의 개수 K가 주어집니다. (1 ≤ K ≤ 1,000)
3. 셋째 줄에 N개의 센서의 좌표가 공백으로 구분되어 주어집니다.
    - 각 좌표의 절댓값은 1,000,000 이하입니다.

---

### **출력 형식**

첫째 줄에 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력합니다.

---

### **예제 입력 1**

```
6
2
1 6 9 3 6 7
```

### **예제 출력 1**

```
5
```

---

### **예제 입력 2**

```
10
5
20 3 14 6 7 8 18 10 12 15
```

### **예제 출력 2**

```
7
```
