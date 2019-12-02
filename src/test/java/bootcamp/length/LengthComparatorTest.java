package bootcamp.length;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthComparatorTest {

    @Test
    public void should_equal(){
        assertEquals(-1, new LengthComparator<Integer>().compare(new Length<Integer>(1), new Length<Integer>(2)));
    }
}