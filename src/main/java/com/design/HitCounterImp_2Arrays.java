package com.design;

public class HitCounterImp_2Arrays implements HitCounter {
    private final int sec;
    private final int[] hits;
    private final int[] tsIdx;

    public HitCounterImp_2Arrays() {
        sec = 300;
        hits = new int[sec];
        tsIdx = new int[sec];
    }

    @Override
    public void hit(int timestamp) {
        int idx = timestamp % sec;
        if(tsIdx[idx] != timestamp) {
            tsIdx[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx] += 1;
        }
    }

    @Override
    public int getHits(int timestamp) {
        int idx = timestamp % sec;
        int sum = 0;
        for(int i = 0; i < sec; i++) {
            if(timestamp - tsIdx[i] < 300) {
                sum += hits[i];
            }
        }
        return sum;
    }
}
