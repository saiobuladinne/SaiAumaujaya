package carwash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author programmer
 *
 */
public class Solution {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		for(String string:strings) {
			findFirstNonRepeatingCharacter(string);
		}
	

	
	}
	private static char findFirstNonRepeatingCharacter(String string) {
		if(string==null) {
			return new char("a");
		}
		LinkedHashMap<Integer, Long> collect = string.chars().boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		
		char map = (char)(int)collect.entrySet().stream().filter(e->e.getValue() ==1L).findFirst().map(Map.Entry::getKey).orElse(0));
		return map;
		
	}
}
