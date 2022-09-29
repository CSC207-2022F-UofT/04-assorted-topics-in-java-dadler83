/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /* TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     */

    /**
     * Adds the requested value at the id if the id is not already in the drivable_map
     * @param id the key value for the HashMap
     * @param value the object to be stored at id in the HashMap
     * @return true if the value was successfully added, false otherwise
     */
    public boolean addDrivable(String id, Drivable value) {
        if (drivable_map.containsKey(id)) {
            return false;
        } else {
            drivable_map.put(id, value);
            return true;
        }
    }


    /* TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */

    /**
     * Checks if the drivable_map has an item with speed greater than or equal to the input speed
     * @param speed input speed to check against map
     * @return true if it has an object with faster or equal speed than the input speed, false if not
     */
    public boolean hasFasterThan(int speed) {
        for (Drivable item : drivable_map.values()) {
            if (item.getMaxSpeed() >= speed) {
                return true;
            }
        }
        return false;
    }



    /* TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     */

    /**
     * Gets an ArrayList of all Tradable items in drivable_map
     * @return the List of Tradable items in drivable_map
     */
    public List<Tradable> getTradable() {
        List<Tradable> tradables = new ArrayList<Tradable>();
        for (Drivable item : drivable_map.values()) {
            if (item instanceof Tradable) {
                tradables.add((Tradable) item);
            }
        }
        return tradables;
    }
}