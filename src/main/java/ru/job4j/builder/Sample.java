package ru.job4j.builder;

import oop.Builder;

public class Sample {
    public static void main(String[] args) {
        Car car = new Builder()
                .buildManufacturer("MAN")
                .buildColor("Red")
                .build();
        System.out.println(car);
    }

    public static class Car {
        private String manufacturer;
        private String model;
        private String year;
        private String engineType;
        private Integer horsePower;
        private String color;
        private String addOnce;
        private Float price;

        @Override
        public String toString() {
            return "Car{" +
                    "manufacturer='" + manufacturer + '\'' +
                    ", model='" + model + '\'' +
                    ", year='" + year + '\'' +
                    ", engineType='" + engineType + '\'' +
                    ", horsePower=" + horsePower +
                    ", color='" + color + '\'' +
                    ", addOnce='" + addOnce + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    static class Builder {
        private String manufacturer;
        private String model;
        private String year;
        private String engineType;
        private Integer horsePower;
        private String color;
        private String addOnce;
        private Float price;


        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildYear(String year) {
            this.year = year;
            return this;
        }

        Builder buildEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        Builder buildHorsePower(Integer horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildAddOnce(String addOnce) {
            this.addOnce = addOnce;
            return this;
        }

        Builder buildPrice(Float price) {
            this.price = price;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.manufacturer = manufacturer;
            car.model = model;
            car.addOnce = addOnce;
            car.color = color;
            car.engineType = engineType;
            car.horsePower = horsePower;
            car.price = price;
            car.year = year;
            return car;
        }
    }

}

