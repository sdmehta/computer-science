package com.demo.semesterIII.assignment3.resources.src;

public interface Pizza {
    /**
     * Creates a new derivative Pizza configuration, to include any topping desired
     * by this configuration, another specified configuration, or even both.
     * @param other Pizza with toppings to merge into this Pizza's set
     * @return Pizza with toppings desired by either party (or both)
     */
    public Pizza combine(Pizza other);

    /**
     * Creates a new derivative Pizza configuration, with only those toppings
     * 'agreed upon' by both the current one and another specified Pizza
     * configuration.
     * @param other Pizza with toppings that may or may not match those contained herein
     * @return Pizza with only the intersection of the toppings common to both Pizza configurations
     */
    public Pizza consolidate(Pizza other);

    /**
     * Creates a new derivative Pizza configuration, that contains
     * only those toppings not already present in another specified Pizza.
     * @param other Pizza with toppings that don't need to be included in the new configuration
     * @return the new derived configuration
     */
    public Pizza exclude(Pizza other);

    /**
     * Checks if this Pizza configuration at least covers all the same bases
     * as another specified Pizza.
     * @param other Pizza that might be redundant with this Pizza
     * @return whether or not this Pizza has at least everything included in the other Pizza
     */
    public boolean covers(Pizza other);

    /**
     * Checks if this Pizza configuration is included <em>entirely</em> within
     * the other Pizza specified.
     * @param other Pizza with a potential superset of toppings
     * @return whether or not the other Pizza 'covers' everything offered by this Pizza
     */
    public boolean isCovered(Pizza other);

    /**
     * Tests whether or not a specified Pizza configuration has an identical
     * set of toppings to 'this' one.
     * @param other Pizza to check the toppings in
     * @return whether or not the two Pizza configurations match
     */
    public boolean equals(Pizza other);

    /**
     * Derives a new Pizza configuration, defined as the current one plus one requested topping.
     * (If the requested topping is already present, it's ignored)
     * @param topping to add to new Pizza
     * @return a new Pizza configuration that also includes the requested topping
     * @throws ToppingException if the requested topping is an empty String
     */
    public void add(String topping);

    /**
     * Derives a new Pizza configuration, defined as the current one, minus a single specified topping
     * @param topping to omit from new Pizza
     * @return a new Pizza configuration that excludes the specified topping
     * @throws ToppingException if the specified topping wasn't present to begin with
     */
    public void remove(String topping);

    /**
     * Indicates whether or not the specified topping is included within this Pizza configuration
     * @param topping to check if present
     * @return whether or not specified topping is present
     */
    public boolean contains(String topping);

    /**
     * Packs up all toppings into a single array.
     * (Friendly reminder: you can do this irrespective of the underlying implementation!)
     * @return array containing all toppings on this Pizza, with no extra space at the end
     */
    public String[] getAllToppings();

    //Reminder: You need to implement your own String toString() !
}