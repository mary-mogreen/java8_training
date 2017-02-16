package ch08.ex07;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;
import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class ComparatorUtilsTest {
    @Test
    public void testNullsFirstReversed() throws Exception {
        Person[] expected = presidents.clone();

        Arrays.sort(expected, comparing(Person::getMiddleName, nullsFirst(Comparator.<String>naturalOrder()).reversed()));

        Arrays.sort(presidents, comparing(Person::getMiddleName, ComparatorUtils.nullsFirstReversed()));

        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], presidents[i]);

    }


    /**
     * sample code ch8.sec04
     */
    static class Person {
        private String name;
        public Person(String name) { this.name = name; }
        public String getName() { return name; }
        public String getFirstName() { return name.substring(0, name.indexOf(' ')); }
        public String getMiddleName() {
            int space1 = name.indexOf(" ");
            int space2 = name.lastIndexOf(" ");
            if (space1 == space2) return null;
            else return name.substring(space1 + 1, space2);
        }
        public String getLastName() { return name.substring(name.lastIndexOf(' ') + 1); }
        public String toString() { return name; }
    }

    public static Person[] presidents = {
            new Person("George Washington"),
            new Person("John Adams"),
            new Person("Thomas Jefferson"),
            new Person("James Madison"),
            new Person("James Monroe"),
            new Person("John Quincy Adams"),
            new Person("Andrew Jackson"),
            new Person("Martin VanBuren"),
            new Person("William Henry Harrison"),
            new Person("John Tyler"),
            new Person("James Knox Polk"),
            new Person("Zachary Taylor"),
            new Person("Millard Fillmore"),
            new Person("Franklin Pierce"),
            new Person("James Buchanan"),
            new Person("Abraham Lincoln"),
            new Person("Andrew Johnson"),
            new Person("Ulysses S. Grant"),
            new Person("Rutherford Birchard Hayes"),
            new Person("James Abram Garfield"),
            new Person("Grover Cleveland"),
            new Person("Benjamin Harrison"),
            new Person("Grover Cleveland"),
            new Person("William McKinley"),
            new Person("Theodore Roosevelt"),
            new Person("William Howard Taft"),
            new Person("Woodrow Wilson"),
            new Person("Warren Gamaliel Harding"),
            new Person("Calvin Coolidge"),
            new Person("Herbert Hoover"),
            new Person("Franklin Delano Roosevelt"),
            new Person("Harry S. Truman"),
            new Person("Dwight David Eisenhower"),
            new Person("John Fitzgerald Kennedy"),
            new Person("Lyndon Baines Johnson"),
            new Person("Richard Mulhouse Nixon"),
            new Person("Gerald Ford"),
            new Person("James Earl Carter"),
            new Person("Ronald Reagan"),
            new Person("George Herbert Walker Bush"),
            new Person("William Jefferson Clinton"),
            new Person("George Walker Bush"),
            new Person("Barack Hussein Obama"),
            new Person("Donald John Trump")
    };
}