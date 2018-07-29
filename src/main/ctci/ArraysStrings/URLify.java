package main.ctci.ArraysStrings;

import java.util.Arrays;


public class URLify {
    public String impl(String in) {
        int len = in.length();
        for (int i=0; i<len; i++) {
            if (in.charAt(i) == ' ') {
                in = in.substring(0, i) + "%20" + in.substring(i+1, len);
                len+=2;
            }
        }
        return in;
    }

    public void implInPlace(char[] in) {
        //assumption 1: enough trailing spaces to allow additional characters
        //assumption 2: trailing spaces dont get URLified
        boolean pastEmpties= false;
        for (int i=in.length-1; i>=0; i--) {
            if (!pastEmpties && in[i] == ' ') continue;
            else {
                pastEmpties = true;

                if (in[i] == ' ') {
                    shiftSubString(i + 1, 2, in);
                    in[i] = '%';
                    in[i + 1] = '2';
                    in[i + 2] = '0';
                }
            }
        }

    }

    private void shiftSubString(int start, int shift, char[] in) {
        for (int i = in.length-1; i>=start; i--) {
            if (in[i] != ' ') {
                in[i+shift] = in[i];
            }
        }
    }

    public static void main(String argv[]) {
        String test1 = " beware the knowers ";
        String test1URL = "%20beware%20the%20knowers%20";

        URLify urLify = new URLify();
        String test1URLified = urLify.impl(test1);
        assert test1URLified.equals(test1URL);

        char[] test2 = "beware the preachers    ".toCharArray();
        char[] test2URL = "beware%20the%20preachers".toCharArray();
        assert test2.length == test2URL.length : "inputs not same size";

        urLify.implInPlace(test2);
        assert Arrays.equals(test2, test2URL);
    }
}
