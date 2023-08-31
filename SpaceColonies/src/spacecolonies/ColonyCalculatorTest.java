//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * this class tests the methods in the
 * ColonyCalculator class
 * 
 * @author raghadsalih
 * @version 2022.07.11
 */
public class ColonyCalculatorTest extends student.TestCase {
    private Planet[] planets;
    private ArrayQueue<Person> queue;
    private ArrayQueue<Person> queueEmpty;
    private ColonyCalculator calc;

    /**
     * declares new objects
     */
    public ColonyCalculatorTest() {
        queue = new ArrayQueue<Person>();
        queueEmpty = null;
        queue.enqueue(new Person("emily", 7, 7, 7, "hokies"));
        queue.enqueue(new Person("ross", 4, 5, 5, "hokies"));
        planets = new Planet[3];
        planets[0] = new Planet("hokies", 6, 5, 6, 5);
        planets[1] = new Planet("hope", 6, 5, 6, 7);
        planets[2] = new Planet("libero", 6, 5, 6, 3);
        calc = new ColonyCalculator(queue, planets);
    }


    /**
     * tests the constructor when queue is null
     */
    public void testPeopleEmpty() {
        Exception exception = null;
        try {
            ColonyCalculator calc2 = new ColonyCalculator(queueEmpty, planets);
            fail("constructor is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("constructor is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * tests the getQueue method
     */
    public void testGetQueue() {
        // assertEquals("hokies, hope, libero", calc.getPlanets());
        assertEquals(
            "[emily A:7 M:7 T:7 Wants: hokies, ross A:4 M:5 T:5 Wants: hokies]",
            calc.getQueue().toString());
    }


    /**
     * tests the getPlanets method
     */
    public void testGetPlanets() {
        Planet[] planets2 = new Planet[3];
        planets2[0] = new Planet("harry", 6, 5, 6, 4);
        planets2[1] = new Planet("louie", 6, 5, 6, 4);
        planets2[2] = new Planet("zayn", 6, 5, 6, 4);
        assertFalse(planets2.equals(calc.getPlanets()));
    }


    /**
     * tests the getPlanetIndex method
     */
    public void testGetPlanetIndex() {
        assertEquals(1, calc.getPlanetIndex("hope"));
        assertEquals(-1, calc.getPlanetIndex("spongebob"));
    }


    /**
     * tests the accept method
     */
    public void testAccept() {
        assertTrue(calc.accept());
        ArrayQueue<Person> queue2 = new ArrayQueue<Person>();
        ColonyCalculator empty = new ColonyCalculator(queue2, planets);
        assertFalse(empty.accept());
        queue2.enqueue(null);
        assertFalse(empty.accept());
    }


    // applicant with no planet preference who was qualified
    /**
     * tests the accept2 method
     */
    public void testAccept2() {
        assertTrue(calc.accept());
        ArrayQueue<Person> queue2 = new ArrayQueue<Person>();
        ColonyCalculator empty = new ColonyCalculator(queue2, planets);
        assertFalse(empty.accept());
        queue2.enqueue(null);
        assertFalse(empty.accept());
    }


    /**
     * tests the bestPlanet and getPlanetForPerson
     * method
     */
    public void testGetPlanetForPerson() {
        Person emily = new Person("emily", 7, 7, 7, "hokies");
        Person noPref = new Person("john", 7, 7, 7, "");
        Person nullPerson = null;
        assertNull(calc.getPlanetForPerson(nullPerson));
        assertEquals(
            "hokies, population 0 (cap: 5), Requires: A >= 6, M >= 5, T >= 6",
            calc.getPlanetForPerson(emily).toString());
        assertEquals(
            "hope, population 0 (cap: 7), Requires: A >= 6, M >= 5, T >= 6",
            calc.getPlanetForPerson(noPref).toString());
        // System.out.println(calc.getPlanetForPerson(noPref).toString());
    }


    /**
     * tests the bestPlanet and getPlanetForPerson
     * method
     */
    public void testGetPlanetForPerson5() {
        Person emily = new Person("emily", 7, 7, 7, "harry");
        assertEquals(-1, calc.getPlanetIndex("harry"));
        assertNull(calc.getPlanetForPerson(emily));

    }


    /**
     * tests the bestPlanet and getPlanetForPerson
     * method when planet IS full and not qualified
     */
    public void testGetPlanetForPerson2() {
        Person emily = new Person("emily", 6, 2, 5, "hokies");
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        // System.out.println(calc.getPlanetForPerson(emily).getAvailability());
        assertTrue(planets[0].isFull());
        Person jacob = new Person("jacob", 0, 2, 3, "hokies");
        assertFalse(planets[0].isQualified(jacob));
        assertNull(calc.getPlanetForPerson(emily));
    }


    /**
     * tests the bestPlanet and getPlanetForPerson
     * method when planet IS full and not qualified
     */
    public void testGetPlanetForPerson4() {
        Person emily = new Person("emily", 1, 1, 1, "hokies");
        Person john = new Person("john", 6, 5, 1, "hokies");
        Person steve = new Person("steve", 2, 3, 4, "");
        // assertFalse(planets[0].isQualified(jacob));
        assertNull(calc.getPlanetForPerson(emily));
        assertNull(calc.getPlanetForPerson(john));
        assertNull(calc.getPlanetForPerson(steve));
    }


    /**
     * tests the bestPlanet and getPlanetForPerson
     * method when thers no pref
     * all planets are full and not qualified
     */
    public void testGetPlanetForPerson3() {
        Person emily = new Person("emily", 3, 2, 5, "hokies");
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[0].isFull());

        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[1].isFull());

        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[2].isFull());

        Person jacob = new Person("emily", 1, 1, 1, "");
        assertFalse(planets[0].isQualified(jacob));
        assertFalse(planets[1].isQualified(jacob));
        assertFalse(planets[2].isQualified(jacob));

        assertNull(calc.getPlanetForPerson(jacob));

        // Person jacob = new Person("emily", 10, 10, 15, "hokies");
        // assertFalse(planets[0].isQualified(jacob));
        // assertNull(calc.getPlanetForPerson(emily));
    }


