package byday.code_2022.code_01.day_06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description Question url : https://leetcode-cn.com/problems/simplify-path/
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/6 10:19
 * @Tags
 **/
public class SimplifyPath {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:56 2022/1/6
     **/
    public String simplifyPath(String path) {
        // 首先使用/来对这个字符串进行一个分割
        String[] names = path.split("/");
        // 然后循环遍历处理..这样的特殊的情况，将实际有效的压入到队列当中
        Deque<String> pathDeque = new ArrayDeque<String>();
        for(String name : names) {
            // .. 表示是上个父类
            if("..".equals(name)) {
                if(!pathDeque.isEmpty()) {
                    // 将上个父类目录进行弹出
                    pathDeque.pollLast();
                }
            } else if(name.length() > 0 && !".".equals(name)) { //如果当前的字符并不是.且当前的字符长度大于0，有效的目录名称添加到队列中
                pathDeque.offerLast(name);
            }
        }
        // 然后将stack中字符进去取出来然后进行遍历
        StringBuilder sb = new StringBuilder();
        if(pathDeque.isEmpty()) {
            sb.append("/");
        } else {
            while(!pathDeque.isEmpty()) {
                sb.append("/");
                sb.append(pathDeque.pollFirst());
            }
        }
        return sb.toString();
    }
}
/**
 * canonical--典型的
 * slash--斜线
 * treated--以…态度对待;以…方式对待;把…看作;把…视为;处理;讨论
 */