class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void findSubs(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList(current));
        for(int i = index ; i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            findSubs(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
}
