import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {   
        //시간복잡도 이슈로 Stack 사용 O(n)^~^
        //1. 뒤에서 부터 비교 시작
        //2. Stack의 값이 현재 값보다 크면 살아남음
        //3. Stack의 값이 현재 값보다 작으면
        //   현재 값이 Stack의 값보다 큰 값이니(구하는게 가까운 큰 값이니) 뒤의 값들이 필요 없음
        //4. 필요 없는 Stack의 값들을 pop해서 날림
        //5. Stack엔 가장 가까운 큰 값만 남음
        // Stack의 값의 모두 pop당한다는 건 현재 나의 값보다 뒤의 값이 작다는 것을 의미
        // 따라서 해당 loop에 Stack이 비었다면 내가 제일 크단 것 고로 앞쪽 배열의 값들은 날 가장 큰 값으로 삼거나 자기가 더 크거나임
        //스택이 비었으면 뒤에 나보다 큰 값이 없다는 것이니 -1, 아니라면 스택의 top을 answer에 저장
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length -1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            
            stack.push(numbers[i]);
        }
        return answer;
    }
}

 /* 시간복잡도 이슈로 주석처리ㅜ.ㅜ
        int paramLen = numbers.length;
        int[] answer = new int[paramLen];
        
        for (int i = 0; i < paramLen - 1; i++) {
            answer[i] = -1;
            for (int j = i + 1; j < paramLen; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
            answer[paramLen-1] = -1;
        }
        
        return answer; */