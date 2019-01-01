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

public class RetrieveMostFrequentlyUsedWordsUsingStringBuffer {

	public static void main(String[] args) {
		String literatureText = "|||| ||||| ||| | | | |123 132 123 134 453 3 35 45 465 454 64 45634 356435y64 53 5234 2354234 345 3 45 345 df3 45t b fgb s5 g dfg5 wg5y re56 y465y ethsrd56ye46 5w 64y sfg 56 w45y";
		String[] wordsToExclude = {"charan", "sujithe", "raja", "lekhya","and","to","cheese","jack"};
		HashMap<String,String> excludeMap = new HashMap<String,String>();
		HashMap<String,Integer> occurencesMap = new HashMap<String,Integer>();
		for(int i=0;i<wordsToExclude.length;i++) {
			if(!wordsToExclude[i].isEmpty()) {
				String lowerCase = wordsToExclude[i].toLowerCase();
				excludeMap.put(lowerCase, lowerCase);
			}
		}
		        
		int counter = 1;
		String[] split = literatureText.split("\\s*(=>|,|\\s)\\s*|\\.|\\'|\\$| |\\@|\\:|\\;|\\#|\\?");
		for(int i=0;i<split.length;i++) {
			if(!split[i].isEmpty()) {
				StringBuffer alpha = new StringBuffer(),num = new StringBuffer(), special = new StringBuffer();
				String lowerCase = split[i].toLowerCase();
				String alphaSample = lowerCase;
				try {
					Double.parseDouble(alphaSample);
					populateOccurencesMap(excludeMap, occurencesMap, counter, alphaSample.toString());
					continue;
				} catch (NumberFormatException e) {

				}
				for (int j=0; j<alphaSample.length(); j++)
		        {
		            if (Character.isDigit(alphaSample.charAt(j)))
		                num.append(alphaSample.charAt(j));
		            else if(Character.isAlphabetic(alphaSample.charAt(j)))
		                alpha.append(alphaSample.charAt(j));
		            else
		                special.append(alphaSample.charAt(j));
		        }
				if(num.length()>0) {
					populateOccurencesMap(excludeMap, occurencesMap, counter, num.toString());
				}
				if(alpha.length()>0) {
					populateOccurencesMap(excludeMap, occurencesMap, counter, alpha.toString());
				}
				if(special.length()>0) {
					populateOccurencesMap(excludeMap, occurencesMap, counter, special.toString());
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

	private static int populateOccurencesMap(HashMap<String, String> excludeMap, HashMap<String, Integer> occurencesMap,
			int counter, String lowerCase) {
		if(!excludeMap.containsKey(lowerCase)) {
			if(occurencesMap.containsKey(lowerCase)) {
				counter = occurencesMap.get(lowerCase);
				occurencesMap.put(lowerCase, counter+1);
			}else {
				occurencesMap.put(lowerCase, counter);
			}
		}
		return counter;
	}

}
