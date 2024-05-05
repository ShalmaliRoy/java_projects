import java.util.*;

public class ParkingMain {
    static Map<CarParkingType, Set<ParkingDetails>> vehicleMap=new HashMap<>();
    static Map<String, ParkingLot> parkVehicleMap=new HashMap<>();


    private static void prepareData() {
        Set<ParkingDetails> parkingDetailsSet = new HashSet<>();
        parkingDetailsSet.add(new ParkingDetails(101, false, 1));
        parkingDetailsSet.add(new ParkingDetails(102, false, 1));
        parkingDetailsSet.add(new ParkingDetails(103, false, 1));
        parkingDetailsSet.add(new ParkingDetails(104, false, 1));

        vehicleMap.put(new CarParkingType("Car", 1, false), parkingDetailsSet);
        parkingDetailsSet = new HashSet<>();
        parkingDetailsSet.add(new ParkingDetails(201, false, 2));
        parkingDetailsSet.add(new ParkingDetails(202, false, 2));
        parkingDetailsSet.add(new ParkingDetails(203, false, 2));
        parkingDetailsSet.add(new ParkingDetails(204, false, 2));
        vehicleMap.put(new CarParkingType("Car", 2, false), parkingDetailsSet);


    }
    public static void main(String ...args){
       prepareData();
        Map<Integer,ParkingStatus> returnMap;
       ParkingLot parkingLot=new ParkingLot(vehicleMap);
          returnMap=parkingLot.park();
        System.out.println(returnMap.size());

        parkingLot=new ParkingLot(vehicleMap);
        returnMap=parkingLot.park();
        System.out.println(returnMap.size());
        parkingLot=new ParkingLot(vehicleMap);
        returnMap=parkingLot.park();
        System.out.println(returnMap.size());
        parkingLot=new ParkingLot(vehicleMap);
        returnMap=parkingLot.park();
        System.out.println(returnMap.size());
        parkingLot=new ParkingLot(vehicleMap);
        returnMap=parkingLot.park();
        System.out.println(returnMap.size());
        /*vehicle= parkVehicleMap.get("Car");
        returnMap=vehicle.park();
        System.out.println(returnMap.size());
        vehicle= parkVehicleMap.get("Car");
        returnMap=vehicle.park();
        System.out.println(returnMap.size());

        returnMap=vehicle.vacate(2,203);
        System.out.println(returnMap.size());
        vehicle= parkVehicleMap.get("Car");
        vehicle.park();
        System.out.println(returnMap.size());

        vehicle= parkVehicleMap.get("Car");
        vehicle.park();
        System.out.println(returnMap.size());

        System.out.println("true");*/
    }
}
