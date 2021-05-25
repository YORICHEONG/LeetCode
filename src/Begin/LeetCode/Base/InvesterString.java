package Begin.LeetCode.Base;
/**
 * 反转字符串
 */
public class InvesterString {
    /**
     * 使用一个很简单的类似与数组的对称交换
     */
    public void solution_01(char[] s){
        int length = s.length;
        char temp;
        for(int i = 0; i<length/2; i++){
            temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }
    /**
     * 使用递归方法
     */
    public void solution_02(char[] s){
        if(s==null||s.length==0){
            return;
        }
        reverseStringHelper(s, 0, s.length-1);
    }
    /**
     * 递归的方法
     */
    public void reverseStringHelper(char[] s,int left,int right){
      if(left>=right){
          return;
      }
      reverseStringHelper(s, ++left, --right);
    }
    /**
     * 交换方法
     */
    public void swap(char[] s,int left,int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
