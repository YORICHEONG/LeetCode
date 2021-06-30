package middle.sortsearch;
/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色

 */
public class SortColors {
    public void sortColors(int[] nums) {
        //应为给定的数组中的值只有三种值 0，1，2
        int left = 0;
        int right = nums.length-1;
        for(int i = 0; i<=right; i++){
            if(nums[i]==0){
            	//如果找打一个0，就将这个0和最左边位置的数来进行一个交换
                swap(i,left,nums);
                left++;
            }
            if(nums[i]==2){
            	//如果找到的是2就将当前下标的值与最右边的进行一个交换
            	swap(i,right,nums);
            	right--;
            	i--;
            }

        }    
    }
    /**
    数组中进行交换
    **/
    private void swap(int i, int j, int[] array){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}
