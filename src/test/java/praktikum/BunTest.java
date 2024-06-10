package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    String name = "somename";
    float price = 1000;
    Bun instance = new Bun(name, price);
    @Test
    public void getName() {
        assertEquals(name, instance.getName());
    }
    @Test
    public void getPrice() {
        assertEquals(price, instance.getPrice(), 0);
    }
}