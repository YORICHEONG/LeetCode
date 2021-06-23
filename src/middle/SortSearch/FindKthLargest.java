package middle.SortSearch;
/**
 * 2021年6月23日09:11:04
 * author：YORICHEONG
 * 
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;//根据数组大小获得堆大小
        //然后创建最大堆
        buildMaxHeap(nums, heapSize);
        //然后遍历堆,删除前k-1个最大数
        for(int i = nums.length-1; i >= nums.length-k+1; --i){
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    /**
     * 
     * @param a
     * @param heapSize
     */
    private void buildMaxHeap(int[] a, int heapSize) {
        for(int i = heapSize/2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    /**
     * 
     * @param a
     * @param i
     * @param heapSize
     */
    private void maxHeapify(int[] a, int i, int heapSize) {
        //获得当前节点的左右节点的下标，以及要交换节点的下标
        int left = i*2+1, right = i*2+2, largest = i;
        // 然后进行判断比较
        if(left < heapSize && a[left] > a[largest]) {
            //进行交换
            largest = left;
        }
        if(right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        if(largest != i){
            //然后就进行一个比较交换
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }

    }

    /**
     * 
     * @param a
     * @param left
     * @param right
     */
    private void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}

