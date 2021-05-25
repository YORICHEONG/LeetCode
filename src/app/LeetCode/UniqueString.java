package app.LeetCode;
/**
 * 字符串中的一个唯一字符
 */
public class UniqueString {
    /**
     * 使用两个数组来进行唯一字符串的判断
     */
    public int solution_01(String s){
        int[] a = new int[26];
        int[] index = new int[26];
        int size = s.length();
        char[] context = s.toCharArray();
        for(int i = 0; i<size; i++){
            a[context[i]-'a'] = ++a[context[i]-'a'];
            index[context[i]-'a'] = i;
        }
        for(int i = 0; i<size; i++){
            if(a[context[i]-'a']==1){
                return index[context[i]-'a'];
            }
        }
        return -1;
    }
    /**
     * 两次遍历，第一次遍历的时候用一个数组来存储每个字符串的次数
     *      
     * */
    public int solution_02(String s){
        int[] count = new int[26];
        char[] context  = s.toCharArray();
        //统计每个字符出现的次数
        for(int i = 0; i<s.length(); i++){
            count[context[i]-'a']++;
        }
        //然后再遍历一次，如果找到的次数为1的字符串就直接返回
        for(int i =0; i<s.length(); i++){
            if(count[context[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
