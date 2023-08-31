//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * this class does all of the major calculations
 * handles the accept/reject logic
 * 
 * @author raghadsalih
 * @version 2022.02.11
 */
public class ColonyCalculator {
    /**
     * Default number of planets
     */
    public final static int NUM_PLANETS = 3;
    /**
     * minimum num of skill
     */
    public final static int MIN_SKILL_LEVEL = 1;
    /**
     * maximum skill level
     */
    public final static int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;

    /**
     * this method creates a colony calculator object
     * 
     * @throws IllegalArgumentException
     *             when arrayQueue is null
     * @param people
     *            an arrayQueue of person objects
     * @param planets
     *            array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> people, Planet[] planets)
        throws IllegalArgumentException {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        applicantQueue = people;
        this.planets = planets;
        rejectBus = new AList<Person>();
    }


    /**
     * determine if the next applicant can be accepted to
     * a planet
     * 
     * @return planet that the person will be added to
     * @param nextPerson
     *            the person whos planet is being searched for
     */
    public Planet getPlanetForPerson(Person nextPerson) {

        if (nextPerson == null) {
            return null;
        }
        String pref = nextPerson.getPlanetPreference();
        if (!pref.equals("")) {
            int index = getPlanetIndex(pref);
            // if (index != -1) {
            if ((index != -1) && !planets[index].isFull() && planets[index]
                .isQualified(nextPerson)) {
                return planets[index];
                // }

            }

            return null;

        }
        return bestPlanet(nextPerson);

    }


    /**
     * helper method that finds which planet
     * can be used if no preference
     * 
     * @return planet thats best to be used
     * @param nextPerson
     *            the person whos planet is being searched for
     */
    private Planet bestPlanet(Person nextPerson) {
        // make copy of array
        Planet[] newArr = Arrays.copyOf(planets, NUM_PLANETS);
        // sort planets based on their capacity, least = first
        Arrays.sort(newArr);
        // start at newArr.length -1
        for (int i = newArr.length - 1; i >= 0; i--) {
            if ((!newArr[i].isFull()) && newArr[i].isQualified(nextPerson)) {
                return newArr[i];
            }
        }
        return null;
    }


    /**
     * attempt to accept next applicant
     * 
     * @return true if moved, false otherwise
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        if (getPlanetForPerson(applicantQueue.getFront()) != null) {

            getPlanetForPerson(applicantQueue.getFront()).addPerson(
                applicantQueue.getFront());
            applicantQueue.dequeue();

            return true;
        }
        return false;
    }


    /**
     * next moves after applicant is rejected
     */
    public void reject() {
        Person reject = applicantQueue.dequeue();
        rejectBus.add(reject);
    }


    /**
     * gets index of planet in array
     * 
     * @return the index of planet, -1 if not in array
     * @param planet
     *            planet whose index is being looked for
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * gets the queue
     * 
     * @return the applicant queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * gets the planets array
     * 
     * @return array of planets
     */
    public Planet[] getPlanets() {
        return planets;
    }

}
