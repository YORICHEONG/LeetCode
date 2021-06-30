package DailyPunch;
import middle.Tree.TreeNode;
import java.util.List;
import java.util.ArrayList;
/**
 * @author YORICHEONG
 * @date 2021-06-30 09:24:55
 * @description 
 */
public class codec_20210630 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    }

    private String reserialize(TreeNode root,String str) {
        if(root == null) {
            str += "None,";
        } else {
            str += str.valueOf()+",";
        }
    }
}
