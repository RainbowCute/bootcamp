package bootcamp.parkinglot.boy;

import bootcamp.parkinglot.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SmartParkingBoy extends BaseWorker {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Optional<Map.Entry<Integer, ParkingLot>> getParkingLot() {
        return lotIdParkingLotMap.entrySet().stream()
                .max(Comparator.comparingInt(o -> o.getValue().getFreeSpace()));
    }
}
