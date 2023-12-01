import java.util.*;
class Vehicle {
 int id;
 private int type;
 char loc;
 double earning;
 boolean available;

 //creating vehicle constructor to initialize no of vehicles at start and it's
destination
 public Vehicle(int id,int type,char loc, double earning, boolean available)
 { this.id=id;
 this.type = type;
 this.loc = loc;
 this.earning = earning;
 this.available = true;
 }

 void print()
 {
 System.out.println("id: "+ id+ "\ntype:" + type+"\nloc: "+loc+"\nearning:
"+earning+"\nAvailability: "+available+ "\n");
 }
 public int getId() {
 return id;
 }

 public int getType() {
 return type;
 }

 public char getLocation() {
 return loc;
 }
 public double getEarning() {
 return earning;
 }
 public void setAvailability()
 {
 available = false;
 }
 public boolean isAvailable() {
 return available;
 }
 }
