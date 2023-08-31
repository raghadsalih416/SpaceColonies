//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * this class tests the methods in the
 * Person class
 * 
 * @author raghadsalih
 * @version 2022.25.10
 *
 */
public class PersonTest extends student.TestCase {
    // ~ Fields .......................................
    private Person person;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6; 

    /**
     * creates a new person object
     * 
     */
    public PersonTest() {
        person = new Person("henry", 2, 3, 5, "Hokies");
        person2 = new Person("hope", 1, 3, 5, "poppy");
        person3 = new Person("henry", 2, 3, 5, "Hokies");
        person4 = new Person("harry", 3, 4, 5, "");
        person5 = new Person("henry", 2, 3, 5, "");
        person6 = new Person("henry", 2, 4, 5, "hokies");
    }


    /**
     * tests all of the get methods including
     * getName, getPlanetPreference, getSkills
     * 
     */
    public void testGetMethods() {
        assertEquals("henry", person.getName());
        assertEquals("Hokies", person.getPlanetPreference());
        assertEquals("A:2 M:3 T:5", person.getSkills().toString());

    }


    /**
     * tests the equal method
     * 
     */
    public void testEquals() {
        Object obj = new Object();
        assertTrue(person.equals(person));
        assertFalse(person.equals(obj));
        assertFalse(person.equals(null));
        assertFalse(person.equals(person2));
        assertTrue(person.equals(person3));
        assertFalse(person.equals(person5));
        assertFalse(person.equals(person6));
    }


    /**
     * tests the to string method
     * 
     */
    public void testToString() {
        assertEquals("henry A:2 M:3 T:5 Wants: Hokies", person.toString());
        assertEquals("No-Planet harry A:3 M:4 T:5", person4.toString());
    }
}