    /**
     * tests the getPlanetForPerson edge case
     */
    public void testGetPlanetForPersonEdge() {
        queue.enqueue(new Person("emily", 7, 7, 7, "hokies"));
        queue.enqueue(new Person("emily", 7, 7, 7, "hokies"));
        queue.enqueue(new Person("emily", 7, 7, 7, "hokies"));
        // queue.enqueue(new Person("emily", 3, 2, 5, "hokies"));
        // queue.enqueue(new Person("emily", 3, 2, 5, "hokies"));
        Person emily = new Person("emily", 1, 1, 1, "hokies");
        assertNull(calc.getPlanetForPerson(emily));
    }


    /**
     * tests the reject method
     */
    public void testReject() {
        calc.reject();
        assertEquals("[ross A:4 M:5 T:5 Wants: hokies]", calc.getQueue()
            .toString());
    }


    /**
     * tests the bestPlanet edge case
     */
    public void testBestPlanetEdge() {
        // no pref, all planets are full but qualified
        Person jacob = new Person("jacob", 7, 7, 7, "");
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[0].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[0].isFull());

        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[1].isFull());

        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[2].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[2].isFull());

        assertNull(calc.getPlanetForPerson(jacob));
    }


    /**
     * tests the bestPlanet method
     */
    public void testBestPlanetEdge2() {
        // no pref, no planets full but not qualified
        Person jacob = new Person("jacob", 1, 1, 1, "");
        assertNull(calc.getPlanetForPerson(jacob));
    }


    /**
     * tests the bestPlanet method
     */
    public void testBestPlanetEdge3() {
        // no pref, no planets full but not qualified
        Person jacob = new Person("jacob", 7, 7, 7, "");
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("john", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jake", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("jess", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        planets[1].addPerson(new Person("emily", 7, 7, 7, "hokies"));
        assertTrue(planets[1].isFull());
        System.out.println(calc.getPlanetForPerson(jacob));
        System.out.println(planets[0].toString());
        assertTrue(calc.getPlanetForPerson(jacob).toString().equals(planets[0]
            .toString()));
    }

}
