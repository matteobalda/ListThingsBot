package test.modeltest;

import listthingsbot.listmodel.List;
import listthingsbot.listmodel.User;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

/**
 * Test class for User.java
 *
 * @author Matteo Baldaccioni
 */
public class UserTest
{
    @Test
    public void testOK()
    {
        User user = new User("123");
        user.newList("list1");
        List list1 = user.getList("list1");
        user.newList("list2", list1);
        assertEquals("123", user.getId());
        assertEquals("list1\nlist2\n", user.getListsTitles());
        assertEquals(2, user.countLists());
        user.removeList("list2");
        assertEquals(1, user.countLists());
        assertEquals(list1, user.getList("list1"));
    }

    @Test
    public void testKO_listAlreadyExist() {
        User user = new User("123");
        user.newList("list1");
        assertThrows(IllegalArgumentException.class, () -> user.newList("list1"));
    }

    @Test
    public void testKO_listDoesntExist() {
        User user = new User("123");
        assertEquals(null, user.getList("list1"));
        user.newList("testList");
        assertThrows(IllegalArgumentException.class, () -> user.renameList("list1", "newList1"));
    }
}
