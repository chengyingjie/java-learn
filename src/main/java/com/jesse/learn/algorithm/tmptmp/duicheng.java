package com.jesse.learn.algorithm.tmptmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class duicheng {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, track, res);

        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> track, List<List<Integer>> res) {
        // 结束条件
        int sum = sumtrack(track);
        if (sum > target) {
            return;
        }

        if (sum == target) {
            // 记录是否已存在
            if (trackExist(track, res)) {
                return;
            }

            List<Integer> newtrack = new ArrayList<>(track);
            Collections.sort(newtrack);
            res.add(newtrack);
            return;
        }

        // 条件选择
        for (int val : candidates) {
            track.add(val);
            backtrack(candidates, target, track, res);
            track.remove(track.size() - 1);
        }
    }

    private boolean trackExist(List<Integer> newTrack, List<List<Integer>> res) {

        for (List<Integer> track : res) {
            if (newTrack.size() != track.size()) {
                continue;
            }

            boolean existTrack = true;
            for (int val : newTrack) {
                if (!track.contains(val)) {
                    existTrack = false;
                    break;
                }
            }

            if (existTrack) return true;
        }

        return false;
    }

    private int sumtrack(List<Integer> track) {
        if (track == null || track.size() <= 0) {
            return 0;
        }

        int sum = 0;
        for (Integer val : track) {
            sum += val;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        duicheng solution = new duicheng();
        solution.combinationSum(candidates, target);
    }
}
