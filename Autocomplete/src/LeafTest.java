import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lior on 1/31/2018.
 */
public class LeafTest {

    @Test
    public void testInsert() {

        Leaf l = new Leaf("a");
        String s = "ab";

        Word w = l.insert(s);

        assertTrue(l.getWords().contains(new Word("ab")));
        assertEquals(1, w.getCount());

        l.insert(s);
        assertEquals(2, w.getCount());

    }

    @Test
    public void testSearch() {
        Leaf l = new Leaf("a");
        l.insert("abc");
        l.insert("acd");
        Word[] result = l.search("ab");
        assertEquals("abc", result[0].getWord());
        assertEquals("", result[1].getWord());
        assertEquals("", result[2].getWord());


    }

}
