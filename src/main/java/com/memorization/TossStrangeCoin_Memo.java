package com.memorization;

import java.util.Arrays;

public class TossStrangeCoin_Memo implements TossStrangeCoin {

    @Override
    public double probOfHeadsUp(double[] prob, int target) {
        double[][] memo = new double[prob.length][target + 1];
        for(double[] mm : memo) {
            Arrays.fill(mm, 0);
        }
        return probOfHeadsUp_helper(prob, 0, target, memo);
    }

    private double probOfHeadsUp_helper(double[] prob, int idx, int target, double[][] memo) {
        if(target < 0) return 0;
        if(idx == prob.length) return (target == 0 ? 1 : 0);
        if(memo[idx][target] != -1) return memo[idx][target];

        double tmpProb = probOfHeadsUp_helper(prob, idx + 1, target - 1, memo) * prob[idx];
        tmpProb += probOfHeadsUp_helper(prob, idx + 1, target, memo) * (1 - prob[idx]);
        memo[idx][target] = tmpProb;
        return tmpProb;
    }
}
