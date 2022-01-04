package com.memorization;

public class TossStrangeCoin_2DBottomUp implements TossStrangeCoin {

    /**
     * @param prob
     * @param target
     * @return
     *
     * with k+, t-, we have below relations
     * prob(k, t) = prob(k + 1, t - 1) * p[k] + prob(k + 1, t) * (1 - p[k])
     * It finally digs down to Bottom (k ==> p[].len; t ==> 0), then feed data up to Top.
     * So-called Bottom-up, also the threshold should be like "prob(p.len, 0) = 1"
     */
    @Override
    public double probOfHeadsUp(double[] prob, int target) {
        double[][] res = new double[prob.length + 1][target + 1];
        res[prob.length][0] = 1;

        for(int idx = prob.length - 1; idx >= 0; idx--) {
            for(int curT = 0; curT <= target; curT++) {
                res[idx][curT] += (curT < 1 ? 0 : res[idx + 1][curT - 1] * prob[idx]);
                res[idx][curT] += res[idx + 1][curT] * (1 - prob[idx]);
            }
        }
        return res[0][target];
    }
}
