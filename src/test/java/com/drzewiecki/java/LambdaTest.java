package com.drzewiecki.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    void testConsumer() {
        Consumer<List<String>> upper = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, list.get(i).toUpperCase(Locale.ROOT));
        };

        Consumer<List<String>> addIndexInfo = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, "index=" + i + " value=" + list.get(i));
        };

        Consumer<List<String>> display = list -> list
                .forEach(a -> System.out.println(a));

        List<String> strings = new ArrayList<>();
        strings.add("John");
        strings.add("Emily");
        strings.add("Kyle");

        upper
                .andThen(display)
                .andThen(addIndexInfo)
                .andThen(display)
                .accept(strings);
    }

}
