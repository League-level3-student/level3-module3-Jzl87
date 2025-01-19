package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
        
    	ArrayList<String> result = new ArrayList<String>(str.length());
    	
    	for (int index = 0; index < str.length(); index++) {
    		if (!str.substring(index, index+1).equals(" ")) {
    			String curStr = str.substring(0, index) + str.substring(index,index+1).toUpperCase() + str.substring(index+1);
    			result.add(curStr);
    		}
    	}
        
    	return result;
    }
}
