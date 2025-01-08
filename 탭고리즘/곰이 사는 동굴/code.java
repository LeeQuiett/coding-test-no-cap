public class MaxBearsInCave {
    public static void main(String[] args) {

    }

    public static long maxBearsInCaveSolution(int n, long[] caves) {
        long totalBears = 0;

        for (int i = 0; i < n; i++) {
            totalBears += 1;

            if (caves[i] > 0) {
                long adjacentBears = Math.min(caves[i], 1);
                totalBears += adjacentBears;
                caves[i] -= adjacentBears;

                if (i < n - 1) {
                    caves[i + 1] += caves[i] - adjacentBears;
                }
            }
        }

        return totalBears;
    }
}
