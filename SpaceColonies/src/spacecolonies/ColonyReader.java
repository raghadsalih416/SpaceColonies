//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * This class will read the input and begin
 * the space window
 * 
 * @author raghadsalih
 * @version 2022.02.11
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * creates a new ColonyReader object
     * 
     * @throws FileNotFoundException
     *             when file is not found
     * @throws SpaceColonyDataException
     *             when less than 3 planets
     * @throws ParseException
     *             when wrong amount of information
     * @param applicantFileName
     *            name of applicant on file
     * @param planetFileName
     *            name of planet on file
     * 
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        // did i do this right
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        // System.out.println(queue.toString());
        ColonyCalculator calc = new ColonyCalculator(queue, planets);
        SpaceWindow window = new SpaceWindow(calc);
    }


    /**
     * evaluates whether or not all params are
     * between min and max
     * 
     * @return true if they are in range of skills
     * @param num1
     *            skill number 1
     * @param num2
     *            skill number 2
     * @param num
     *            3
     *            skill number 3
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return ((num1 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num1 >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (num2 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num2 >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (num3 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num3 >= ColonyCalculator.MIN_SKILL_LEVEL));
    }


    /**
     * read the file and create an array of planets
     * 
     * @throws FileNotFoundException
     *             when file is not found
     * @throws SpaceColonyDataException
     *             when less than 3 planets
     * @throws ParseException
     *             when wrong amount of information
     * @return an array of planets
     * @param fileName
     *            the file that will be read
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        Planet[] localPlanets = new Planet[ColonyCalculator.NUM_PLANETS];
        Scanner file = new Scanner(new File(fileName));
        int count = 0;
        if (fileName.length() > 0) {
            while (file.hasNextLine() && count < ColonyCalculator.NUM_PLANETS) {
                String eachLine = file.nextLine();
                String[] planetArray = eachLine.split(",\\s*");
                // deos this work for between 1 and 5
                if (!isInSkillRange(Integer.parseInt(planetArray[1]), Integer
                    .parseInt(planetArray[2]), Integer.parseInt(
                        planetArray[3]))) {
                    throw new SpaceColonyDataException(
                        "Skills are not in range");
                }
                // make new planet
                if (planetArray.length < 4) {
                    throw new ParseException(
                        "less than 5 comma seperated values", 0);
                }
                localPlanets[count] = new Planet(planetArray[0], Integer
                    .parseInt(planetArray[1]), Integer.parseInt(planetArray[2]),
                    Integer.parseInt(planetArray[3]), Integer.parseInt(
                        planetArray[4]));
                count++;
            }
            // if less than 3 planets
            if (count < 3) {
                throw new SpaceColonyDataException("Less than 3 planets");
            }
        }
        file.close();
        return localPlanets;
    }


    /**
     * read the file and create an array of people
     * 
     * @throws FileNotFoundException
     *             when file is not found
     * @throws SpaceColonyDataException
     *             when less than 3 planets
     * @throws ParseException
     *             when wrong amount of information
     * @return an arrayQueue of people
     * @param fileName
     *            the file that will be read
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        ArrayQueue<Person> localArray = new ArrayQueue<Person>(
            ArrayQueue.DEFAULT_CAPACITY);
        Scanner file = new Scanner(new File(fileName));
        Person newPerson;
        int count = 0;
        if (fileName.length() > 0) {
            while (file.hasNextLine() && count < 20) {
                String eachLine = file.nextLine();
                // change array
                String[] planetArray = eachLine.split(",\\s*");
                // do i have to instead of using isinskill range do 5

                if (!isInSkillRange(Integer.parseInt(planetArray[1]), Integer
                    .parseInt(planetArray[2]), Integer.parseInt(
                        planetArray[3]))) {
                    throw new SpaceColonyDataException(
                        "Skills are not in range");
                }
                if (planetArray.length != 4 && planetArray.length != 5) {
                    throw new ParseException("wrong num of value", 0);
                }
                // System.out.println(planetArray.length);
                if (planetArray.length == 5) {
                    if (planetArray[4].equals("no preference")) {
                        planetArray[4] = "";

                    }
                    newPerson = new Person(planetArray[0], Integer.parseInt(
                        planetArray[1]), Integer.parseInt(planetArray[2]),
                        Integer.parseInt(planetArray[3]), planetArray[4]);

                }
                else {
                    newPerson = new Person(planetArray[0], Integer.parseInt(
                        planetArray[1]), Integer.parseInt(planetArray[2]),
                        Integer.parseInt(planetArray[3]), "");

                }

                localArray.enqueue(newPerson);
                count++;
            }
        }
        return localArray;
    }

}
