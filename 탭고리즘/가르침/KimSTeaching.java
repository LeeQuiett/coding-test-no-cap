import java.io.*;
import java.util.*;

public class KimSTeaching {

    static int N, K; // 단어의 개수, 배울 알파벳 개수
    static ArrayList<String> words = new ArrayList<>(); // 입력받은 단어 리스트

    static int solution(int N, int K, List<String> words) {
        // K가 5보다 작으면 'antic'도 못 배우므로 0 반환
        if (K < 5) return 0;

        // 반드시 배워야 하는 기본 글자들('antic')
        Set<Character> basic = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));

        // 입력된 모든 단어에서 사용된 알파벳 집합 생성
        Set<Character> alpha = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                alpha.add(c);
            }
        }

        // 전체 알파벳에서 기본 글자들('antic')을 제외
        alpha.removeAll(basic);

        // 선택해야 할 알파벳의 개수 계산
        int selectCount = Math.min(K - 5, alpha.size());

        // 알파벳 집합을 리스트로 변환하여 조합 생성 준비
        List<Character> alphaList = new ArrayList<>(alpha);

        // 가능한 모든 조합을 확인하여 최대값 계산
        return generateCombinations(alphaList, selectCount, basic, words);
    }

    // 재귀적으로 알파벳 조합 생성 및 읽을 수 있는 단어 수 계산
    static int generateCombinations(List<Character> alpha, int count, Set<Character> basic, List<String> words) {
        if (count == 0) {
            return countReadableWords(basic, words);
        }

        int maxCount = 0;
        for (int i = 0; i <= alpha.size() - count; i++) {
            Set<Character> newLearned = new HashSet<>(basic);
            newLearned.add(alpha.get(i));

            List<Character> remaining = new ArrayList<>(alpha.subList(i + 1, alpha.size()));
            maxCount = Math.max(maxCount, generateCombinations(remaining, count - 1, newLearned, words));
        }
        return maxCount;
    }

    // 현재 배운 글자로 읽을 수 있는 단어 수 계산
    static int countReadableWords(Set<Character> learned, List<String> words) {
        int count = 0;
        for (String word : words) {
            boolean canRead = true;
            for (char c : word.toCharArray()) {
                if (!learned.contains(c)) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N개의 단어 입력
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 결과 출력
        System.out.println(solution(N, K, words));
    }
}
