
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        // All differences can be reduced to zero.
        if (k >= total) return 0;

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long required = 0;

            for (int d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Reduce all differences greater than low to low.
        long ans = 0;
        long remaining = k;

        for (int d : diff) {
            if (d > low) {
                remaining -= d - low;
                ans += (long) low * low;
            } else {
                ans += (long) d * d;
            }
        }

        // Use leftover operations to reduce some differences from
        // low to low - 1.
        // Each such reduction saves low^2 - (low-1)^2 = 2*low - 1.
        if (low > 0) {
            ans -= remaining * (2L * low - 1);
        }

        return ans;
    }
}
