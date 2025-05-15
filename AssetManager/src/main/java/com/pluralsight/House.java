package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }



    //gets value of ice based and sets square ft
    @Override
    public double getValue() {
        double pricePerSqFt;
        // multiples price per square ft with square ft amount to get total value
        double totalSquareFootValue;
        //gets total value of lot
        double totalLotValue = 0.25 * this.lotSize;;
        if(this.condition == 1) {
            pricePerSqFt = 180.00;
        } else if(this.condition == 2) {
            pricePerSqFt = 130.00;
        } else if(this.condition == 3) {
            pricePerSqFt = 90.00;
        } else if(this.condition == 4) {
            pricePerSqFt = 80.00;
        } else {
            pricePerSqFt = 0;
        }

        totalSquareFootValue = pricePerSqFt * this.squareFoot;
        return totalSquareFootValue + totalLotValue;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
