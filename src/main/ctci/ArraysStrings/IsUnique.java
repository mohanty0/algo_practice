package main.ctci.ArraysStrings;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {

    public  boolean impl(String in) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        if (in.length()<=1) return true;
        for (char c : in.toCharArray()) {
            if (charCountMap.get(c)==null)  charCountMap.put(c, 1);
            else return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String notUnique = "potato";
        String unique = "charles";
        String defNotUnique = "hellisplaceonearth";

        IsUnique isUnique = new IsUnique();
        assert isUnique.impl(unique) == true;
        assert isUnique.impl(notUnique) == false;
        assert isUnique.impl(defNotUnique) == false;




    }
}
