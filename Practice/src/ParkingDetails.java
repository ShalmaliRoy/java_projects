import java.util.Objects;

public class ParkingDetails {

    public int parkingSlotNumber;
    public boolean occupied;
    public int level;

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(int parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingDetails that = (ParkingDetails) o;
        return parkingSlotNumber == that.parkingSlotNumber &&
                occupied == that.occupied &&
                level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSlotNumber, occupied, level);
    }

    public ParkingDetails(int parkingSlotNumber, boolean occupied, int level) {
        this.parkingSlotNumber = parkingSlotNumber;
        this.occupied = occupied;
        this.level = level;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
