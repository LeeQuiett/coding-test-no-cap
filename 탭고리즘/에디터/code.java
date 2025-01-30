import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기 문자열 입력
        String initial = br.readLine();
        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        // 커서를 기준으로 왼쪽과 오른쪽 스택을 사용
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 왼쪽 스택에 삽입 (커서가 맨 뒤에 있다고 가정)
        for (char c : initial.toCharArray()) {
            leftStack.push(c);
        }

        // 명령어 처리
        while (M-- > 0) {
            String command = br.readLine();

            if (command.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (command.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (command.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (command.startsWith("P")) {
                char x = command.charAt(2);
                leftStack.push(x);
            }
        }

        // 결과 출력 (왼쪽 스택 + 오른쪽 스택 역순)
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        
        System.out.println(sb);
    }
}
