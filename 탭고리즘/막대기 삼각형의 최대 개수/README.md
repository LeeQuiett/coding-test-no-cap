### **막대기 삼각형의 최대 개수**

르탄이는 여러 개의 막대기를 사용해 삼각형을 만들고자 합니다. 각 막대기의 길이는 주어지며, 이 막대기들로 만들 수 있는 서로 다른 삼각형의 **최대 개수**를 구하려고 합니다.

삼각형의 조건

1. 삼각형의 한 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다. (a+b > c)
2. 모든 막대기를 반드시 사용할 필요는 없으며, 가능한 많은 삼각형을 만들어야 합니다.
3. 동일한 조합으로 만든 삼각형은 하나로 간주합니다. (예: 변의 길이가 3, 4, 5인 삼각형과 4, 5, 3인 삼각형은 한 종류로 봄)

---

### **입력 형식**

첫 번째 줄에 막대기의 개수 **N**이 주어진다. (3 ≤ N ≤ 50,000)

두 번째 줄에 각 막대기의 길이가 공백으로 구분되어 주어진다. (1 ≤ 각 막대기의 길이 ≤ 1,000)

---

### **출력 형식**

만들 수 있는 삼각형의 최대 개수를 출력한다. 삼각형을 만들 수 없다면 0을 출력한다.

---

### **예제 입력 1**

```
5
4 6 3 7 8

```

### **예제 출력 1**

```
7

```

### **예제 입력 2**

```
4
10 21 22 100

```

### **예제 출력 2**

```
0

```

---

### **문제 조건**

1. 삼각형의 조건은 **a + b > c**를 만족해야 합니다. 여기서 a≤b≤c라고 가정합니다.
2. 세 막대기의 길이가 모두 달라도 삼각형이 될 수 있습니다.
3. 최대한 많은 삼각형을 만드는 경우의 수를 계산해야 합니다.
