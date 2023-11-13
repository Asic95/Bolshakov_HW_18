package Bolshakov_HW_18;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Excercise_3 {

    public static void main(String[] args) {
        List<Auto> myAutoPark;
        myAutoPark = generateAutoList();
        Scanner in = new Scanner(System.in);
        int minYear;
        int maxYear;

        System.out.println("\n");
        System.out.println("Формування списку автомобілів: ");
        printAfterFilter(myAutoPark);

        System.out.print("Давайте відфільтруємо автомобілі за кольором. Введіть колір для пошуку авто: ");
        filterByColour(myAutoPark,in.nextLine());
        System.out.println();

        System.out.print("Давайте відфільтруємо автомобілі за ціною. Введіть мінімальну ціну авто: ");
        filterByPrice(myAutoPark,in.nextInt());
        System.out.println();

        System.out.println("Давайте відфільтруємо автомобілі за роками випуску.");
        System.out.print("Введіть мінімальний рік випуску: ");
        minYear = in.nextInt();
        System.out.print("Введіть максимальний рік випуску: ");
        maxYear = in.nextInt();
        filterByYear(myAutoPark,minYear,maxYear);
        System.out.println();

        System.out.println("Всі автомобілі з списку відсортовані за спаданням ціни:");
        filterByPriceDecreasing(myAutoPark);

    }

    public static class Auto  {

        public String name;
        public Integer year;
        public Integer price;
        public String colour;
        public Integer engine;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public Integer getEngine() {
            return engine;
        }

        public void setEngine(Integer engine) {
            this.engine = engine;
        }

        public Auto(String name, Integer year, Integer price, String colour, Integer engine) {
            this.name = name;
            this.year = year;
            this.price = price;
            this.colour = colour;
            this.engine = engine;
        }

        @Override
        public String toString() {
            return "Auto{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", colour='" + colour + '\'' +
                    ", engine=" + engine +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Auto auto = (Auto) o;
            return Objects.equals(name, auto.name) && Objects.equals(year, auto.year) && Objects.equals(price, auto.price) && Objects.equals(colour, auto.colour) && Objects.equals(engine, auto.engine);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, year, price, colour, engine);
        }
    }

    public static void printAfterFilter (List<Auto> filteredList) {
        for (Auto myAuto : filteredList) {
            System.out.println(myAuto);
        }
        System.out.println("\n");
    }

    public static void filterByColour (List<Auto> myAutoPark, String colour) {
        List<Auto> carsFilterColour = myAutoPark.stream()
                .filter(specialist -> specialist.getColour().equals(colour)).toList();        // Фільтрування авто з певним кольором
        printAfterFilter(carsFilterColour);
    }

    public static void filterByPrice (List<Auto> myAutoPark, int minPrice) {
        List<Auto> carsFilterPrice = myAutoPark.stream().filter(k -> k.price >= minPrice).toList();       // Фільтрування авто більше вказаної ціни
        printAfterFilter(carsFilterPrice);
    }

    public static void filterByYear (List<Auto> myAutoPark, int minYear, int maxYear) {
        List<Auto> carsFilterYear = myAutoPark.stream().filter(k -> k.year >= minYear && k.year <= maxYear).toList();       // Фільтрування авто в діапазоні років
        printAfterFilter(carsFilterYear);
    }

    public static void filterByPriceDecreasing (List<Auto> myAutoPark) {
        List<Auto> carsFilterPriceDecreasing = myAutoPark.stream().sorted(Comparator.comparingInt(Auto::getPrice).reversed()).toList();  // Сортування авто по ціні (спадання)
        printAfterFilter(carsFilterPriceDecreasing);
    }

    public static List<Auto> generateAutoList() {
        return List.of(
                new Auto("Car 1", 1995, 11000, "red", 1),
                new Auto("Car 2", 1996, 12000, "blue", 2),
                new Auto("Car 3", 1997, 13000, "yellow", 3),
                new Auto("Car 4", 1998, 14000, "brown", 4),
                new Auto("Car 5", 1999, 15000, "green", 5),
                new Auto("Car 6", 2000, 16000, "red", 1),
                new Auto("Car 7", 2001, 17000, "blue", 2),
                new Auto("Car 8", 2002, 18000, "yellow", 3),
                new Auto("Car 9", 2003, 19000, "brown", 4),
                new Auto("Car 10", 2004, 20000, "green", 5)
                );
    }

}
