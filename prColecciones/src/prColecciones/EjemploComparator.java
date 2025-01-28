package prColecciones;

import java.util.*;
import java.util.stream.Collectors;

public class EjemploComparator {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", "Doe", 25),
            new Person("Jane", "Doe", 22),
            new Person(null, "Smith", 30),
            new Person("Alice", null, 35)
        );

        // Comparador que maneja nulls y encadena criterios
        Comparator<Person> comparator = Comparator.comparing(Person::getLastName, Comparator.nullsFirst(String::compareTo))
                                                  .thenComparing(Person::getFirstName, Comparator.nullsLast(String::compareTo))
                                                  .thenComparingInt(Person::getAge);

        // Ordenar la lista
        List<Person> sortedPeople = people.stream()
                                          .sorted(comparator)
                                          .collect(Collectors.toList());

        sortedPeople.forEach(System.out::println);
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Person{firstName='%s', lastName='%s', age=%d}", firstName, lastName, age);
    }
}
