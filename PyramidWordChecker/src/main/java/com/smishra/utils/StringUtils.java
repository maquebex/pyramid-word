package com.smishra.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smishra.exceptions.ReturnCodes;

public class StringUtils {
    public static String getValue(String data) {
    	String valStr = data.split(":")[1];
    	return valStr.substring(1,valStr.lastIndexOf("\""));
    }
    public static Map<Character, Integer> charCountMap(String input){
    	Map<Character,Integer> characterCount = new HashMap<Character,Integer>();
		for(int i=0;i<input.length();i++) {
			Character c = input.charAt(i);
			if(characterCount.containsKey(c)) {
				int currcount = characterCount.get(c);
				characterCount.put(c,currcount+1);
			} else {
				characterCount.put(c, 1);
			}
		}
		return characterCount;
    }
    public static boolean validateInput(String s) {
        return s != null && s.length()!=0 && s.matches("^[a-zA-Z0-9]*$");
    }
    public static boolean hasDuplicates(List<Integer> inputList) {
		for(int i=0;i<inputList.size()-1;i++) {
			if(inputList.get(i)==inputList.get(i+1)) {
				return true;
			}
		}
		return false;
	}
}
