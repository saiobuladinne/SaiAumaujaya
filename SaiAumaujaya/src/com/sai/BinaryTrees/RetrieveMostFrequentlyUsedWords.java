package com.sai.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetrieveMostFrequentlyUsedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String literatureText = "Jack and Jack's Jill went to the market to buy bread and cheese. Cheese is Jack's jill and Jill's favorite food. the";
		String literatureText = "code 4 you 12#345@67dfvbb?8";
		String[] wordsToExclude = {"charan", "sujithe", "raja", "lekhya", "jill","and","s","to","cheese"};
		HashMap<String,String> excludeMap = new HashMap<String,String>();
		HashMap<String,Integer> occurencesMap = new HashMap<String,Integer>();
		for(int i=0;i<wordsToExclude.length;i++) {
			if(!wordsToExclude[i].isEmpty()) {
				String lowerCase = wordsToExclude[i].toLowerCase();
				excludeMap.put(lowerCase, lowerCase);
			}
		}
		int counter = 1;
		//String[] split = literatureText.split(" |'|,|.|+|_|:|;|-|@|#|?|&|$");
		
		String[] split = literatureText.split("\\s*(=>|,|\\s)\\s*|\\.|\\'|\\$| |\\@|\\:|\\;|\\#|\\?");
		for(int i=0;i<split.length;i++) {
			if(!split[i].isEmpty()) {
				String lowerCase = split[i].toLowerCase();
				if(!excludeMap.containsKey(lowerCase)) {
					if(occurencesMap.containsKey(lowerCase)) {
						counter = occurencesMap.get(lowerCase);
						occurencesMap.put(lowerCase, counter+1);
					}else {
						occurencesMap.put(lowerCase, counter);
					}
				}
				
			}
		}
		int max_val=0;
		
		List<Entry<String, Integer>> collect = occurencesMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < collect.size(); i++) {
			Entry<String, Integer> entry = collect.get(i);
			if (entry.getValue() >= max_val) {
				max_val = entry.getValue();
				resultList.add(entry.getKey());
				 
			} else {
				break;
			}
		}
		String[] resultArray = new String[resultList.size()];
		resultList.toArray(resultArray);
		for(int i=0;i<resultArray.length;i++) {
			
			System.out.println(resultArray[i]);
		}
	}

}
