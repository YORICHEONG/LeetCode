package middle.Backtrace;
import java.util.*;
import java.util.function.BiFunction;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backTrace(result, new StringBuffer(), 0, 0, n);
        return result;

    }

    public void backTrace(List<String> list,StringBuffer buffer,int open ,int close,int n){
        if(buffer.length()==n*2){
            list.add(buffer.toString());
            return;
        }
        if(open<n){
            buffer.append("(");
            backTrace(list, buffer, open+1, close, n);
            buffer.deleteCharAt(buffer.length()-1);
        }
        if(close<open){
            buffer.append(")");
            backTrace(list, buffer, open, close+1, n);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }


    public List<String> generateParenthesis01(int n){
        List<String> result = null;
        if(n<=0){
            return result;
        }
        result = new ArrayList<>();
        dfs(new StringBuffer(), result, 0, 0, n);
        return result;
    }
    private void dfs(StringBuffer buffer,List<String> result,int open,int close,int max){
        if(open>max||close>open){
            return ;
        }
        if(buffer.length()==max*2){
            result.add(buffer.toString());
            return;
        }
        dfs(buffer.append("("), result, open+1, close, max);
        dfs(buffer.append(")"), result, open, close+1, max);
    }
}
