package com.design;

public interface HitCounter {

    void hit(int timestamp);
    int getHits(int timestamp);
}
