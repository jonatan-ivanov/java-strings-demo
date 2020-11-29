package org.example.strings;

import static java.lang.String.format;
import static java.lang.System.getProperty;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final List<String> TEST_STRINGS = List.of(
        "Java",
        "我喜欢茶",
        "𝕒𝕓𝕔",
        "🧑❤☕",
        "🧑‍💻❤️🍵"
    );

    public static void main(String[] args) {
        System.out.printf("%s %s (%s)%n", getProperty("java.vm.vendor"), getProperty("java.vm.version"), getProperty("java.vm.name"));

        System.out.println("\n--- length ---");
        transformAndPrint(TEST_STRINGS, String::length);

        System.out.println("\n--- codeUnits ---");
        transformAndPrint(TEST_STRINGS, Main::codeUnits);

        System.out.println("\n--- codePoints ---");
        transformAndPrint(TEST_STRINGS, Main::codePoints);

        System.out.println("\n--- reverse ---");
        transformAndPrint(TEST_STRINGS, Main::reverse);
    }

    private static void transformAndPrint(Collection<String> collection, Function<String, ?> function) {
        collection.forEach(item -> System.out.println(item + " -> " + function.apply(item)));
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

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
