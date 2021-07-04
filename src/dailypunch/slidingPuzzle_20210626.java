package dailypunch;

import java.util.*;

class SlidingPuzzle {
    int[][] neighbors = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        // 将给定的二位数组添加到这个strigbuffer中
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        int step = 0;

        // 创建一队列
        Queue<String> queue = new LinkedList<String>();
        queue.offer(initial);

        // 创建一个不可重复集合
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextString : get(status)) {
                    if (!seen.contains(nextString)) {
                        if ("123450".equals(nextString)) {
                            return step;
                        }
                        queue.offer(nextString);
                        seen.add(nextString);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> get(String status) {
        List<String> set = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');

        for (int y : neighbors[x]) {
            swap(array, x, y);
            set.add(new String(array));
            swap(array, x, y);
        }

        return set;
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}