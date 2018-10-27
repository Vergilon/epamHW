package com.epam.lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for creating threads of some ATMs
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class ATMService {
    /**
     * Start of execution of the interaction of cash machines and payment system.
     *
     * @param count of ATMs
     */
    public void start(int count) {
        List<Thread> listATMs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listATMs.add(new Thread(new AutoTellerMachine(i, new Random().nextInt(20))));
        }
        listATMs.forEach(Thread::start);
    }

    public static void main(String[] args) {
        ATMService service = new ATMService();
        service.start(8);
    }
}