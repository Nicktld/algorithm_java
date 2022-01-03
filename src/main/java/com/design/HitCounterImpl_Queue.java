package com.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounterImpl_Queue implements HitCounter {

    private final Deque<Integer> q;
    public HitCounterImpl_Queue() {
        q = new ArrayDeque<>();
    }

    @Override
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    @Override
    public int getHits(int timestamp){
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}
