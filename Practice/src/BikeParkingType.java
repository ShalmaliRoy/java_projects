import java.util.Objects;

public class BikeParkingType implements Comparable<CarParkingType>,Vehicle {

    public String vehicleType;
    public int level;
    public boolean isFull = false;

    public BikeParkingType(String vehicleType, int level, boolean isFull) {
        this.vehicleType = getParkingType();
        this.level = level;
        this.isFull = isFull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarParkingType that = (CarParkingType) o;
        return level == that.level &&
                vehicleType.equals(that.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, level);
    }

    @Override
    public int compareTo(CarParkingType o) {

        if (this.level > o.level)
            return 0;
        return 1;
    }

    @Override
    public String getParkingType() {
        return "Bike";
    }
}