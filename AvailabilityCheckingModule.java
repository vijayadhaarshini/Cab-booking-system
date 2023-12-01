import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
public class AvailabilityCheckingModule {
 private List<Vehicle> vehicles;
 private List<PickupSpot> pickupSpots;
 List<Double> earning = new ArrayList<>();
 List<Integer> distance = new ArrayList<>();
 private int maxDistance;
 public AvailabilityCheckingModule(List<Vehicle> vehicles, List<PickupSpot>
pickupSpots) {
 this.vehicles = vehicles;
 this.pickupSpots = pickupSpots;
 this.maxDistance = 5;

 }
 public List<Vehicle> getVehiclesFromPickupSpots(List<PickupSpot>
sortedOrders, List<Vehicle> vehicles) {

 List<Vehicle> Earningshrt = new ArrayList<>();
 int flag=0;
 for(int n=0;n<sortedOrders.size();n++)
 {
 for( int m=0;m<vehicles.size();m++)
 { if((sortedOrders.get(n).pickup ==
vehicles.get(m).loc)&&(vehicles.get(m).available==true))
 { Earningshrt.add(vehicles.get(m));
 earning.add(vehicles.get(m).earning);
 flag=1;} }
 if (flag==1)
 { return(Earningshrt);}
 }
 return(Earningshrt);
 }

 //int vehicleId = pickupSpot.getVehicleID();
 // Get the vehicle object from the vehicle ID.
 //Vehicle vehicle = getVehicle(vehicleId);
 // Add the vehicle object to the list of vehicles.
 //vehicles.add(vehicle);//

 public int getDistance(PickupSpot a, PickupSpot b) {
 int ans = a.getName() - b.getName();
 if (ans < 0) {
 return (-ans);
 } else {
 return ans;
 }
 }
 public List<PickupSpot>
bubbleSortAscendingOrderInDistanceList(List<PickupSpot> pickupSpots,
List<Integer> distance)
 {
 for (int i = 0; i < distance.size() - 1; i++) {
 for (int j = 0; j < distance.size() - i - 1; j++) {
 if (distance.get(j) > distance.get(j + 1)) {
 Collections.swap(pickupSpots, j, j + 1);
 }
 }
 }
 return pickupSpots;
}

 public int calculateDistance(PickupSpot a, PickupSpot b) {
 int ans = a.getName() - b.getName();
 if (ans < 0) {
 return (-ans);
 } else {
 return ans;
 }}
public int checkAvailability(PickupSpot pickupSpot,List<Vehicle> a)
 { ArrayList<PickupSpot>Order = new ArrayList<PickupSpot>();
 for (PickupSpot pickupSpot2 : pickupSpots)
 {
 int distance = calculateDistance(pickupSpot, pickupSpot2);
 Order.add(pickupSpot2);
 this.distance.add(distance);
 }

 // Create a new list to store the sorted Order objects.
 List<PickupSpot> sortedOrders = new ArrayList<>();
 sortedOrders=bubbleSortAscendingOrderInDistanceList(Order,distance);

 List<Vehicle> vehiclesa = getVehiclesFromPickupSpots(sortedOrders,a);

 if(vehiclesa != null)
 { int idno = 0;
 double min=100000;
 for(int u=0;u<vehiclesa.size();u++)
 {
 if(min > (vehiclesa.get(u).earning))
 { min = vehiclesa.get(u).earning;
 idno = vehiclesa.get(u).id;
 }
 }
 return idno;
 }
 else
 return 0;


 }
 }
