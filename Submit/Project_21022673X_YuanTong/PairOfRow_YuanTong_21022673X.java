import java.util.Arrays;

/**
 * @author Yuan Tong (December 26, 2021)
 *
 * Given such a compact representation, the task is to find a pair of identical rows.
 *
 * For each row we need O(n) time to insert
 * So the time complexity is O(n^2)
 *
 * I refered the following material:
 *   1.https://www.geeksforgeeks.org/find-duplicate-rows-binary-matrix/
 */

public class PairOfRow_YuanTong_21022673X {

    Trie head;

    public PairOfRow_YuanTong_21022673X(){
        head = new Trie();
    }

    private class Trie{
        int leaf;
        Trie[] children;

        public Trie() {
            leaf = -1;
            children = new Trie[2];
            children[1] = children[0] = null;
        }
    }

    private int insert(int[] array, int rows, int row_index) {
        Trie current = head;

        boolean[] row = new boolean[rows];
        for (int i:array
             ) {
            row[i] = true;
        }

        for (int i = 0; i < array.length; i++) {
            if (current.children[row[i]?1:0] == null) {
                current.children[row[i]?1:0] = new Trie();
            }
            current = current.children[row[i]?1:0];
        }

        if (current.leaf == -1){
            current.leaf = row_index;
            return -1;
        }
        else {
            return current.leaf;
        }
    }

    public int[] searchPairsOfRow(int[][] matrix) {
        int[] pairs = {0, 0};

        for (int i = 0; i < matrix.length; i++) {
            int result = insert(matrix[i], matrix.length, i);
            if (result != -1) {
                pairs[0] = result;
                pairs[1] = i;
                return pairs;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        PairOfRow_YuanTong_21022673X test = new PairOfRow_YuanTong_21022673X();
        int[][] matrix = {{3, 1}, {0, 2}, {3, 1}, {2, 0}, {}};
        System.out.println(Arrays.toString(test.searchPairsOfRow(matrix)));
    }


}
