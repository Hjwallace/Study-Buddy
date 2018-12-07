package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionTest {
    @Test
    public void TestConnection() {
        Connection connection = new Connection();
        boolean connectionStatus = connection.findConnection();
        Assert.assertTrue(connectionStatus);

    }

    @Test
    public void findConnection() {
        Connection connection = new Connection();
        boolean connectionStatus = connection.findConnection();
        Assert.assertTrue(connectionStatus);
    }
}
