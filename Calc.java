import java.util.*;
public class calc extends fc {
 double amount = 0;
 int surcharge = 100;
 void printdetails() {
 super.printdetails();
 }
 double farecalc() {
 if (ac == 1) {
 amount = (dis * 10) + (ini5km) + (100) + (surcharge);
 } else {
 amount = (dis * 10) + ini5km + surcharge;
 }
 if (i == 0) {
 System.out.println("\nTOTAL AMOUNT----->RS." + amount);
 }
 return amount;
 }
}
class fc {
 int i;
 Scanner sc = new Scanner(System.in);
 protected double dis; // Change from float to double
 String location;
 String destination;
 int ini5km = 60;
 public int ac;
 void getdetails(char a,char b) {
 char pickupLocation = a;
 Location pickup = new Location(pickupLocation);
 char dropLocation = b;
 Location drop = new Location(dropLocation);
 // Validate input
 if (!isValidLocation(pickup) || !isValidLocation(drop)) {
 System.out.println("\nInvalid location. Please enter a valid location (A to
F).");
 return;
 }
 dis = new Taxi().calculateDistance(pickup, drop);
 System.out.println("\nDo you prefer AC?? (YES-1, NO-0): ");
 ac = sc.nextInt();
 try {
 if (dis <= 0) {
 throw new ArithmeticException("Distance cannot be zero or negative");
 }
 } catch (ArithmeticException e) {
 i = 1;
 System.out.println(e.getMessage());
 }
 }
 void printdetails() {
 if (i != 1) {
 System.out.println("\nUSER'S DETAILS");
 // System.out.println("Your current location is:" + pickuplocation);
 // System.out.println("Your destination is:" + destination);
 System.out.println("\nTotal distance is:" + dis + " km");
 System.out.println("\nDo you prefer AC??:" + ac);
 }
 }
 private boolean isValidLocation(Location location) {
 return location.getName() >= 'A' && location.getName() <= 'F';
 }
}
