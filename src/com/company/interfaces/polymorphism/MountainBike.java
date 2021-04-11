package com.company.interfaces.polymorphism;

//public class MountainBike extends Bicycle {
//
//    // the MountainBike subclass adds one field
//    public int seatHeight;
//
//    // the MountainBike subclass has one constructor
//    public MountainBike(int startHeight,
//                        int startCadence,
//                        int startSpeed,
//                        int startGear) {
//        super(startCadence, startSpeed, startGear);
//        seatHeight = startHeight;
//    }
//
//    // the MountainBike subclass adds one method
//    public void setHeight(int newValue) {
//        seatHeight = newValue;
//    }
//}

public class MountainBike extends Bicycle {
    private String suspension;

    public MountainBike(
            int startCadence,
            int startSpeed,
            int startGear,
            String suspensionType) {
        super(startCadence,
                startSpeed,
                startGear);
        this.setSuspension(suspensionType);
    }

    public String getSuspension() {
        return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" +
                getSuspension() + " suspension.");
    }

    public static void main(String[] args) {
        MountainBike mb = new MountainBike(1, 2, 3, "some");
        mb.printDescription();
    }
}