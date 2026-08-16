class Solution {
    public boolean stoneGameIX(int[] stones) {

        int c0 = 0, c1 = 0, c2 = 0;

        // Count stones based on remainder when divided by 3
        for (int x : stones) {
            if (x % 3 == 0)
                c0++;
            else if (x % 3 == 1)
                c1++;
            else
                c2++;
        }

        // Special case
        if (c0 % 2 == 0) {
            return c1 > 0 && c2 > 0;
        }

        // c0 is odd
        return Math.abs(c1 - c2) > 2;
    }
}