package model;

public class Dessert extends Product {
    public Dessert(String name, double basePrice, String description, int initialStock) {
        super(name, basePrice,description, initialStock);
    }

    /**
     * Implements the rule price for Disserts
     * Base price + cost of coverage/extras
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    /**
     * Customize the exhibition of details, changing the term "Addons" to "Coverage/Extras"
     */
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!getAddons().isEmpty()) {
            details.append("\n -> Coverage/Extras: ");

            getAddons().forEach(addon ->
                details.append(addon.getDisplayName()).append(", ")
            );
            details.setLength(details.length() - 2);
        }
        return details.toString();
    }
}
