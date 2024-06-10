package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParamBurgerTest {

    private Burger burger;
    private float expectedPrice;

    public ParamBurgerTest(Burger burger, float expectedPrice) {
        this.burger = burger;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Burger burgerBlackBun = new Burger();

        Bun blackBun = new Bun("black bun", 100);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

        burgerBlackBun.bun = blackBun;
        burgerBlackBun.ingredients = ingredients;

        Burger burgerWhiteBun =  new Burger();

        Bun whiteBun = new Bun("white bun", 200);

        List<Ingredient> wIngredients = new ArrayList<>();
        wIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        wIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

        burgerWhiteBun.bun = whiteBun;
        burgerWhiteBun.ingredients = wIngredients;

        return Arrays.asList(new Object[][]{
                {
                    burgerBlackBun, 500
                },
                {
                    burgerWhiteBun, 700
                }
        });
    }
    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
}