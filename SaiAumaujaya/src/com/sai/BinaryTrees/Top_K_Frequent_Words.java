package com.sai.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Top_K_Frequent_Words {

	public static void main(String[] args) {
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		
		topKFrequent(words,4);
	}

public static List<String> topKFrequent(String[] words, int k) {
        //HashSet<Integer>
	HashMap<String, Integer> map =new HashMap<String, Integer>();
	int frequency = 1;
	
	for(int i=0;i<words.length;i++) {
	
		if(map.containsKey(words[i])) {
			Integer integer = map.get(words[i]);
			map.put(words[i], frequency+integer);
		}else {
			map.put(words[i], frequency);
		}
	}
	List<Entry<String, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).collect(Collectors.toList());
	List<String> list = new ArrayList<String>();
	collect.forEach(c->list.add(c.getKey()));
	return list;
    }
}
