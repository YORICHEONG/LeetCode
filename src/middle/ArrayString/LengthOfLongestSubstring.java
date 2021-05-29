package middle.ArrayString;
import java.util.*;

public class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    //使用Set来进行一个去重的判断
    //首相创建一个Set
    Set<Character> set = new HashSet<Character>();
    int i =0;
    int j =0;
    int maxLength = 0;

    if(s.length()==0){
      return 0;
    }

    for(i = 0; i<s.length(); i++){
      if(set.add(s.charAt(i))){
        maxLength = Math.max(maxLength, set.size());
      }else{
        while(!set.add(s.charAt(i))){
          set.remove(s.charAt(j));
          j++;
        }
      }
    }
    return maxLength;
  }
}
