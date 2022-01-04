package com.memorization;

public class TossStrangeCoin_1DBottomUp implements TossStrangeCoin {

    /**
     * @param prob
     * @param target
     * @return
     *
     * with k+, t-, we have below relations
     * prob(k, t) = prob(k + 1, t - 1) * p[k] + prob(k + 1, t) * (1 - p[k])
     * It finally digs down to Bottom (k ==> p[].len; t ==> 0), then feed data up to Top.
     * So-called Bottom-up, also the threshold should be like "prob(p.len, 0) = 1"
     *
     * res[idx + 1][curT - 1] and res[idx + 1][curT] can be abstracted to "prev and curr"
     * It turns out to be that only one line array is being used
     * Each time the array's values are cached using prev and curr
     * Later the array is overwritten with res[idx][..] onto res[idx+1][..]
     */
    @Override
    public double probOfHeadsUp(double[] prob, int target) {
        double[] res = new double[target + 1];
        res[0] = 1;

        for(int idx = prob.length - 1; idx >= 0; idx--) {
            double prev = 0;
            for(int curT = 0; curT <= target; curT++) {
                double curr = res[curT]; // Store line-(idx+1) info
                res[curT] = (curT < 1 ? 0 : prev * prob[idx]);
                res[curT] += curr * (1 - prob[idx]);
                prev = curr;
            }
        }
        return res[target];
    }
}
