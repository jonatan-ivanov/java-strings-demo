package org.example.strings;

import static java.lang.System.getProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final List<String> TEST_STRINGS = List.of(
        "Java",
        "我喜欢茶",
        "𝕒𝕓𝕔",
        "👩❤☕",
        "👩‍💻❤️🍵"
    );

    public static void main(String[] args) {
        System.out.printf("%s %s (%s)%n", getProperty("java.vm.vendor"), getProperty("java.vm.version"), getProperty("java.vm.name"));

        System.out.println("\n--- Length ---");
        transformAndPrint(String::length, TEST_STRINGS);

        System.out.println("\n--- Code Point Count ---");
        transformAndPrint(Main::codePointCount, TEST_STRINGS);

        System.out.println("\n--- Code Points ---");
        transformAndPrint(Main::codePoints, TEST_STRINGS);

        System.out.println("\n--- Code Units ---");
        transformAndPrint(Main::codeUnits, TEST_STRINGS);

        System.out.println("\n--- Buggy Reverse ---");
        transformAndPrint(Main::buggyReverse, "ab𝕔", "𝕒𝕓𝕔");

        System.out.println("\n--- Reverse ---");
        transformAndPrint(Main::reverse, "ab𝕔", "𝕒𝕓𝕔");

        System.out.println("\n--- Substring(0,5) ---");
        transformAndPrint(Main::substring, "𝕒𝕓𝕔", "abc👩‍💻", "a👩‍💻");
    }

    private static void transformAndPrint(Function<String, ?> function, String... array) {
        transformAndPrint(function, Arrays.stream(array).toList());
    }

    private static void transformAndPrint(Function<String, ?> function, Collection<String> collection) {
        collection.forEach(item -> System.out.println(item + " -> " + function.apply(item)));
    }

    private static int codePointCount(String str) {
        return str.codePointCount(0, str.length());
    }

    private static String codeUnits(String str) {
        return str.chars()
            .mapToObj(Integer::toHexString)
            .map(String::toUpperCase)
            .map(hex -> "\\u" + hex)
            .collect(Collectors.joining(" "));
    }

    private static String codePoints(String str) {
        return str.codePoints()
            .mapToObj(Integer::toHexString)
            .map(String::toUpperCase)
            .map(hex -> "U+" + hex)
            .collect(Collectors.joining(" "));
    }

    private static String buggyReverse(String original) {
        String result = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            result += original.charAt(i);
        }

        return result;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String substring(String str) {
        return str.substring(0, 5);
    }
}
