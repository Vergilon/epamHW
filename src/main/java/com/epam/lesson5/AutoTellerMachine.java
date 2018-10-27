package com.epam.lesson5;

import java.math.BigDecimal;

/**
 * Class for ATM
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class AutoTellerMachine implements Runnable {

    private int operationsCount;
    private int id;

    public AutoTellerMachine(int id, int operationsCount) {
        this.id = id;
        this.operationsCount = operationsCount;
    }

    /**
     * Random generator money from range
     *
     * @param min lower threshold for money
     * @param max upper threshold for money
     * @return
     */
    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public void run() {
        Client paymentSystem = Client.getInstance();
        for (int i = 0; i < operationsCount; i++) {
            BigDecimal money = generateRandomBigDecimalFromRange(BigDecimal.ONE, BigDecimal.valueOf(250L));
            synchronized (Client.class) {
                if (paymentSystem.withdrawMoney(money)) {
                    System.out.println("Client has withdrawn " + money + " from ATM #" + id + ". Now the client has " + paymentSystem.getWallet() + " in the account.");
                } else {
                    BigDecimal deposited = paymentSystem.depositMoney(money);
                    System.out.println("Client has deposited " + money + " to ATM #" + id + ". Now the client has " + deposited + " in the account.");
                }
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ATM #" + id + " has been stopped. Number of operations: " + operationsCount);
    }
}
