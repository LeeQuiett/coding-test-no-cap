import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void generateLotto(int[] numbers, List<Integer> selected, int start, int target) {
        if (selected.size() == target) {
            System.out.println(
                selected.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
            );
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            selected.add(numbers[i]);
            generateLotto(numbers, selected, i + 1, target);
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);

            if (k == 0) break;

            int[] numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(input[i + 1]);
            }

            generateLotto(numbers, new ArrayList<>(), 0, 6);
            System.out.println();
        }
    }
}
