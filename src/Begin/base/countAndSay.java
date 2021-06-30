package Begin.base;
/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1 
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

 */
/**
 * author：YROICHEONG
 * date：20/5/2021
 */
public class countAndSay {
  public String solution(int n){
    //首先给出一个递归结束的条件
    if(n==1){
      return "1";
    }
    //然后获得上一次返回的结果
    String context  = solution(n-1);
    //然后处理上次的结果
    StringBuffer result = new StringBuffer();
    //对context进行遍历处理
    char local =  context.charAt(0);
    int count=0;
    for(int i = 0; i<context.length(); i++){
      if(context.charAt(i)==local){
        count++;
      }else{
        //如果是不符合的情况下
        result.append(count);
        result.append(local);
        count=1;
        local = context.charAt(i);
      }
    }
    //将最后一次遍历后还没有添加的添加上去
    result.append(count);
    result.append(local);
    return result.toString();
  }
}
