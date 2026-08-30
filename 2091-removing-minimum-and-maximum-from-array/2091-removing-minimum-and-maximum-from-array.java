class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        
        int indexOfMin = 0, indexOfMax = 0;
        for (int k = 1; k < n; k++) {
            if (nums[k] < nums[indexOfMin]) indexOfMin = k;
            if (nums[k] > nums[indexOfMax]) indexOfMax = k;
        }
        
        int i = Math.min(indexOfMin, indexOfMax); 
        int j = Math.max(indexOfMin, indexOfMax); 
        
        int fromFront = j + 1;              
        int fromBack = n - i;               
        int split = (i + 1) + (n - j);       
        
        return Math.min(fromFront, Math.min(fromBack, split));
    }
}