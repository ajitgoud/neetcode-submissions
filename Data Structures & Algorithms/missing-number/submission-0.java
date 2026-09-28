class Solution {
    public int missingNumber(int[] nums) {
        int missingNum = nums.length;
        for(int i=0; i<nums.length;i++){
            missingNum = missingNum ^ nums[i] ^ i;
        }

        return missingNum;
    }
}
