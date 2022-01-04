package com.memorization;

public class TossStrangeCoin_Recursion implements TossStrangeCoin {

    @Override
    public double probOfHeadsUp(double[] prob, int target) {
        return probOfHeadsUp_helper(prob, 0, target);
    }

    private double probOfHeadsUp_helper(double[] prob, int idx, int target) {
        if(target < 0) return 0;
        if(idx == prob.length) return target == 0 ? 1 : 0;

        double tmpProb = probOfHeadsUp_helper(prob, idx + 1, target - 1) * prob[idx];
        tmpProb += probOfHeadsUp_helper(prob, idx + 1, target) * (1 - prob[idx]);
        return tmpProb;
    }
}
