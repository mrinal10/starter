class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int count = 0;
        while(i<nums.length - count){
            if(nums[i] == 0){
                nums = moveHelper(nums, i);
                count++;
            } else {
                i = i+1;
            }
        }
    }
    
    private int[] moveHelper(int[] nums, int start){
        for(int i = start; i<nums.length - 1; i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length - 1] = 0;
        return nums;
    }
    
    public static void main(String[] args) {
		int[] ar = {0,1,0,3,12};
		Solution s  =new Solution();
		s.moveZeroes(ar);
	}
}