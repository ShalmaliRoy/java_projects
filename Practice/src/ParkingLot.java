import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static Map<Integer,ParkingStatus> parkingStatusMap=new ConcurrentHashMap<>();
     Map<CarParkingType, Set<ParkingDetails>> vehicleMap;
    public ParkingLot(Map<CarParkingType, Set<ParkingDetails>> vehicleMap){
    this.vehicleMap=vehicleMap;

    }
    public  Map<Integer,ParkingStatus> park() {
         CarParkingType vehicleParkingType=null ;
        int count=0;

        Iterator vehicleIterator = vehicleMap.entrySet().iterator();

        while (vehicleIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry) vehicleIterator.next();
            vehicleParkingType = ((CarParkingType) mapElement.getKey());
            if (vehicleParkingType.isFull)
                parkingStatusMap.remove(vehicleParkingType.level);


            else {
                Set<ParkingDetails> parkingDetailsSet = vehicleMap.get(vehicleParkingType);
                ParkingStatus parkingStatusTobeReturned = null;
                boolean allSlotsFilled = false;
                Set<Integer> availableSlots = new HashSet<>();
                for (ParkingDetails parkingDetails : parkingDetailsSet) {
                    if (!parkingDetails.occupied) {
                        if (count == 0)
                            parkingDetails.setOccupied(true);
                        else {
                            availableSlots.add(parkingDetails.parkingSlotNumber);
                            parkingStatusTobeReturned = new ParkingStatus(availableSlots, availableSlots.size());
                            allSlotsFilled = false;
                            parkingStatusMap.put(parkingDetails.level, parkingStatusTobeReturned);
                        }

                        ++count;

                    }
                    if (parkingStatusTobeReturned == null || count == 1)
                        allSlotsFilled = true;
                }
                parkingStatusTobeReturned=null;
                if (allSlotsFilled) {
                    vehicleParkingType.isFull = true;
                    vehicleMap.put(vehicleParkingType, parkingDetailsSet);
                    parkingStatusMap.remove(vehicleParkingType.level);

                }
            }
        }

            return parkingStatusMap;
    }

    public synchronized Map<Integer, ParkingStatus> vacate(int level, int slotNumber) {
        CarParkingType vehicleParkingType= new CarParkingType("Car",level,false);
        Set<ParkingDetails> parkingDetailsSet=vehicleMap.get(vehicleParkingType);
        ParkingDetails parkingDetail=parkingDetailsSet.stream().filter(x-> x.level ==level && x.parkingSlotNumber==slotNumber ).findFirst().get();
        parkingDetail.setOccupied(false);
        parkingDetailsSet.add(parkingDetail);
        vehicleMap.remove(vehicleParkingType);

        vehicleMap.put(vehicleParkingType,parkingDetailsSet);

        if(!parkingStatusMap.containsKey(level)) {
            Set<Integer> availableSlots=new HashSet<>();
            availableSlots.add(slotNumber);
            parkingStatusMap.put(level, new ParkingStatus(availableSlots,availableSlots.size()));
        }else{
            ParkingStatus parkingStatus=parkingStatusMap.get(level);
            parkingStatus.availableSlots.add(slotNumber);
            parkingStatus.setVacantSlots(parkingStatus.getAvailableSlots().size());
        }
     return parkingStatusMap;
    }


}
