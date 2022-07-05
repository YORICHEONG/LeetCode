package swordfingeroffer;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/7/5 10:08
 * @Tags
 **/
public class MyCalendarSolution {

    public static void main(String[] args) {
        // un test
    }

    /**
     *
     */
    class TimeNode{
        int start;

        int end;

        TimeNode left;

        TimeNode right;

        public TimeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         *
         * @param newNode
         * @return
         */
        public boolean insertTimeNode(TimeNode newNode) {
            if(newNode.end < this.start) {
                if(this.left == null) {
                    this.left = newNode;
                    return true;
                } else {
                    return this.left.insertTimeNode(newNode);
                }
            } else if(newNode.start >= this.end) {
                if(this.right == null) {
                    this.right = newNode;
                    return true;
                } else {
                    return this.right.insertTimeNode(newNode);
                }
            } else {
                return false;
            }

        }
    }

    /**
     *
     */
    class MyCalendar {

        TimeNode root;

        public MyCalendar() {
            root = null;
        }

        public boolean book(int start, int end) {
            if(root == null) {
                root = new TimeNode(start, end);
                return true;
            }
            return root.insertTimeNode(new TimeNode(start, end));
        }
    }
}
