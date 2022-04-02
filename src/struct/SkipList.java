package struct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/3/31 10:51
 * @Tags
 **/
public class SkipList {

    // define the max level value
    static final int MAX_LEVEL = 64;

    static final double SKIP_LIST_FACTOR = 0.25;

    // head and tail and length and level
    private SkipNode head;

    private SkipNode tail;

    private Long length;

    private Integer level;

    private Random random = new Random();

    // construct method
    public SkipList() {
        this.head = createNode(MAX_LEVEL, 0, null);
        this.level = 1;
        this.length = 0l;
        this.head.backWard = null;
        this.tail = null;
    }

    private SkipNode createNode(int level, double score, String value) {
        SkipNode node = new SkipNode();
        node.value = value;
        node.score = score;
        node.skipLevel = new SkipLevel[level];
        return node;
    }

    private Integer randomLevel() {
        int level = 1;

    }

    /**
     * Skip node struct
     */
    static class SkipNode {
        String value;
        Double score;
        SkipNode backWard;
        SkipLevel[] skipLevel;
    }

    /**
     * Skip list level struct
     */
    static class SkipLevel {
        SkipNode forward;
        Long span;
    }

}
