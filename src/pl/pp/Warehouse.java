package pl.pp;

import java.util.Locale;

public class Warehouse {
    // Private fields for encapsulation
    private String warehouseNumber;
    private double totalWarehouseSpace; // Total capacity of the warehouse
    private double occupiedWarehouseSpace; // Currently occupied space
    private String warehouseOwnerName;
    private String ownerEmail;
    private String ownerPhone;

    // Constructor
    public Warehouse(String warehouseNumber, double totalWarehouseSpace, String warehouseOwnerName, String ownerEmail, String ownerPhone) {
        this.warehouseNumber = warehouseNumber;
        this.totalWarehouseSpace = Math.max(0, totalWarehouseSpace); // Ensure non-negative space
        this.occupiedWarehouseSpace = 0; // Initially empty
        this.warehouseOwnerName = warehouseOwnerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;

        System.out.printf(Locale.US, "Warehouse %s created for %s. Total space: %.2f units.%n",
                          this.warehouseNumber, this.warehouseOwnerName, this.totalWarehouseSpace);
        checkOccupancy(); // Display initial occupancy
    }

    // --- Getters ---
    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public double getTotalWarehouseSpace() {
        return totalWarehouseSpace;
    }

    public double getOccupiedWarehouseSpace() {
        return occupiedWarehouseSpace;
    }

    public double getAvailableWarehouseSpace() {
        return totalWarehouseSpace - occupiedWarehouseSpace;
    }

    public String getWarehouseOwnerName() {
        return warehouseOwnerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    // --- Setters ---
    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    // Total space might change, e.g., expansion
    public void setTotalWarehouseSpace(double totalWarehouseSpace) {
        if (totalWarehouseSpace >= this.occupiedWarehouseSpace) {
            this.totalWarehouseSpace = Math.max(0, totalWarehouseSpace);
            System.out.printf(Locale.US, "Warehouse %s total space updated to: %.2f units.%n", 
                              this.warehouseNumber, this.totalWarehouseSpace);
        } else {
            System.out.printf(Locale.US, "Cannot set total space to %.2f units. It's less than occupied space (%.2f units).%n", 
                              totalWarehouseSpace, this.occupiedWarehouseSpace);
        }
    }

    // Occupied space should only be changed via addGoods/removeGoods

    public void setWarehouseOwnerName(String warehouseOwnerName) {
        this.warehouseOwnerName = warehouseOwnerName;
        System.out.printf("Warehouse %s owner name updated to: %s%n", this.warehouseNumber, this.warehouseOwnerName);
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
        updateContact(this.ownerEmail, this.ownerPhone); // Call updateContact to show change
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
        updateContact(this.ownerEmail, this.ownerPhone); // Call updateContact to show change
    }

    // --- Operation Methods ---

    /**
     * Adds a specified amount of goods to the warehouse if space is available.
     * @param amount The amount of goods to add (must be positive).
     */
    public void addGoods(double amount) {
        if (amount <= 0) {
            System.out.println("Amount of goods to add must be positive.");
            return;
        }
        if (getAvailableWarehouseSpace() >= amount) {
            this.occupiedWarehouseSpace += amount;
            System.out.printf(Locale.US, "Added %.2f units of goods. Remaining warehouse space: %.2f units.%n",
                              amount, getAvailableWarehouseSpace());
        } else {
            System.out.printf(Locale.US, "Cannot add %.2f units of goods. Not enough space. Available: %.2f units.%n",
                              amount, getAvailableWarehouseSpace());
        }
    }

    /**
     * Removes a specified amount of goods from the warehouse if they exist.
     * @param amount The amount of goods to remove (must be positive).
     */
    public void removeGoods(double amount) {
        if (amount <= 0) {
            System.out.println("Amount of goods to remove must be positive.");
            return;
        }
        if (this.occupiedWarehouseSpace >= amount) {
            this.occupiedWarehouseSpace -= amount;
            System.out.printf(Locale.US, "Removed %.2f units of goods. Remaining warehouse space: %.2f units.%n",
                              amount, getAvailableWarehouseSpace());
        } else {
            System.out.printf(Locale.US, "Cannot remove %.2f units of goods. Not enough goods in stock. Occupied: %.2f units.%n",
                              amount, this.occupiedWarehouseSpace);
        }
    }

    /**
     * Displays the current occupancy of the warehouse.
     */
    public void checkOccupancy() {
        System.out.printf(Locale.US, "Occupancy Check for Warehouse %s:%n", this.warehouseNumber);
        System.out.printf(Locale.US, "  Total Space:    %.2f units%n", this.totalWarehouseSpace);
        System.out.printf(Locale.US, "  Occupied Space: %.2f units%n", this.occupiedWarehouseSpace);
        System.out.printf(Locale.US, "  Available Space: %.2f units%n", getAvailableWarehouseSpace());
    }

    /**
     * Updates the contact details (email and phone) of the warehouse owner.
     * @param newEmail The new email address.
     * @param newPhone The new phone number.
     */
    public void updateContact(String newEmail, String newPhone) {
        this.ownerEmail = newEmail;
        this.ownerPhone = newPhone;
        System.out.printf("Warehouse %s owner (%s) contact updated: Email - %s, Phone - %s%n",
                          this.warehouseNumber, this.warehouseOwnerName, this.ownerEmail, this.ownerPhone);
    }
} 