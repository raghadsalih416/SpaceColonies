//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * this class tests methods in planet class
 * 
 * @author raghadsalih
 * @version 2022.31.10
 *
 */
public class PlanetTest extends student.TestCase {
    // ~ Fields .......................................
    private Planet planet;
    private Planet planet1;
    private Planet planetDiffNam;
    private Planet planetDiffCap;
    private Planet planetDiffAgr;
    private Planet planetDiffMed;
    private Planet planetDiffTec;
    private Person person;
    private Person person2;
    private Planet planetComp;
    private Person person3;

    /**
     * creates new planet object
     */
    public PlanetTest() {
        planet = new Planet("hokie", 2, 4, 5, 10); // sum = 11 this
        planet1 = new Planet("hokie", 2, 4, 5, 10);
        planetDiffNam = new Planet("honey", 2, 4, 5, 10);
        planetDiffCap = new Planet("hokie", 2, 4, 5, 7);
        planetDiffAgr = new Planet("hokie", 4, 4, 5, 10); // sum = 13
        planetDiffMed = new Planet("hokie", 2, 6, 5, 10);
        planetDiffTec = new Planet("hokie", 2, 4, 2, 10);
        planetComp = new Planet("ally", 2, 4, 5, 10);
        person = new Person("john", 3, 5, 6, "");
        person2 = new Person("jim", 2, 3, 2, "");
        person3 = new Person("jimmy", 5, 5, 6, "");
    }


    /**
     * tests the getName, getPopulationSize
     * getCapacity, and getAvailability
     * methods
     */
    public void testSetName() {
        planet.setName("hope");
        assertEquals("hope", planet.getName());
        assertEquals(0, planet.getPopulationSize());
        assertEquals(10, planet.getCapacity());
        assertEquals(10, planet.getAvailability());
    }


    /**
     * tests the isFull method
     */
    public void testIsFull() {
        assertFalse(planet.isFull());

    }

//
// /**
// * tests the getPopulation method
// */
// public void testGetPopulation() {
// assertTrue(planet.addPerson(person));
// assertTrue(planet.addPerson(person));
// Person[] newArr = new Person[2];
// newArr[0] = new Person("john", 1, 3, 4, "");
// newArr[1] = new Person("john", 1, 3, 4, "");
// System.out.println(planet.getPopulation());
// assertTrue(Arrays.equals(newArr, planet.getPopulation()));
//
// }


    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals(
            "hokie, population 0 (cap: 10), Requires: A >= 2, M >= 4, T >= 5",
            planet.toString());

    }


    /**
     * tests the isQualified method
     */
    public void testIsQualified() {
        Person personA = new Person("john", 3, 5, 7, "");
        Person personB = new Person("john", 0, 2, 3, "");
        assertTrue(planet.isQualified(personA));
        assertFalse(planet.isQualified(personB));

    }


    /**
     * tests the addPerson method
     */
    public void testAddPerson() {
        assertFalse(planet.addPerson(person2));
        assertEquals(0, planet.getPopulationSize());
        assertTrue(planet.addPerson(person));
        assertEquals(1, planet.getPopulationSize());

        for (int i = 0; i < 9; i++) {
            planet.addPerson(person);
        }
        // System.out.println(planet.getAvailability());
        assertFalse(planet.addPerson(person));
        assertEquals(10, planet.getPopulationSize());

    }


    /**
     * tests the compareTo method
     */
    public void testCompareTo() {
        // cap > otheCap
        assertEquals(1, planet.compareTo(planetDiffCap));
        // cap < otherCap
        assertEquals(-1, planetDiffCap.compareTo(planet));
        // cap == otherCap

        // avail > otherAvail
        planet.addPerson(person);
        assertEquals(9, planet.getAvailability());
        assertEquals(1, planetDiffAgr.compareTo(planet));
        assertEquals(-1, planet.compareTo(planetDiffAgr));

        // avail == otherAvail

        planetDiffAgr.addPerson(person3);
        assertEquals(9, planetDiffAgr.getAvailability());
        assertEquals(-1, planet.compareTo(planetDiffAgr));

        // skills == skills
        planetComp.addPerson(person);
        assertEquals(7, planet.compareTo(planetComp));

    }


    /**
     * tests the equals method
     */
    public void testEquals() {
        assertTrue(planet.equals(planet));
        assertFalse(planet.equals(null));
        assertTrue(planet.equals(planet1));
        assertFalse(planet.equals(new Object()));
        assertFalse(planet.equals(planetDiffNam));
        assertFalse(planet.equals(planetDiffCap));
        assertFalse(planet.equals(planetDiffAgr));
        assertFalse(planet.equals(planetDiffMed));
        assertFalse(planet.equals(planetDiffTec));
        assertEquals(0, planet.getPopulationSize());
        assertEquals(0, planet1.getPopulationSize());
        planet1.addPerson(person); 
        assertFalse(planet1.equals(planet));
    }


    /**
     * tests the equals method
     */
    public void testEquals2() {
        planet.addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planet.addPerson(new Person("john", 7, 7, 7, "hope"));

        planet1.addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planet1.addPerson(new Person("john", 7, 7, 7, "hope"));

        assertTrue(planet1.equals(planet));
    }


    /**
     * tests the equals method
     */
    public void testEquals3() {
        planet.addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planet.addPerson(new Person("emily", 7, 7, 7, "hope"));

        planet1.addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planet1.addPerson(new Person("john", 7, 7, 7, "hope"));

        assertFalse(planet1.equals(planet));
    }

}
