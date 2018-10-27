package com.epam.lesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Test for {@link Client}
 */
public class ClientTest {
    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Client.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void withdrawMoneyTest() {
        Client client = Client.getInstance();
        Assert.assertTrue(client.withdrawMoney(BigDecimal.valueOf(150)));
        Assert.assertEquals(BigDecimal.valueOf(850), client.getWallet());
        Assert.assertFalse(client.withdrawMoney(BigDecimal.valueOf(1500)));
    }

    @Test
    public void depositMoneyTest() {
        Client client = Client.getInstance();
        Assert.assertEquals(BigDecimal.valueOf(1500L), client.depositMoney(BigDecimal.valueOf(500)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionOfCash() {
        Client.getInstance().depositMoney(BigDecimal.valueOf(-150L));
    }
}
