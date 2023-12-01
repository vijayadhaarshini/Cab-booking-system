class PickupSpot {

 int name;
 char pickup;
 public PickupSpot(int name, char pickup) {

 this.name = name;
 this.pickup= pickup;
 } public char getLocation() {
 return pickup;
 }

 public int getName() {
 return name;
 }
 public char getPickup() {
 return pickup;
 }

 public int distanceFrom(PickupSpot otherPickupSpot) {
 return Math.abs(this.name - otherPickupSpot.name);
 }
 }
