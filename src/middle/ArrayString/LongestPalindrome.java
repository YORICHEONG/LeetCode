package middle.ArrayString;

public class LongestPalindrome {
  public String longestPalindrome(String s) {
    if(s.length()<2){
      return s;
    }
    int start = 0;
    int maxLength = 0;
    int length = s.length();
    for(int i = 0; i<length;){
      if(length-i<=maxLength/2){
        break;
      }
      int left = i;
      int right = i;
      while(right<length-1&&s.charAt(right+1)==s.charAt(right)){
        ++right;
      }
      i = right+1;
      while(right<length-1&&left>0&&s.charAt(right+1)==s.charAt(left-1)){
        ++right;
        --left;
      } 
      if(right-left+1>maxLength){
        start = left;
        maxLength = right-left+1;
      }
    }

    return s.substring(start, start+maxLength);
  }
}
