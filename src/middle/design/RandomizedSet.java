package middle.design;

import java.util.*;
/**
 * 	2021-06-24 14:53:49
 	author:YORICHEONG
 	Implement the RandomizedSet class:
	RandomizedSet() Initializes the RandomizedSet object.
	bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
	bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
	int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 */
public class RandomizedSet {	

	private Map<Integer,Integer> map;
	private List<Integer> list;
	Random rand = new Random();

	/** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	
    	// search the map, if contains the valu return false
    	if(map.containsKey(val)){
    		return false;
    	}
    	// no contains the value
    	// use the list size as the value, val as the key put the map
    	map.put(val,list.size());
    	// list add the val
    	list.add(list.size(),val);

    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	// first, object the hasContains remove value
    	if(!map.containsKey(val)) {
    		return false;
    	}

    	// if need to rmove the value, exchange the last value with the remove value
    	// when did this change, then remove the last index value

    	// find the last value in the list
    	int lastValue = list.get(list.size()-1);
    	// get the remove value index 
    	int removeIndex = map.get(val);

    	// update the last value into the remove value location
    	list.set(removeIndex,lastValue);
    	map.put(lastValue,removeIndex);

    	// remove the last index value
    	list.remove(list.size()-1);
    	map.remove(val);

    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	return list.get(rand.nextInt(list.size()));
    }    
}
