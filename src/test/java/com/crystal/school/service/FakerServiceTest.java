package com.crystal.school.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FakerServiceTest {

    private final FakerService fakerService = FakerService.getInstance();

    @Test
    void random_returnsAnExistingItem() {
        List<String> items = List.of("a", "b", "c", "d", "e");
        String random = fakerService.random(items);
        assertTrue(items.contains(random));
    }

    @Test
    void random_ReturnsCorrectSizeItemsBasedOnPercentage() {
        List<Integer> integerList = IntStream.range(0, 100).boxed().toList();
        List<Integer> random = fakerService.take(integerList, 100, i -> true);
        assertEquals(integerList.size(), random.size());
        List<Integer> random1 = fakerService.take(integerList, 50, i -> true);
        assertEquals(50, random1.size());
    }
}