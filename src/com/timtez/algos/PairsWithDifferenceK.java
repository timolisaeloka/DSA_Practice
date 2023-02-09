package com.timtez.algos;

import java.util.*;
// https://github.com/akshayavb99/CodingNinjas_Java_DSA/blob/master/Course%202%20-%20Data%20Structures%20in%20JAVA/Lecture%2016%20-%20HashMaps/Pairs%20with%20difference%20K
public class PairsWithDifferenceK {
    private static int pairsWithDifferenceK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        /*
         * If k is not zero, the code loops through the HashMap and checks if the current key plus k or the current key minus k exists in the HashMap.
         * If it does, it adds the product of the frequencies of those two keys to the countPairs variable.
         * Finally, the code returns the value of countPairs divided by 2, since each pair was counted twice.
         * */
        int countPairs = 0;

        if (k == 0) {
            for (Integer i : map.keySet()) {
                int value = map.get(i);
                // it used to find the number of pairs with same value in the array.
                countPairs += value * (value - 1) / 2;
            }
            return countPairs;
        }

        for (Integer i : map.keySet()) {
            if (map.containsKey(k + i)) {
                countPairs += map.get(i) * map.get(k + i);
            }
            if (map.containsKey(i - k)) {
                countPairs += map.get(i) * map.get(i - k);
            }
        }
        return countPairs / 2;
    }

    public static void main(String[] args) {
        int res = pairsWithDifferenceK(new int[]{5, 1, 2, 4}, 3);
        int res1 = pairsWithDifferenceK(new int[]{4, 4, 4, 4}, 3);
        System.out.println(res);
        System.out.println(res1);
    }
}
