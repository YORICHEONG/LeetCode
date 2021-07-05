package dailypunch;

import java.util.*;

/**
 * @description: 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}
 *
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * @author YORICHEONG
 * @date 2021/7/5 9:33
 * @version 1.0
 */
public class countOfAtoms_20210705 {

    int i;
    int n;
    String formula;

    /**
     * @description:
     * @param: [java.lang.String] [formula] 
     * @return: java.lang.String
     * @author YORICHEONG
     * @date: 2021/7/5 9:33
     */
    public String countOfAtoms(String formula) {
        i = 0;
        n = formula.length();
        this.formula = formula;

        // 创建已给map栈
        Deque<Map<String,Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<String,Integer>());

        // 然后开始进行遍历
        while(i < n) {
            char ch = formula.charAt(i);

            // 进行条件判断
            if(ch == '(') {
                i++;
                stack.push(new HashMap<String,Integer>());
            } else if(ch == ')') {
                i++;
                // 获取当前字符的右边的数字字符
                int num = getNum();
                // 进行元素的弹出
                Map<String,Integer> popMap = stack.pop();
                // 栈顶元素
                Map<String,Integer> topMap = stack.peek();

                //
                for (Map.Entry<String,Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom,0)+v*num);
                }
            } else {

                // 获得大写字符和小写的跟从字符
                String atom = getAtom();
                // 然后获得右边的数字字符
                int num = getNum();
                Map<String,Integer> map = stack.peek();
                map.put(atom, map.getOrDefault(atom,0)+num);
            }
        }

        Map<String,Integer> map = stack.pop();
        TreeMap<String,Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
    
    /**
     * @description: 
     * @param: [] [] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 10:14
     */
    private int getNum() {
        // 如果是最后的字符或者这个字符并不是字符那么直接返回1
        if(i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while( i < n && Character.isDigit(formula.charAt(i))) {
            // 获得数字，可能数字是多位，要考虑这个情况
            num = num * 10 + formula.charAt(i++) - '0';
        }
        return num;
    }
    /**
     * @description: 
     * @param: [] [] 
     * @return: java.lang.String
     * @author YORICHEONG
     * @date: 2021/7/5 10:14
     */
    private String getAtom() {
        StringBuffer sb = new StringBuffer();
        // 获得当前的大写首字符
        sb.append(formula.charAt(i++));
        while( i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
        return sb.toString();
    }
}
