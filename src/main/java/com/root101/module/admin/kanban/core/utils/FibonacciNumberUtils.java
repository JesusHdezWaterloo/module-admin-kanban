/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.kanban.core.utils;

import java.util.Arrays;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
