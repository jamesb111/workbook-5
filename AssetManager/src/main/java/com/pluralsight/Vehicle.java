package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;
    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int carVal;

        //grabs current year to make comparisons
        int currentYear = LocalDate.now().getYear();
        //gets actual age of car
        int actualCarAge = currentYear - this.year;
        //will be used to get reduced car val
        double depreciatedValue = this.originalCost;
        double reducedValOfCar;

        //booleans that compares cars age Cars year is subtracted from current year to get age
        boolean isRecentCar = currentYear - this.year <= 3;
        boolean isLessRecentCar = currentYear - this.year >= 4 && currentYear - this.year <= 6;
        boolean isSlightlyOldCar = currentYear - this.year >= 7 && currentYear - this.year <= 10;
        boolean isOldCar = currentYear - this.year > 10;

        if(isRecentCar) {
            for(int i = 0; i < actualCarAge; i++) {
                depreciatedValue -= depreciatedValue* 0.03;
            }
        } else if(isLessRecentCar) {
            for(int i = 0; i < actualCarAge; i++) {
                depreciatedValue -= depreciatedValue* 0.06;
            }
        } else if(isSlightlyOldCar) {
            for(int i = 0; i < actualCarAge; i++) {
                depreciatedValue -= depreciatedValue* 0.08;
            }
        } else if(isOldCar) {
            depreciatedValue = depreciatedValue - 1000.00;
        }

        boolean isReliable = this.makeModel.toLowerCase().contains("honda") || this.makeModel.toLowerCase().contains("toyota");
        if(this.odometer > 100000 && !isReliable) {
            depreciatedValue -= depreciatedValue * 0.25;
        }
        return depreciatedValue;

    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
