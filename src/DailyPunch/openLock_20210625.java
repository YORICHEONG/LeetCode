package DailyPunch;
import java.util.*;
/**
 * @authro YORICHEONG
 * @date 2021-06-25 09:24:12
 * description:You have a lock in front of you with 4 circular wheels. 
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
   The lock initially starts at '0000', a string representing the state of the 4 wheels.
   You are given a list of deadends dead ends, meaning if the lock displays any of these codes, 
   the wheels of the lock will stop turning and you will be unable to open it.
   Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class openLock_20210625 {
    public int openLock(String[] deadends, String target) {
        // first to the judge
        if("0000".equals(target)) {
            return 0;
        }
        
        Set<String> dead = new HashSet<>();
        for(String s:deadends) {
            dead.add(s);
        }

        if(dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while(!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String status = queue.poll();
                for(String nextStatus : get(status)) {
                    if(!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if(nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private char numPrev(char x) {
        return x == '0' ? '9':(char)(x-1);
    }

    private char numSucc(char x) {
        return x == '9' ? '0':(char)(x+1);
    }

    private List<String> get(String status) {
        List<String> result = new ArrayList<String>();
        char[] array = status.toCharArray();
        for(int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = numPrev(num);
            result.add(new String(array));
            array[i] = numSucc(num);
            result.add(new String(array));
            array[i] = num;
        }

        return result;
    }
}
