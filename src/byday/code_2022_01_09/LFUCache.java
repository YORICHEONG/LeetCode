package byday.code_2022_01_09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description 实现LFU算法
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/9 11:11
 * @Tags
 **/
public class LFUCache {
    int minFreq, capacity;

    Map<Integer, Entry> key_table;

    Map<Integer, LinkedList<Entry>> freq_table;


    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        key_table = new HashMap<>();
        freq_table = new HashMap<>();
    }

    public int get(int key) {
        if(0 == capacity) {
            return -1;
        }
        if(!key_table.containsKey(key)) {
            return -1;
        }
        Entry node = key_table.get(key);
        int value = node.value;
        int freq = node.frequency;

        freq_table.get(freq).remove(node);
        if(freq_table.get(freq).size() == 0) {
            freq_table.remove(freq);
            if(minFreq == freq) {
                minFreq += 1;
            }
        }
        LinkedList<Entry> list = freq_table.getOrDefault(freq + 1, new LinkedList<Entry>());
        list.offerFirst(new Entry(key, value, freq + 1));
        freq_table.put(freq + 1, list);
        key_table.put(key, freq_table.get(freq + 1).peekFirst());
        return value;
    }

    public void put(int key, int value) {
        if(0 == capacity) {
            return;
        }
        if(!key_table.containsKey(key)) {
            // 缓存已满，就需要进行删除操作
            if(key_table.size() == capacity) {
                Entry node = freq_table.get(minFreq).peekLast();
                key_table.remove(node.key);
                if(freq_table.get(minFreq).size() == 0) {
                    freq_table.remove(minFreq);
                }
            }
            // 如果缓存没有满
            LinkedList<Entry> list = freq_table.getOrDefault(1, new LinkedList<Entry>());
            list.offerFirst(new Entry(key, value, 1));
            freq_table.put(1, list);
            key_table.put(key, freq_table.get(1).peekLast());
            minFreq = 1;
        } else {
            Entry node = key_table.get(key);
            int freq = node.frequency;
            freq_table.get(freq).remove(node);
            if(freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                if(minFreq == freq) {
                    minFreq += 1;
                }
            }
            LinkedList<Entry> list = freq_table.getOrDefault(freq + 1, new LinkedList<Entry>());
            list.offerFirst(new Entry(key, value, freq + 1));
            freq_table.put(freq + 1, list);
            key_table.put(key, freq_table.get(freq + 1).peekFirst());
        }
    }


    static class Entry {
        public int key;

        public int value;

        public int frequency;

        public Entry() {

        }

        public Entry(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
}
