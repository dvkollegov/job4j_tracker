package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class SortString {
    public static void main(String[] args) {
        String[] str = {"abcfsf", "uio", "fhfh", "asd"};
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(str, cmpText);
        Arrays.sort(str, cmpDescSize);
    }
}
