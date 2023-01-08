package com.crystal.school.service;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class FakerService {
    private static FakerService instance;
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    Faker faker = Faker.instance();
    Random random = new Random();

    private FakerService() {
    }

    public static synchronized FakerService getInstance() {
        if (instance == null)
            instance = new FakerService();

        return instance;
    }


    /**
     * This method returns a gender type
     *
     * @return a string of gender type
     */
    public String gender() {
        return fakeValuesService.fetchString("gender.types");
    }

    public <T> T random(List<T> item) {
        Integer chosenItem = faker.random().nextInt(0, item.size() - 1);
        return item.get(chosenItem);
    }

    public <T> T random(List<T> items, Predicate<T> filterPredicate) {
        List<T> filteredItems = items.stream().filter(filterPredicate).toList();
        if (filteredItems.size() <= 2) filteredItems = items;
        return random(filteredItems);
    }

    /**
     * @param <T>             type of the list
     * @param items           the list will be used to generate
     * @param filterPredicate a function which will be used to filter the list
     * @param percentage      how many items in percentage you want to get from the list
     * @return a shuffle list from a list in the parameter
     */
    public <T> List<T> randomList(List<T> items, double percentage, Predicate<T> filterPredicate) {

        int count = (int) Math.round(items.size() * (percentage / 100.0));
        List<T> filtredItems = items.stream().filter(filterPredicate).toList();
        if (filtredItems.size() < count) filtredItems = items;
        List<T> finalItems = filtredItems;
        return IntStream.range(0, count).mapToObj(i -> random(finalItems)).toList();
    }

    /**
     * @param items      the list will be used to generate
     * @param percentage how many items in percentage you want to get from the list
     * @param <T>        type of the list
     * @return takes only some items from the list in the parameter, it will keep the order
     */
    public <T> List<T> take(List<T> items, double percentage, Predicate<T> filterPredicate) {
        int count = (int) (items.size() * (percentage / 100.0));
        List<T> ts = items.stream().filter(filterPredicate).limit(count).toList();
        if (ts.size() <= 1)
            ts = items.stream().limit(count).toList();
        return ts;
    }


    public Timestamp randomDateTime(int startYear) {
        int yearFromNow =  LocalDateTime.now().getYear() - startYear;
        long minMills = LocalDateTime.now().minusYears(yearFromNow).toInstant(ZoneOffset.UTC).toEpochMilli();
        long maxMillis = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        long randomMillis = (long) (random.nextDouble() * (maxMillis - minMills + 1));
        Instant instant = Instant.ofEpochMilli(randomMillis);
        return Timestamp.from(instant);
    }
}
