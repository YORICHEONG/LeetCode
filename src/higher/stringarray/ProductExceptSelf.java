package higher.stringarray;
/*
	2021-06-24 15:19:27
	YORICHEONG
	Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	You must write an algorithm that runs in O(n) time and without using the division operation

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
		// define a array to store value of the left multiply value
		int[] leftValue = new int[length];

		// leftValue[i] store the all of the nums[i] left value multiply
		// index=0 value in the leftValue array is 1 because the for the first value it didn't hava left value
		leftValue[0] = 1;

		for(int i = 1; i<length; i++) {
			leftValue[i] = nums[i-1] * leftValue[i-1];
		} 

		// R store the all of the nums[i] right element multiply vlaue
		// at the begin the right didn't have element so it initial value is 1
		
		int R = 1;
		for(int i = length-1; i >= 0; i--) {
			// for the index i, left multiply value is leftValue[i] right mulitply value is R
			leftValue[i] = leftValue[i]*R;	
			// R contians all the right value,so it need to multiply the current pass index nums[i]
			R *= nums[i];
		}

		// return the result
		return leftValue;
    }
}