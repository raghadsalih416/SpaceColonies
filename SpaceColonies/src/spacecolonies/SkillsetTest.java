//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * this class tests the methods
 * in the skillset class
 * 
 * @author raghadsalih
 * @version 2022.25.10
 *
 */
public class SkillsetTest extends student.TestCase {
    // ~ Fields .......................................
    private Skillset skills;
    private Skillset skillsLess;
    private Skillset skillsMore;
    private Skillset skills2;
    private Skillset skills3;
    private Skillset skills4;
    private Skillset skills5;
    private Skillset skills6;
    private Skillset skills7;
    private Skillset skills8;
    private Skillset skills9;
    private Skillset skills10;
    // private Skillset skillsEqual;

    /**
     * creates new skillset objects
     */
    public void setUp() {
        skills = new Skillset(3, 4, 5);
        skillsLess = new Skillset(2, 3, 4);
        skillsMore = new Skillset(5, 4, 5);
        skills2 = new Skillset(5, 3, 5);
        skills3 = new Skillset(2, 3, 5);
        skills4 = new Skillset(4, 4, 5);
        skills5 = new Skillset(3, 4, 4);
        skills6 = new Skillset(3, 2, 5);
        skills7 = new Skillset(3, 2, 5);
        skills8 = new Skillset(5, 4, 4);
        skills9 = new Skillset(2, 4, 5);
        skills10 = new Skillset(10, 20, 30);
        

    }


    /**
     * tests the to string method
     */
    public void testToString() {
        assertEquals("A:3 M:4 T:5", skills.toString()); 
    }


    /**
     * tests the isLessThanOrEqualTo method
     */
    public void testIsLessThanOrEqualTo() {
        assertTrue(skillsLess.isLessThanOrEqualTo(skills));
        assertFalse(skillsMore.isLessThanOrEqualTo(skills));
        assertFalse(skillsMore.isLessThanOrEqualTo(skills2));
        assertFalse(skillsMore.isLessThanOrEqualTo(skills3));
        assertFalse(skills.isLessThanOrEqualTo(skills9));
        assertTrue(skills.isLessThanOrEqualTo(skillsMore));
        Skillset compareSkills = new Skillset(20, 30, 20);
        assertFalse(skills10.isLessThanOrEqualTo(compareSkills));

    }


    /**
     * tests all of the get methods
     */
    public void testGetMethods() {
        assertEquals(3, skills.getAgriculture());
        assertEquals(4, skills.getMedicine());
        assertEquals(5, skills.getTechnology());
    }


    /**
     * tests the equals method
     */
    public void testEquals() {
        assertTrue(skills.equals(skills));
        assertFalse(skills.equals(skillsLess));
        assertFalse(skills.equals(null));
        assertFalse(skills.equals(new Object()));
        assertFalse(skills.equals(skillsMore));
        assertFalse(skills.equals(skills2));
        assertFalse(skills.equals(skills3));
        assertFalse(skills.equals(skills4));
        assertFalse(skills.equals(skills5));
        assertFalse(skills.equals(skills6));
        assertFalse(skills.equals(skills7));
        assertFalse(skills.equals(skills8));
    }


    /**
     * tests the compare to method
     */
    public void testCompareTo() {
        assertEquals(0, skills.compareTo(skills));
        assertEquals(-1, skills.compareTo(skillsMore));
        assertEquals(1, skills.compareTo(skillsLess));
    }
}
