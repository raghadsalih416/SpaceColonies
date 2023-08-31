//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * This class creates new planet objects
 * 
 * @author raghadsalih
 * @version 2022.31.10
 */
public class Planet implements Comparable<Planet> {
    // ~ Fields .......................................
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;

    /**
     * creates a new planet object
     * 
     * @param planetName
     *            the name of planet
     * @param planetAgri
     *            minimum skill level for agriculture
     * @param planetMedi
     *            minimum skill level for medicine
     * @param planetTech
     *            minimum skill level for technology
     * @param planetCap
     *            maximum capacity of planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        populationSize = 0;
        capacity = planetCap;
        population = new Person[capacity];
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
    }


    /**
     * sets the name
     * 
     * @param newName
     *            new name of person
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * gets the name
     * 
     * @return name of person
     */
    public String getName() {
        return name;
    }


    /**
     * gets the skills of planet
     * 
     * @return skillset of planet
     */
    public Skillset getSkills() {
        return minSkills;
    }


    /**
     * gets the population of planet
     * 
     * @return population of planet
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * gets the population size
     * 
     * @return the size of population
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * gets the capacity
     * 
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Gets the number of available places
     * left in the planet
     * 
     * @return the num of available places
     */
    public int getAvailability() {
        return (capacity - populationSize);
    }


    /**
     * checks to see if full
     * 
     * @return true if full, false if not
     */
    public boolean isFull() {
        return (populationSize == capacity);
    }


    /**
     * trys to add a person to array
     *
     * @return true if person added succesfully, false otherwise
     * @param newPerson
     *            person being attempted to add
     */
    public boolean addPerson(Person newPerson) {
        if (!isFull() && isQualified(newPerson)) {
            population[populationSize] = newPerson;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * tests to see if person is qualified
     *
     * @return true if person is qualified, false otherwise
     * @param newPerson
     *            person being attempted to add
     */
    public boolean isQualified(Person newPerson) {
        return (this.getSkills().isLessThanOrEqualTo(newPerson.getSkills()));
    }


    /**
     * returns a string of all information
     * 
     * @return string of input fields and popSize
     */
    public String toString() {
        // do i need to use a string builder
        return name + ", population " + populationSize + " (cap: " + capacity
            + "), Requires: A >= " + this.getSkills().getAgriculture()
            + ", M >= " + this.getSkills().getMedicine() + ", T >= " + this
                .getSkills().getTechnology();
    }


    /**
     * compares the current planet and the parameter planet
     * 
     * @param otherPlanet
     *            other planet being compared
     * @return -1 if the sum of current < param sum, 1 if other way, 0 if =
     */
    @Override
    public int compareTo(Planet otherPlanet) {
        if (this.getCapacity() > otherPlanet.getCapacity()) {
            return 1;
        }
        else if (this.getCapacity() == otherPlanet.getCapacity()) {
            if (this.getAvailability() > otherPlanet.getAvailability()) {
                return 1;
            }
            else if (this.getAvailability() == otherPlanet.getAvailability()) {
                if (this.getSkills().compareTo(otherPlanet.getSkills()) == 0) {
                    return this.getName().compareTo(otherPlanet.getName());
                }
                else {
                    return this.getSkills().compareTo(otherPlanet.getSkills());
                }

            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }


    /**
     * checks if 2 planets are equal
     * planets are equal when all 5 input fields
     * are equal & same population
     * 
     * @return true if they equal, false if not
     * @param otherPlanet
     *            other planet to be compared
     */
    public boolean equals(Object otherPlanet) {
        if (this == otherPlanet) {
            return true;
        }
        if (otherPlanet == null) {
            return false;
        }
        if (this.getClass().equals(otherPlanet.getClass()) && this.getName()
            .equals(((Planet)otherPlanet).getName()) && this
                .getCapacity() == ((Planet)otherPlanet).getCapacity() && this
                    .getSkills().getAgriculture() == ((Planet)otherPlanet)
                        .getSkills().getAgriculture() && this.getSkills()
                            .getMedicine() == ((Planet)otherPlanet).getSkills()
                                .getMedicine() && this.getSkills()
                                    .getTechnology() == ((Planet)otherPlanet)
                                        .getSkills().getTechnology() && this
                                            .getPopulationSize() ==
                                            ((Planet)otherPlanet)
                                                .getPopulationSize()) {
            Person[] planetA = this.getPopulation();
            Person[] planetB = ((Planet)otherPlanet).getPopulation();

            for (int i = 0; i < populationSize; i++) {
                if (!planetA[i].equals(planetB[i])) {
                    return false;
                }
            }
            return true;

        }

        return false;

    }
}
