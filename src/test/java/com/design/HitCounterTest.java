package com.design;

public class HitCounterTest {

    void testProcess(HitCounter hC) {
        hC.hit(1);
        hC.hit(2);
        hC.hit(3);
        System.out.println(hC.getHits(4));
        hC.hit(300);
        System.out.println(hC.getHits(300));
        System.out.println(hC.getHits(301));
    }
    public static void main(String[] args) {
        HitCounterTest hCTest = new HitCounterTest();
        System.out.println("== HitCounterImpl_Queue() ==");
        hCTest.testProcess(new HitCounterImpl_Queue());
        System.out.println("== HitCounterImpl_2Arrays() ==");
        hCTest.testProcess(new HitCounterImp_2Arrays());
    }
}
