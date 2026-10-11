class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] diff = new long[nums1.length];
        long max = 0;
        long operations = (long) k1 + k2;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long required = 0;

            for (long d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= operations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long limit = left;
        long remaining = operations;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > limit) {
                remaining -= diff[i] - limit;
                diff[i] = limit;
            }
        }

        for (int i = 0; i < diff.length && remaining > 0; i++) {
            if (diff[i] == limit && diff[i] > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long answer = 0;

        for (long d : diff) {
            answer += d * d;
        }

        return answer;
    }
}