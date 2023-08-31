//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * this class is the runner program
 * 
 * @author raghadsalih
 * @version 2022.07.11
 *
 */
public class ProjectRunner {

    /**
     * @param args
     *            string of arguments (arrayQueue, planets[])
     * @throws FileNotFoundException
     *             when file is not found
     * @throws SpaceColonyDataException
     *             when less than 3 planets
     * @throws ParseException
     *             when wrong amount of information
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        if (args.length == 2) {
            ColonyReader main = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader defMain = new ColonyReader("input.txt", "planets.txt");
        }
    }
}
