// Last updated: 7/9/2026, 3:08:37 PM
import java.util.*;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char current = board[i][j];

                if (current == '.') {
                    continue;
                }

                if (!set.add(current + " in row " + i) ||
                    !set.add(current + " in col " + j) ||
                    !set.add(current + " in box " + (i / 3) + "-" + (j / 3))) {
                    return false;
                }
            }
        }

        return true;
    }
}