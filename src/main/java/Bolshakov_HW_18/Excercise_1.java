package Bolshakov_HW_18;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Excercise_1 {

    public static void main(String[] args) throws IOException {

        System.out.println("\n");
        System.out.println("Виведення всьго списку працівників з файлу: ");
        File FileIn = new File(READPATH);
        List<Employee> dataFromFile = ReadFromFile(FileIn);

        printList(dataFromFile);
        System.out.println();
        System.out.println("Сортування з використанням Streams");
        printList(filteringAndSorting(dataFromFile));
    }

    public static class Employee implements Comparable<Employee> {

        public String FirstName;
        public String LastName;
        public String Manager;
        public Float Salary;
        public Integer ID;

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(FirstName, employee.FirstName) && Objects.equals(LastName, employee.LastName) && Objects.equals(Manager, employee.Manager) && Objects.equals(Salary, employee.Salary) && Objects.equals(ID, employee.ID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(FirstName, LastName, Manager, Salary, ID);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "FirstName='" + FirstName + '\'' +
                    ", LastName='" + LastName + '\'' +
                    ", Manager='" + Manager + '\'' +
                    ", Salary=" + Salary +
                    ", ID='" + ID + '\'' +
                    '}';
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getManager() {
            return Manager;
        }

        public void setManager(String manager) {
            Manager = manager;
        }

        public Float getSalary() {
            return Salary;
        }

        public void setSalary(Float salary) {
            Salary = salary;
        }


        @Override
        public int compareTo(Employee o) {
            int result = this.getSalary().compareTo(o.getSalary());
            if (result == 0) {
                result = this.getLastName().compareTo(o.getLastName());
            }
            return result;
        }
    }


    public static List<Employee> filteringAndSorting(List<Employee> specialists) {
        List<Employee> filteredSpecialists = specialists.stream()
                .filter(specialist -> specialist.getManager().equals("Y")).toList();        // Виділення тільки менеджерів зі списку

        List<Employee> sortedSpecialists = filteredSpecialists.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());                                               // Сортування за прізвищем та ім'ям

        return sortedSpecialists;
    }


    public static void printList (List<Employee> dataFromFile){
        for (Employee employee : dataFromFile) {
            System.out.println(employee);
        }
    }
    public static List<Employee> ReadFromFile(File file) throws IOException {

        FileUtils.readLines(file, Charset.defaultCharset());
        List<String> fileData = FileUtils.readLines(file, Charset.defaultCharset());

        List<Employee> specialists = new ArrayList<>();

        for (int i = 1; i < fileData.size(); i++) {
            String[] separatedData = fileData.get(i).split(",");
            Employee employees = new Employee();

            employees.setID(Integer.parseInt(separatedData[0]));
            employees.setFirstName(separatedData[1]);
            employees.setLastName(separatedData[2]);
            employees.setSalary((Float.valueOf(separatedData[3])));
            employees.setManager(separatedData[4]);

            specialists.add(employees);
        }
        return specialists;
    }
    static final String READPATH = "src/main/java/Bolshakov_HW_18/students_small.csv";
}
