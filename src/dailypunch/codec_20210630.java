package dailypunch;
import middle.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YORICHEONG
 * @date 2021-06-30 09:24:55
 * @description 
 */
public class codec_20210630 {

    private final String none = "None";
    
    /**
     * @description: 
     * @param: [middle.tree.TreeNode] [root] 
     * @return: java.lang.String
     * @author YORICHEONG
     * @date: 2021/6/30 10:18
     */
    public String serialize(TreeNode root) {
        return reserialize(root,"");
    }
    
    /**
     * @description:
     * @param: [java.lang.String] [data] 
     * @return: middle.tree.TreeNode
     * @author YORICHEONG
     * @date: 2021/6/30 10:18
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = Arrays.asList(dataArray);
        List<String> list = new ArrayList<>(dataList);
        return redeserialize(list);
    }
    
    /**
     * @description:
     * @param: [middle.Tree.TreeNode, java.lang.String] [root, str] 
     * @return: java.lang.String
     * @author YORICHEONG
     * @date: 2021/6/30 9:52
     */
    private String reserialize(TreeNode root,String str) {
        if(root == null) {
            str += none+",";
        } else {
            str += String.valueOf(root.val)+",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }

        return str;
    }

    /**
     * @description:
     * @param: [java.util.List<java.lang.String>] [list] 
     * @return: middle.Tree.TreeNode
     * @author YORICHEONG
     * @date: 2021/6/30 9:49
     */
    private TreeNode redeserialize(List<String> list) {
        if(none.equals(list.get(0))) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = redeserialize(list);
        root.right = redeserialize(list);

        return root;
    }
}
