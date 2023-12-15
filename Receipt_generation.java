import java.io.*;
public class Receipt_generation
{
 void generateReceipt(String name, int car, String time, char pickup, char
destination, double totalAmt,int taxino)
 {
 try {
 // Open a FileOutputStream to write to a file
 FileOutputStream fs = new FileOutputStream("booking_confirmation.txt");
 PrintStream ps = new PrintStream(fs);
 // Write the receipt details to the file
 ps.println("*************************************");
 ps.println("********** BOOKING CONFIRMED **********");
 ps.println("*************************************");
 ps.println("\n");
 ps.println("Name:"+ name);
 ps.println("Car Type Booked:"+car);
 ps.println("Car no:"+taxino);
 ps.println("Pickup Location:"+pickup);
 ps.println("Destination:"+destination);
 ps.println("Time:"+time);
 ps.println("Total Amount:"+totalAmt);
 ps.println("*************************************");
 // Print the receipt details to the console using formatting methods
 System.out.println("*************************************");
 System.out.println("********** BOOKING CONFIRMED **********");
 System.out.println("Name:"+name);
 System.out.println("Car Booked:"+car);
 System.out.println("Pickup Location:"+pickup);
 System.out.println("Destination:"+destination);
 System.out.println("Time:"+time);
 System.out.println("Total Amount:"+totalAmt);
 System.out.println("*************************************");
 System.out.println("Receipt generated and saved to
booking_confirmation.txt");
 }
 catch (IOException e)
 {
 System.out.println("Error writing to file: " + e.getMessage());
 }
 }

}
