/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.core.utils;

import java.util.Arrays;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FibonacciNumberUtils {

    public static boolean useFixed = true;

    public static boolean isFibo(int value) {
        return useFixed
                ? Arrays.binarySearch(generateFibboFixed(), value) >= 0
                : Arrays.binarySearch(generateFibboNumbers(30), value) >= 0;
    }

    public static Integer[] generateFibboFixed() {
        return new Integer[]{1, 2, 3, 5, 8, 13, 21, 40, 100, 999};
    }

    public static int[] generateFibboNumbers(int amount) {
        int[] arr = new int[amount];//1 2 3 5 8 13 21 34 55 89 144
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < amount; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
