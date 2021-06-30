package begin.base;
/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。


 */
/**
 * author:YORICHOENG
 * date:5/20/2021
 */
public class StrToStr {
  public int solution(String haystack,String needle){
    int hlen = haystack.length();
    int nlen = needle.length();
    if(nlen==0){
      return 0;
    }
    int i = 0;
    int j = 0;
    while(i<hlen&&j<nlen){
      if(haystack.charAt(i)==needle.charAt(j)){
        i++;
        j++;
      }else{
        i = i-j+1;
        j = 0;
      }
    }
    if(j==nlen){
      return i-j;
    }
    return -1;
  }
}
