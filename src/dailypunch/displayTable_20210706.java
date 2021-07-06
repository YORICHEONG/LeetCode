package dailypunch;

import java.util.*;

/**
 * @description:
 *
 * Input: orders =
 * [["David","3","Ceviche"],
 * ["Corina","10","Beef Burrito"],
 * ["David","3","Fried Chicken"],
 * ["Carla","5","Water"],
 * ["Carla","5","Ceviche"],
 * ["Rous","3","Ceviche"]]
 * Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * Explanation:
 * The displaying table looks like:
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
 * For the table 5: Carla orders "Water" and "Ceviche".
 * For the table 10: Corina orders "Beef Burrito".
 *
 *
 * @author YORICHEONG
 * @date 2021/7/6 9:25
 * @version 1.0
 */
public class displayTable_20210706 {
    /**
     * @description:
     * @param: [List<List < String>>] [orders] 
     * @return: List<List < String>>
     * @author YORICHEONG
     * @date: 2021/7/6 9:26
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        // create a set to store the food name
        HashSet<String> nameSet = new HashSet<>();
        // CREATE A MAP TO STORE THE TABLE NUMBER AND WHAT FOOD NAME IN THIS TABLE AND IT NUMBERS
        Map<Integer, Map<String,Integer>> tableMap = new HashMap<Integer, Map<String,Integer>>();
        // DO THE ITERATOR FOR THE ORDERS
        for(List<String> list : orders) {
            // OBTAIN THE FOOD NAME
            nameSet.add(list.get(2));
            // OBTAIN THE TABLE ID
            int tableId = Integer.parseInt(list.get(1));
            // CREATE A MAP TO STORE THE FOOD AND NUMBERS RELATION
            Map<String, Integer> map = tableMap.getOrDefault(tableId,new HashMap<String, Integer>());
            // UPDATE CURRENT FOOD IN THIS TABLE NUMBER AND STORE IN THE MAP
            map.put(list.get(2),map.getOrDefault(list.get(2),0)+1);
            tableMap.put(tableId,map);
        }

        // ORDER FOOD NAME
        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        for(String name : nameSet) {
            names.add(name);
        }
        // SORT THE FOOD NAME
        Collections.sort(names);

        // GET THE TABLE ID
        int m = tableMap.size();
        List<Integer> ids = new ArrayList<>();
        for(int id : tableMap.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);


        // SHOW THE TABLE MEANS
        List<List<String>> table = new ArrayList<List<String>>();
        List<String> header = new ArrayList<>();
        // STORE THE FOOD NAME TO THE HEADER LIST
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        table.add(header);
        // DO ITERATOR @VARIABLE:TABLEMAP
        for (int i = 0; i < m; i++) {
            int tableID = ids.get(i);
            Map<String,Integer> tableLine = tableMap.get(tableID);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(tableID));
            for (int j = 0; j < n; j++) {
                row.add(Integer.toString(tableLine.getOrDefault(names.get(j),0)));
            }
            table.add(row);
        }
        return table;
    }
}
