import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyValidatorTest {

    @Test
    public void shouldCheckIfNull() {
        //given
        String s = null;

        //when
        boolean result = EmptyValidator.valid(s);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfEmpty() {
        //given
        String s = "";

        //when
        boolean result = EmptyValidator.valid(s);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfContainsSpace() {
        //given
        String s = " ";

        //when
        boolean result = EmptyValidator.valid(s);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldCheckIfContainsText() {
        //given
        String s = "abc";

        //when
        boolean result = EmptyValidator.valid(s);

        //then
        Assert.assertTrue(result);
    }


}