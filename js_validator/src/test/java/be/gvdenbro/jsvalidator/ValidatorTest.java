package be.gvdenbro.jsvalidator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void test1() {
        assertTrue(Validator.valid("{ [ ] ( ) }"));
    }

    @Test
    public void test2() {
        assertFalse(Validator.valid("{ [ ( ] ) }"));
    }

    @Test
    public void test3() {
        assertFalse(Validator.valid("{ [ }"));
    }

    @Test
    public void test4() {
        assertFalse(Validator.valid("}"));
    }
}