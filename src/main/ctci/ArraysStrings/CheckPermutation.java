package main.ctci.ArraysStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public  Boolean impl(String in1, String in2) {
        Map<Character, Integer> charMap1 = getCharMap(in1);
        Map<Character, Integer> charMap2 = getCharMap(in2);

        for (Character c : charMap1.keySet()) {
            if (charMap2.get(c)!= charMap1.get(c)) return false;
        }
        for (Character c: charMap2.keySet()) {
            if (charMap1.get(c) != charMap2.get(c)) return false;
        }


        return true;
    }

    private  Map<Character, Integer> getCharMap(String in) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character c : in.toCharArray()) {
            if (charMap.get(c)== null) charMap.put(c, 1);
            else charMap.put(c, charMap.get(c)+1);
        }
        return charMap;
    }

    public static void main(String argv[]) {
        CheckPermutation checkPermutation = new CheckPermutation();
        assert checkPermutation.impl("hello", "helo") == false;
        assert checkPermutation.impl("hello", "lelho") == true;
    }

}
