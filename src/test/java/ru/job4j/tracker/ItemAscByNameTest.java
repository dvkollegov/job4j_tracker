package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenValidItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("2"),
                new Item("1"),
                new Item("3"),
                new Item("5"),
                new Item("4")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("1"),
                new Item("2"),
                new Item("3"),
                new Item("4"),
                new Item("5")
        );
        assertThat(items).isEqualTo(expected);
    }
}