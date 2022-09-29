/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable> {
    /**
     * Constructs a new DrivableTrader with giving them the given inventory,
     * wishlist, and money.
     * @param inventory The DrivableTrader's current inventory of Drivable items
     * @param wishlist The DrivableTrader's wishlist of Drivable items
     * @param money The DrivableTrader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist,
                          int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Constructs a new DrivableTrader with the input amount of money
     * @param money The DrivableTrader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * Gets the selling price of the input item
     * @param item Drivable object with or without selling price
     * @return selling price of the item or the Tradable.MISSING_PRICE constant if it is not Tradable
     */
    @Override
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return item.getMaxSpeed() + ((Tradable) item).getPrice();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }
}