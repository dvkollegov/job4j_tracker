package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {
    @Test
    public void whenValidJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Andrey", 1),
                new Job("Dima", 2),
                new Job("Petr", 5),
                new Job("Sergey", 3),
                new Job("Ivan", 4)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Andrey", 1),
                new Job("Dima", 2),
                new Job("Sergey", 3),
                new Job("Ivan", 4),
                new Job("Petr", 5)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}