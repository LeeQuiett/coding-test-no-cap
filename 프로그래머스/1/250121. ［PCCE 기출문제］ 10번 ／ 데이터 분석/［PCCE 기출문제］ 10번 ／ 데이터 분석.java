import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int row = data.length;
        int cntAns = 0;
        int[][] answer = new int[row][4];
        
        for (int i = 0; i < row; i++) {
            if (ext.equals("code") && data[i][0] < val_ext) {
                answer[cntAns] = data[i];
                cntAns++;
            } else if (ext.equals("date") && data[i][1] < val_ext) {
                answer[cntAns] = data[i];
                cntAns++;
            } else if (ext.equals("maximum") && data[i][2] < val_ext) {
                answer[cntAns] = data[i];
                cntAns++;
            } else if (ext.equals("remain") && data[i][3] < val_ext) {
                answer[cntAns] = data[i];
                cntAns++;
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(data[i][j] + " ");
            } System.out.println();
        }
        
        int[][] result = Arrays.copyOf(answer,cntAns);
        
        final int sortIndex = getSortIndex(sort_by);
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[sortIndex], o2[sortIndex]);
            }
        });
        
        return result;
    }
    
    private int getSortIndex(String sort_by) {
        switch (sort_by) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return 99;
        }
    }
}