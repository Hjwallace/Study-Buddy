package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionTest {
    @Test
    public void TestConnection() {
        Connection connection = new Connection();
        boolean connectionStatus = connection.findConnection();
        Assert.assertEquals(connectionStatus, true);

    }
}
