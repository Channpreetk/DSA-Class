class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] isValid = new boolean[nums.length];
        helper(nums, new ArrayList<>(), isValid, ans);
        return ans;
    }

    private void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isValid[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !isValid[i - 1]) continue;

            ds.add(nums[i]);
            isValid[i] = true;
            helper(nums, ds, isValid, ans);
            isValid[i] = false;
            ds.remove(ds.size() - 1);
        }
    }
}