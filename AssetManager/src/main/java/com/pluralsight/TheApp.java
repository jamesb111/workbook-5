package com.pluralsight;

import java.util.ArrayList;

public class TheApp {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        House mainHome = new House("My house in Massachusetts", "04-20-2012",
                245000.00, "123 Fake Street", 2, 4500, 5600);

        House vacayHome = new House("John's Beachfront property in Miami", "02-17-2018",
                782300.00, "456 Real Street", 1, 3200, 4200);

        Vehicle weekendCar = new Vehicle("Thomas's fun car on the weekend", "10-23-2015", 55000,
                "Ford Mustang", 2014, 23100);

        Vehicle dailyDriver = new Vehicle("Tom's daily driver for work", "09-08-2020", 12000,
                "Honda Civic", 2011, 189000);

        assets.add(mainHome);
        assets.add(vacayHome);
        assets.add(weekendCar);
        assets.add(dailyDriver);

        for(Asset a: assets) {
            System.out.println(a.getDescription() );
            if(a instanceof House) {
                System.out.println("House address is: " + ((House) a).getAddress());
            } else if(a instanceof Vehicle) {
                System.out.println("Vehicle Make and Model is: " + ((Vehicle) a).getMakeModel());
            }
            System.out.println("Date Acquired: " + a.getDateAcquired());
            System.out.println("Original price: " +a.originalCost);
            System.out.println("Asset Value: " + a.getValue());
            System.out.println("------------------------------");
        }
    }
}
