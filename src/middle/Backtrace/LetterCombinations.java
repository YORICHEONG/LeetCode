package middle.Backtrace;
import java.util.*;

public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<String>();
    if(digits.length() == 0){
      return combinations;
    }
    Map<Character,String> map = new HashMap<>();

    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    backTrace(combinations, map, digits, 0, new StringBuffer());
    return combinations;
  }
  public void backTrace(List<String> combinations,Map<Character,String> map,String digits,int index,StringBuffer combination){
    if(index==digits.length()){
      combinations.add(combination.toString());
    }else{
      char digit = digits.charAt(index);
      String letters = map.get(digit);
      int letterCount = letters.length();
      for(int i = 0; i<letterCount; i++){
        combination.append(letters.charAt(i));
        backTrace(combinations, map, digits, index+1, combination);
        combination.deleteCharAt(index);
      }
    }
  }
}
