package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        ArrayDeque<Integer> combinedCards = new ArrayDeque<>();

        int currentPlayer = 1;

        combinedCards.offer(Objects.requireNonNull(firstQueue.poll()));
        combinedCards.offer(Objects.requireNonNull(firstQueue.poll()));
        combinedCards.offer(Objects.requireNonNull(secondQueue.poll()));
        combinedCards.offer(Objects.requireNonNull(secondQueue.poll()));

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            if (currentPlayer == 1) {
                firstQueue.offer(combinedCards.pollLast());
                combinedCards.offer(Objects.requireNonNull(firstQueue.poll()));
                combinedCards.offer(Objects.requireNonNull(firstQueue.poll()));
            } else {
                secondQueue.offer(combinedCards.pollLast());
                combinedCards.offer(Objects.requireNonNull(secondQueue.poll()));
                combinedCards.offer(Objects.requireNonNull(secondQueue.poll()));
            }
            currentPlayer = 3 - currentPlayer;
        }

        return combinedCards;
    }
}
