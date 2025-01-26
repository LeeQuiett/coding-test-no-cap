import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        String s = scanner.nextLine();
        String bomb = scanner.nextLine();
        scanner.close();

        Stack<Character> stack = new Stack<>();

        // 문자열 처리
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            // 폭발 문자열 확인
            if (stack.size() >= bomb.length()) {
                boolean match = true;

                // 스택의 마지막 부분과 폭발 문자열 비교
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // 폭발 문자열과 일치하면 스택에서 제거
                if (match) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }
            System.out.println(result.toString());
        }
    }
}