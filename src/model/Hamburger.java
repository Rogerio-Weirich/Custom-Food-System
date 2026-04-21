package model;

public class Hamburger extends Product {
    public Hamburger(String name, double basePrice, String description, int initialStock) {
        super(name, basePrice, description, initialStock);
    }

    /**
     * The @Override indicates that the 'contract' made in the abstract class is being fulfilled
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    /**
     * Override the method getDetails to make it "look like" Hamburger
     */
    @Override
    public String getDetails() {
        stringBuilder details = new Stringbuilder(super.getDetails());
        if (!getAddons().isEmpty()) {
            details.append("\n -> Customizable Addons: ");

            getAddons().forEach(addon ->
                    details.append(addon.getDisplayName()).append(", ")
            );
            details.setLenght(details.lenght() - 2);
        }
        return details.toString();
    }
}
