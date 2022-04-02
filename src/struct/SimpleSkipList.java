package struct;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/4/1 10:09
 * @Tags
 **/
public class SimpleSkipList {

    static final int DEFAULT_JUDGE_COUNT = 5;

    int judgeCount;

    private List head;

    public SimpleSkipList() {
        this(DEFAULT_JUDGE_COUNT);
    }

    public SimpleSkipList(int judgeCount) {
        this.judgeCount = judgeCount;
        head = new List();
        head.head = new Node(-1, -1);
        head.tail = new Node(-1, -1);
        head.perCount = 0;
    }

    public void insert(int key, int score) {

    }

    static class Node {
        int value;
        int score;
        Node next;
        Node down;
        Node up;

        public Node(int score, int value) {
            this.score = score;
            this.value = value;
        }
    }

    static class List {
        Node head;
        Node tail;
        int perCount;
    }

}
