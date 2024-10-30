package com.drzewiecki.java.collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {

    @Test
    void testHashSet() {

    }

    /**
     * Ordered version of hashset
     * double-linked List across all elements
     */
    @Test
    void testLinkedHashSet() {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("D");

        assertThat(set.size()).isEqualTo(4);

        set.remove("D");

        assertThat(set.size()).isEqualTo(3);

    }
}
