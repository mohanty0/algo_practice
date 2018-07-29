package main.ctci.ArraysStrings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public Boolean impl(String in) {
        if (in.length()==1) return true;
        Map<Character, Integer> charMap = getCharMap(in.toLowerCase());
        if (in.length()%2==0) {
            for (char c : charMap.keySet()) {
                if (charMap.get(c)%2!=0) return false;
            }
        } else {
            Boolean oneOdd = false;
            for (char c : charMap.keySet()) {
                if (charMap.get(c)%2!=0) oneOdd = true;
                else if (oneOdd && charMap.get(c)%2!=0) return false;
            }
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
        String test1 = "hhaa";
        String test2NotPal = "hhha";
        String test3 = "hhaal";
        String test4NotPal = "hhaaappp";
        String test5 = "tactcao";
        String test6 = "aaaaaaa";

        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assert palindromePermutation.impl(test1) == true;
        assert palindromePermutation.impl(test2NotPal) == false;
        assert palindromePermutation.impl(test3) == true;
        assert palindromePermutation.impl(test4NotPal) == false;
        assert palindromePermutation.impl(test5) == true;
        assert palindromePermutation.impl(test6) == true;

    }
}
