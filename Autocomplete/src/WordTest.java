import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lior on 1/31/2018.
 */
public class WordTest{

    @Test
    public void testEquals() {
        Word w = new Word("abc");
        boolean result;

        result = w.equals(new Word("abc"));
        assertTrue(result);

        result = w.equals(new Word("abd"));
        assertFalse(result);

        result = w.equals(null);
        assertFalse(result);

        result = w.equals(new Integer(1));
        assertFalse(result);
    }
}
