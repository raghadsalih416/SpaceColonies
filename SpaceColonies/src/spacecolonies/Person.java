//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * this class creates people objects that store names,
 * skills, and planet preference
 * 
 * @author raghadsalih
 * @version 2022.23.10
 *
 */
public class Person {
    // ~ Fields .......................................
    private String name;
    private Skillset skills;
    private String planetPreference;

    /**
     * creates a new person object
     * 
     * @param name
     *            the name of the person whos applying
     * @param agri
     *            their agriculture points
     * @param medi
     *            their medicine points
     * @param tech
     *            their technology points
     * @param planet
     *            their planet preference
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skillset(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * Gets the name
     * 
     * @return the name of current person
     */
    public String getName() {
        return name;
    }


    /**
     * gets the current skillset
     * 
     * @return the skillset
     */
    public Skillset getSkills() {
        return skills;
    }


    /**
     * gets the planet preference
     * 
     * @return the planet preference
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * checks to see if current object and
     * param are equal
     * 
     * @param other
     *            the other object to be compared
     * 
     * @return true if equal, false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return (this.getClass().equals(other.getClass()) && (this.getName()
            .equals(((Person)other).getName()) && skills.equals(((Person)other)
                .getSkills()) && planetPreference.equals(((Person)other)
                    .getPlanetPreference())));
    }


    /**
     * makes the name, skills, and planet preference a string
     * 
     * @return all info in the form of a string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (planetPreference.length() > 0) {
            builder.append(name + " ");
            builder.append(this.getSkills().toString() + " ");
            builder.append("Wants: " + this.getPlanetPreference());
        }
        else

        {
            builder.append("No-Planet ");
            builder.append(name + " ");
            builder.append(this.getSkills().toString());
        }
        return builder.toString();
    }

}
