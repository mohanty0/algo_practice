package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem: https://leetcode.com/problems/combination-sum/description/ */

public class CombinationSum {


    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        backtrack(results, new ArrayList<Integer>(), candidates, target, 0);
        return results;
    }

    private static void backtrack(List<List<Integer>> results, List<Integer> tempResults, int[] candidates, int remain, int start) {
        if (remain < 0 ) return;
        else if (remain==0) results.add( new ArrayList<Integer>(tempResults));
        else {
            for (int i=start; i<candidates.length; i++) {
                tempResults.add(candidates[i]);
                backtrack(results, tempResults, candidates, remain-candidates[i], i);
                tempResults.remove(tempResults.size()-1);
            }
        }
    }
}
