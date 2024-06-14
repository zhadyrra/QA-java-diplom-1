package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    @Before
    public void setUp() {
        String name = "BunBun";
        burger = new Burger();
        bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(100.0F);
        ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(1f);
        when(ingredient1.getType()).thenReturn(FILLING);
        when(ingredient1.getName()).thenReturn("Beef");
        ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(0.3f);
        when(ingredient2.getType()).thenReturn(SAUCE);
        when(ingredient2.getName()).thenReturn("Ketchup");
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

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String actual = burger.getReceipt();
        System.out.println(actual);
        String expectedReceipt = String.format(
        "(==== BunBun ====)%n= filling Beef =%n= sauce Ketchup =%n(==== BunBun ====)%n%nPrice: 201,300003%n");
        assertEquals(expectedReceipt, burger.getReceipt());
    }

  }