package com.epam.lesson5;

import java.math.BigDecimal;

/**
 * Singleton client with base client cash functional
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class Client {

    private volatile BigDecimal wallet;
    private static volatile Client instance;

    public BigDecimal getWallet() {
        return wallet;
    }

    /**
     * Double checked locking with volatile
     *
     * @return singleton instance
     */
    public static Client getInstance() {
        Client localInstance = instance;
        if (localInstance == null) {
            synchronized (Client.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Client();
                }
            }
        }
        return localInstance;
    }

    /**
     * Create Client with 1000 money
     */
    private Client() {
        this.wallet = BigDecimal.valueOf(1000L);
    }

    /**
     * Checker for withdraw of money
     *
     * @param money
     * @return result of withdrawing
     */
    public synchronized boolean withdrawMoney(BigDecimal money) {
        checkMoney(money);
        if (wallet.compareTo(money) >= 0) {
            wallet = wallet.subtract(money);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Synchronized money deposit
     *
     * @param money
     * @return wallet after deposit
     */
    public synchronized BigDecimal depositMoney(BigDecimal money) {
        checkMoney(money);
        wallet = wallet.add(money);
        return wallet;
    }

    /**
     * Control base rule of money (money can't be negative)
     *
     * @param money of client
     */
    private void checkMoney(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Money should be more than 0");
        }
    }
}