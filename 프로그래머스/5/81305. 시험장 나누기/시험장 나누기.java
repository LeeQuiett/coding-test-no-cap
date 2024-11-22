import java.util.*;

class Node {
    int id;
    int people;
    Node left, right;
    
    Node(int id, int people) {
        this.id = id;
        this.people = people;
    }
}

class Solution {
    private int k;
    private int groupCount;
    
    public int solution(int k, int[] num, int[][] links) {
        this.k = k;
        int totalTestCenters = num.length;
        
        Node[] nodes = new Node[totalTestCenters];
        for (int i = 0; i < totalTestCenters; i++) {
            nodes[i] = new Node(i, num[i]);
        }
        
        boolean[] isChild = new boolean[totalTestCenters];
        for (int i = 0; i < totalTestCenters; i++) {
            int left = links[i][0];
            int right = links[i][1];
            
            if (left != -1) {
                nodes[i].left = nodes[left];
                isChild[left] = true;
            }
            if (right != -1) {
                nodes[i].right = nodes[right];
                isChild[right] = true;
            }
        }
        
        int root = 0;
        for (int i = 0; i < totalTestCenters; i++) {
            if (!isChild[i]) {
                root = i;
                break;
            }
        }
        
        //int left = Arrays.stream(num).max().getAsInt();
        int right = Arrays.stream(num).sum();
        int left = right / k;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nodes[root], mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int dfs(Node node, int limit) {
        if (node == null) return 0;
        
        int leftSum = dfs(node.left, limit);
        int rightSum = dfs(node.right, limit);
        
        if (leftSum == -1 || rightSum == -1) return -1;
        
        int totalSum = leftSum + rightSum + node.people;
        
        if (totalSum <= limit) return totalSum;
        
        if (node.people > limit) return -1;
        
        groupCount++;
        
        //if (rightSum + node.people <= limit) return rightSum + node.people;
        //if (leftSum + node.people <= limit) return leftSum + node.people;
        if (Math.min(leftSum, rightSum) + node.people <= limit) return Math.min(leftSum, rightSum) + node.people;
        //if (rightSum + node.people <= limit) return rightSum + node.people;
        
        groupCount++;
        return node.people;
    }
    
    private boolean canDivide(Node root, int limit) {
        groupCount = 1;
        int result = dfs(root, limit);
        return result != -1 && groupCount <= k;
    }
}
