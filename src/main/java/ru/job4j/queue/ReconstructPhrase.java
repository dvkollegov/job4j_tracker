package ru.job4j.queue;

import java.util.Deque;
import java.util.Queue;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Queue<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                rsl.append(evenElements.peek());
            }
            evenElements.poll();
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            rsl.append(descendingElements.peekLast());
            descendingElements.pollLast();
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
