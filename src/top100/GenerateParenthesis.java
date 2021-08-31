package top100;

import java.util.*;



/**
 * @description:
 * @author YORICHEONG
 * @date 2021/8/19 10:47
 * @version 1.0
 */
public class GenerateParenthesis {

    List<String> list = new ArrayList<>();
    /**
     * @param: n
     * @description : TODD
     * @return : java.util.List<java.lang.String>
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    public List<String> generateParenthesis(int n) {
        if(n <= 0) {
            return list;
        }
        // 调用私有的方法
        getParenthesis("", n, n);
        return list;
    }

    /**
     * @param: str
     * @param: left
     * @param: right
     * @description : 递归的方法
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    private void getParenthesis(String str, int left, int right) {
        // 达到了最大的长度时候就将这个组添加进去
        if(left == 0 && right == 0) {
            System.out.println(str);
            list.add(str);
            return;
        }
        if(left == right) {
            // 左右括号相等的时候先用左括号
            getParenthesis(str + "(", left -1, right);
            // 如果左边的括号数量小于右边的时候
        } else if(left < right) {
            // 如果左边可以添加的还有，就先添加左边的
            if(left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            // 否则右边添加括号
            getParenthesis(str + ")", left, right - 1);
        }
    }

    //============ Method 2===============================================================

    /**
     * @param: n
     * @description : 使用回溯的方法来进行遍历
     * @return : java.util.List<java.lang.String>
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backTrace(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }
    
    /**
     * @param: ans
     * @param: builder
     * @param: left
     * @param: right
     * @param: max
     * @description : 回溯
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    public void backTrace(List<String> ans, StringBuilder builder, int left, int right, int max) {
        int multiple = 2;
        if(builder.length() == max * multiple) {
            ans.add(builder.toString());
            return;
        }
        // 然后进行测试
        if(left < max) {
            builder.append('(');
            backTrace(ans, builder, left + 1, right, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(right < left) {
            builder.append(')');
            backTrace(ans, builder, left, right + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}