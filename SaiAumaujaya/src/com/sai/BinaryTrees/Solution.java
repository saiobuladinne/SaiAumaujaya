package com.sai.BinaryTrees;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations, 
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
	    if(numDestinations <1 || allLocations.size() != numDestinations || numDeliveries > numDestinations){
	        return null;
	    }
	    //Tree Map sorted order
	       TreeMap<Integer,List<Integer>> ranks = new TreeMap<Integer,List<Integer>>();
	    
	    for(List<Integer> locations:allLocations){
	        ranks.put(getRank(locations),locations);
	    }
	    //TODO from above map, get the delivered locations
	  List<List<Integer>> deliveryLocations= getDeliveryLocations(ranks,numDeliveries);
        
        return deliveryLocations;
    }
    
    private List<List<Integer>> getDeliveryLocations(TreeMap<Integer,List<Integer>> ranks,int numDeliveries){
        int counter=1;
        
        List<List<Integer>> deliveryLocations = new ArrayList<List<Integer>>();
        List<Integer> tieValue=null;
        for(Entry<Integer,List<Integer>> rank:ranks.entrySet()){
        	tieValue= rank.getValue();;
            counter++;
            deliveryLocations.add(rank.getValue());
            if(counter>=numDeliveries){
            	break;
            }
        }
        
        return deliveryLocations;
    }
    
    private Integer getRank(List<Integer> locations){
        return locations.get(0) * locations.get(0) + locations.get(1) * locations.get(1);
    }
    
    // METHOD SIGNATURE ENDS
}