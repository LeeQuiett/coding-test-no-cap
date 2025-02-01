import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close(); // 입력 종료

        long sum = 0; // 히든 넘버 합산 변수
        StringBuilder num = new StringBuilder(); // 숫자를 누적할 StringBuilder

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                num.append(c); // 숫자일 경우 추가
                if (num.length() > 6) { // 숫자가 6자리를 초과하면 자르기
                    num.setLength(6);
                }
            } else {
                // 문자일 경우, 이전에 저장된 숫자를 처리
                if (num.length() > 0) {
                    sum += Integer.parseInt(num.toString()); // 정수 변환 후 합산
                    num.setLength(0); // 초기화
                }
            }
        }

        // 마지막 숫자가 남아있다면 처리
        if (num.length() > 0) {
            sum += Integer.parseInt(num.toString());
        }

        // 결과 출력
        System.out.println(sum);
    }
}
