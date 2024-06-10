package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(100.0F);
        ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(1f);
        ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(0.3f);
    }
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

  /*  @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format("(==== %s ====)%n= Cheese =%n= Lettuce =%n(==== %s ====)%n%nPrice: %f%n",
                "Sesame", "Sesame", burger.getPrice());
        assertEquals(expectedReceipt, burger.getReceipt());
    }*/
}