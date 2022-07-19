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
    public void testOK()
    {
        List list = new List("list1");
        assertEquals("list1", list.getTitle());
        list.addItem("item1");
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
}
