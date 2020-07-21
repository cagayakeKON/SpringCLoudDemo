package com.cagayake.utils;

import java.util.Random;

public class RandomNumber {

    static Random random = new Random();
    public static int createOrderNumber(){
        return random.nextInt(89999999)+10000000;
    }

    public static int createStateNumber(){
        return random.nextInt(3);
    }

    public static int createPrice(){
        return random.nextInt(100000);
    }
}
