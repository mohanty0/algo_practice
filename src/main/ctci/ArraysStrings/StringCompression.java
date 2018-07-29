package main.ctci.ArraysStrings;

public class StringCompression {
    public String impl (String in) {
        if (in.length()<=1) return in;

        boolean compressionRequired = false;
        char compressionChar  = in.charAt(0);
        int compressionCount = 1;
        String compressedString = "";

        for (int i=1; i<in.length(); i++) {
            char currChar = in.charAt(i);
            if (currChar == compressionChar) {
                compressionRequired = true;
                compressionCount++;

            } else {
                compressedString += compressionChar + "" + compressionCount;
                compressionCount = 1;
                compressionChar = currChar;
            }
        }
        compressedString += compressionChar + "" + compressionCount;

        if (compressionRequired) return  compressedString;
        else return in;
    }

    public static void main(String argv[]) {
        String testNonCompressed1 = "aaaabbbcccahw";
        String testCompressed1 = "a4b3c3a1h1w1";
        String testNonCompressed2 = "abcdwwwww";
        String testCompressed2 = "a1b1c1d1w5";
        String testNonCompressed3 = "aaaabcd";
        String testCompressed3 = "a4b1c1d1";
        String testCompressionNotRequired = "abcde";

        StringCompression stringCompression = new StringCompression();
        assert stringCompression.impl(testNonCompressed1).equals(testCompressed1);
        assert stringCompression.impl(testNonCompressed2).equals(testCompressed2);
        assert stringCompression.impl(testNonCompressed3).equals(testCompressed3);
        assert stringCompression.impl(testCompressionNotRequired).equals(testCompressionNotRequired);
    }
}
