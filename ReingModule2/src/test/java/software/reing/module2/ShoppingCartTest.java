package software.reing.module2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ShoppingCartTest {

    @Test
    public void appendFormattedTest() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "12345678", 0, 14);
        assertEquals("   12345678    ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "12345678", 0, 15);
        assertEquals("   12345678     ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "12345678", 0, 5);
        assertEquals("12345 ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "12345678", 1, 15);
        assertEquals("       12345678 ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "12345678", -1, 15);
        assertEquals("12345678        ", sb.toString());
    }

    @Test
    public void calculateDiscountTest() {
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 1));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 9));
        assertEquals(1, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 10));
        assertEquals(10, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 100));
        assertEquals(10, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 101));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 801));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 901));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 20));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 10));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 1));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 500));
        assertEquals(53, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 30));
        assertEquals(51, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 10));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 9));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 2));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 1));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 500));
        assertEquals(73, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 30));
        assertEquals(71, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 10));
        assertEquals(70, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 9));
        assertEquals(70, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 1));
    }
}