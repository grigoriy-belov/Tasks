import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BackwardLinkedListTest {
    BackwardLinkedList<String> strings;
    BackwardLinkedList<String> emptyList;

    @BeforeEach
    void setUp() {
        emptyList = new BackwardLinkedList<>();
        strings = new BackwardLinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
    }

    @Test
    void addedValueShouldBeLast() {
        strings.add("five");
        assertEquals("five", strings.get(strings.size() - 1));
    }

    @Test
    void valueShouldBeInsertedInItsIndex() {
        strings.add(0, "zero");
        strings.add(1, "one and half");
        strings.add(strings.size() - 1, "last");
        assertEquals("zero", strings.get(0));
        assertEquals("one and half", strings.get(1));
        assertEquals("zero", strings.get(0));
    }

    @Test
    void shouldReturnRemovedValueAndDoCorrectShift() {
        assertEquals("one", strings.remove(0));
        assertEquals("two", strings.get(0));
        assertEquals("three", strings.remove(1));
        assertEquals("four", strings.get(1));
        assertEquals("four", strings.remove(strings.size() - 1));
    }

    @Test
    void contains() {
        assertTrue(strings.contains("one"));
        assertTrue(strings.contains("two"));
        assertTrue(strings.contains("three"));
        assertTrue(strings.contains("four"));
    }

    @Test
    void get() {
        assertEquals("one", strings.get(0));
        assertEquals("three", strings.get(2));
        assertEquals("four", strings.get(strings.size() - 1));
    }

    @Test
    void isEmpty() {
        assertFalse(strings.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void shouldClearList() {
        strings.clear();
        assertEquals(emptyList, strings);
    }

    @Test
    void size() {
        assertEquals(4, strings.size());
        strings.add("five");
        assertEquals(5, strings.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    void testEquals() {
        BackwardLinkedList<String> compared = new BackwardLinkedList<>();
        compared.add("one");
        compared.add("two");
        compared.add("three");
        compared.add("four");

        assertTrue(strings.equals(compared));
        strings.add(2, "one and half");
        assertNotEquals(strings, compared);
    }

    @Test
    void testHashCode() {
        BackwardLinkedList<String> compared = new BackwardLinkedList<>();
        compared.add("one");
        compared.add("two");
        compared.add("three");
        compared.add("four");
        assertEquals(strings.hashCode(), compared.hashCode());
        strings.add(2, "one and half");
        assertNotEquals(strings.hashCode(), compared.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("[one, two, three, four]", strings.toString());
    }

}