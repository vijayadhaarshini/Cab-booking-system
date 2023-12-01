import java.time.LocalDate;
import java.util.*;
import java.time.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Details {
 int check_input(char input) {
 input = Character.toUpperCase(input);
 if (input == 'A' || input == 'B' || input == 'C' || input == 'D' || input == 'E' || input
== 'F')
 return 1;
 else {
 System.out.println("Renter:");
 return 0;
 }
 }
 int id;
 char pickup;
 char destination;
 String time;
 String car;
 boolean ac;
 String name;
 String contactNumber;
 String email;
 public Details(int id, char pickup, char destination, String time, String car,
boolean ac, String name, String contactNumber, String email) {
 this.id = id;
 this.pickup = pickup;
 this.destination = destination;
 this.time = time;
 this.car = car;
 this.ac = ac;
 this.name = name;
 this.contactNumber = contactNumber;
 this.email = email;
 }
}
