package pl.sda.collections.examples;

import java.util.LinkedList;
import java.util.Queue;

public class QueueService {

    public static void main(String[] args) {
        Queue<String> events = new LinkedList<>();
        boolean buttonClicked = events.offer("ButtonClicked");
        events.offer("MouseMoved");
        events.offer(null);

        String event1 = events.peek();
        String event2 = events.poll();
        String event3 = events.poll();

        System.out.println(event1);
        System.out.println(event2);
        System.out.println(event3);

        String event4 = events.peek();
        System.out.println(event4);
//        String event4 = events.element();

        System.out.println(events.isEmpty());
    }
}

