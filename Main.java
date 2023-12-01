import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
public class Main
{ static int check_input (char input)
 { input = Character.toUpperCase (input);
 if (input == 'A' || input == 'B' || input == 'C' || input == 'D'
|| input == 'E' || input == 'F')
 return 1;
 else{System.out.println ("Renter:");
return 0;}}
 static char pickup;
 static char destination;
 static String Time;
 static int car;
 static String Name;
 static String contactNumber;
 static String temp, temp1, date;
 static int n, id, type;
 static LocalDate today;
 static int pickno;
 static int customerNameToCancel;
 public static void main (String[]args)
 {//Create a list of vehicles.
 List < Vehicle > vehicles = new ArrayList <> ();
 vehicles.add (new Vehicle (1, 4, 'A', 0, true));
 vehicles.add (new Vehicle (2, 4, 'A', 0, true));
 vehicles.add (new Vehicle (3, 4, 'A', 0, true));
 vehicles.add (new Vehicle (4, 4, 'A', 0, true));
 vehicles.add (new Vehicle (5, 6, 'A', 0, true));
 vehicles.add (new Vehicle (6, 6, 'A', 0, true));
 // Create a list of pickup spots.
 List < PickupSpot > pickupSpots = new ArrayList <> ();
 pickupSpots.add (new PickupSpot (1, 'A'));
 pickupSpots.add (new PickupSpot (2, 'B'));
 pickupSpots.add (new PickupSpot (3, 'C'));
 pickupSpots.add (new PickupSpot (4, 'D'));
 pickupSpots.add (new PickupSpot (5, 'E'));
 pickupSpots.add (new PickupSpot (6, 'F'));
 Scanner sc = new Scanner (System.in);
 System.out.println ("\n\n ...............................Car Booking System.....................................\n\n");

 input:while (true)
 { try {
 do {System.out.print ("Enter Pickup Location: ");
 temp = sc.next ();
 pickup = temp.charAt (0);
 n = check_input (pickup);}
 while (n != 1);
 do{System.out.print ("Enter Drop-off Location: ");
 temp1 = sc.next ();
 destination = temp1.charAt (0);
 n = check_input (destination);
 } while (n != 1);
 LocalDate today = LocalDate.now ();
 date = today.toString ();
 do{System.out.print ("Enter Pickup Time (HH:MM): ");
 Time = sc.next ();
 DateTimeFormatter format =
DateTimeFormatter.ofPattern ("HH:MM");
 try{LocalTime enteredTime = LocalTime.parse (Time, format);
n = 1;}
 catch (Exception e)
 { System.out.println
 ("Error: Invalid time format. Please enter time in HH:MM:SS format.");
n = 0;}}
 while (n != 1);
 System.out.print ("Enter Car Preference: ");
 car = sc.nextInt();
 System.out.print ("Enter Your Name: ");
 Name = sc.next ();
 sc.nextLine ();
 System.out.print ("Enter Contact Number: ");
 contactNumber = sc.nextLine ();
 System.out.println("\n....................................................................................\n");
}
catch (Exception e)
{ System.out.println
 ("Error: Invalid input. Please check your input and try again."); }
finally
{

 if(pickup == 'A')
 {pickno = 0;}
 if(pickup == 'B')
 {pickno = 1;}
 if(pickup == 'C')
 {pickno = 2;}
 if(pickup == 'D')
 {pickno = 3;}
 if(pickup == 'E')
 {pickno = 4;}
 if(pickup == 'F')
 {pickno = 5;}
// Create an availability checking module.
 AvailabilityCheckingModule availabilityCheckingModule =
 new AvailabilityCheckingModule (vehicles, pickupSpots);
 // Check the availability of vehicles in pickup spot 1.
 int taxino = availabilityCheckingModule.checkAvailability (pickupSpots.get (pickno),vehicles);
 // If a vehicle is available, allocate it to the customer.
 if (taxino != 0)
 {System.out.println ("\nVEHICLE ALLOCATED: " + taxino); }
 else
 { System.out.println ("\nNo vehicle available");}
 //BOOKING MODULE
 char pickupLocation = pickup;
 Location pickupLocationObj = new Location(pickupLocation);
 char dropLocation = destination;
 Location dropLocationObj = new Location(dropLocation);
 // Calculate distance and fare

 Taxi taxi = new Taxi();
 calc c = new calc();
 c.getdetails(pickupLocation,dropLocation);
 c.printdetails();
 double fare =c.farecalc();
 System.out.println("Fare: " + fare);
 //change availability of vehicle no 3 for 30 secs
 // Change the availability of vehicle number 3 for 30 seconds.
 if (taxino!=0)
 {Timer timer = new Timer();
 int g =taxino -1;
 vehicles.get(taxino - 1).available = false;
 timer.schedule(new TimerTask() {
 @Override
 public void run() {
 synchronized (vehicles.get(taxino - 1)) {
 Vehicle vehicle = vehicles.get(taxino - 1);
 vehicle.available = true;
 }
 }
 }, 22000, 1);
 Receipt_generation r= new Receipt_generation();
 r.generateReceipt(Name, taxino, Time, pickup, destination, fare, taxino);

 vehicles.get(taxino - 1).loc=dropLocation;
 vehicles.get(taxino-1).earning=+fare;

 }
 else
 {
 System.out.println("SORRY THERE ARE NO VEHICLES AVAILABLE AT THE MOMENT !!");
 }
 // Cancellation module
Scanner scanner = new Scanner(System.in);
 String s1 = "yes";
 System.out.println(" \ndo you want to cancel you drive?:(true/false)");
 String choise = scanner.nextLine();
 if(s1.equals(choise)==true){
 vehicles.get(taxino - 1).loc=pickupLocation;
 vehicles.get(taxino-1).earning=0;
 vehicles.get(taxino-1).available=true;
 System.out.println("\nBooking has been successfully cancelled");}
}
 System.out.println("TAXI DETAILS:");
 int i=0;
 for(i=0;i<6;i++)
 {
 vehicles.get(i).print();
 }
System.out.println ("Want to re-enter? (yes/no)");
 temp = sc.next ();
 if (temp.equalsIgnoreCase ("no"))
 {
 break input; }}
 }
 }
class Taxi {
 private static final double FARE_RATE = 10.0; // Fare rate per kilometer
 private static final int[][] DISTANCE_MATRIX = { { 0, 15, 30, 45, 60, 75 }, { 15, 0, 15, 30, 45, 60 },
 { 30, 15, 0, 15, 30, 45 }, { 45, 30, 15, 0, 15, 30 }, { 60, 45, 30, 15, 0, 15 },
 { 75, 60, 45, 30, 15, 0 } };
 public double calculateDistance(Location pickup, Location drop) {
 int pickupIndex = pickup.getName() - 'A';
 int dropIndex = drop.getName() - 'A';
 return DISTANCE_MATRIX[pickupIndex][dropIndex];
 }
 public double calculateFare(double distance) {
 return distance * FARE_RATE + (100);
 }
}
