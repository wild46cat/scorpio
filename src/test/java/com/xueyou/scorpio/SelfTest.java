package com.xueyou.scorpio;

import static com.google.common.base.Preconditions.checkArgument;

public class SelfTest {
    public static void main(String[] args) {
        try {
            int c = 10;
            checkArgument(c > 100, "%s is not bigger than 100", c);
            System.out.println("ok");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
