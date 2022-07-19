package test.modeltest;

import listthingsbot.listmodel.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for List.java
 *
 * @author Matteo Baldaccioni
 */
public class ListTest
{
    @Test
    public void testOK_addAndRemoveItem()
    {
        List list = new List("list1");
        list.addItem("item1");
        assertEquals("list1", list.getTitle());
        assertEquals(1, list.size());
        list.removeItem("item1");
        assertEquals(0, list.size());
        list.addItem("item2");
        list.addItem("item3");
        assertEquals(2, list.size());
        list.removeItem(2);
        assertEquals(1, list.size());
        list.addItem("item4");
        assertEquals("1. item2\n2. item4\n", list.toString());
    }

    @Test
    public void testOK_newListFromExistingOne()
    {
        List list1 = new List("list1");
        List list2 = new List("list2", list1);
        list2.addItem("item1");
        assertEquals(1, list2.size());
    }

    @Test
    public void testKO_itemIndexNotCorrect()
    {
        List list1 = new List("list1");
        list1.addItem("item1");
        list1.addItem("item2");
        assertThrows(IllegalArgumentException.class, () -> list1.removeItem(3));
        assertThrows(IllegalArgumentException.class, () -> list1.removeItem(0));
    }
}
