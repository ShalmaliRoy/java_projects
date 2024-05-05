import java.util.Objects;
import java.util.Set;

public class ParkingStatus {

    public Set availableSlots;
    public int vacantSlots;

    public ParkingStatus(Set availableSlots, int vacantSlots) {
        this.availableSlots = availableSlots;
        this.vacantSlots = vacantSlots;
    }
    public ParkingStatus(){

    }

    public Set getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Set availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getVacantSlots() {
        return vacantSlots;
    }

    public void setVacantSlots(int vacantSlots) {
        this.vacantSlots = vacantSlots;
    }
}
