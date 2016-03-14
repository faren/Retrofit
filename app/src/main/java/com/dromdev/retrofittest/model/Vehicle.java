package com.dromdev.retrofittest.model;

import java.util.List;

/**
 * Created by Faren on 3/14/16.
 */
public class Vehicle {
    List<ItemVehicle> vehicles;

    public List<ItemVehicle> getVehicles() {
        return vehicles;
    }

    public class ItemVehicle {
        private int id;
        private String name;
        private int length;
        private int height;
        private int pricePerKm;
        private int pricePerShipper;
        private boolean fragileItemSupport;
        private boolean airConditionerSupport;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getLength() {
            return length;
        }

        public int getHeight() {
            return height;
        }

        public int getPricePerKm() {
            return pricePerKm;
        }

        public int getPricePerShipper() {
            return pricePerShipper;
        }

        public boolean isFragileItemSupport() {
            return fragileItemSupport;
        }

        public boolean isAirConditionerSupport() {
            return airConditionerSupport;
        }
    }
}
