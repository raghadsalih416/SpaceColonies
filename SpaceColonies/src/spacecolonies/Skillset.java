//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * This class handles all of the points
 * from applicant
 * 
 * @author raghadsalih
 * @version 2022.26.10
 *
 */
public class Skillset {
    // ~ Fields ......................................
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * creates a new skillset object
     * 
     * @param agriculture
     *            agriculture points
     * @param medicine
     *            medicine points
     * @param technology
     *            technology points
     * 
     */
    public Skillset(int agriculture, int medicine, int technology) {
        this.agriculture = agriculture;
        this.medicine = medicine;
        this.technology = technology;
    }


    /**
     * looks to see if the current skills are less than or
     * equal to another skillset
     * checks to see if a persons skillset is accepted
     * 
     * @param skills
     *            other skills being compared
     * @return true if all skills are less than or equal to other skills
     */
    public boolean isLessThanOrEqualTo(Skillset skills) {
        return ((this.agriculture <= skills.agriculture)
            && (this.medicine <= skills.medicine)
            && (this.technology <= skills.technology));
    }


    /**
     * looks to see if 2 objects are equal based on their
     * fields
     * 
     * @param other
     *            other object being compared
     * @return true if they are identical, false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return (this.getClass().equals(other.getClass()) && (this
            .getAgriculture() == ((Skillset)other).getAgriculture() && this
                .getMedicine() == ((Skillset)other).getMedicine() && this
                    .getTechnology() == ((Skillset)other).getTechnology()));
    }


    /**
     * compares the sum of the current object and the sum
     * of the parameter object
     * 
     * @param skills
     *            other skillset being compared
     * @return -1 if the sum of current < param sum, 1 if other way, 0 if =
     */
    public int compareTo(Skillset skills) {
        int sumThis = this.agriculture + this.medicine + this.technology;
        int sumParam = skills.agriculture + skills.medicine + skills.technology;
        if (sumThis < sumParam) {
            return -1;
        }
        else if (sumThis == sumParam) {
            return 0;
        }
        else {
            return 1;
        }
    }


    /**
     * gets the agriculture
     * 
     * @return the agriculture points
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * gets the medicine field
     * 
     * @return the medicine points
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * gets the technology field
     * 
     * @return gets the technology fields
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * creates a string of all skills
     * in the skill set
     * 
     * @return a string of all skills
     */
    public String toString() {
        return "A:" + this.agriculture + " M:" + this.medicine + " T:"
            + this.technology;
    }

}
