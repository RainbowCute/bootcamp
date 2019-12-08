package bootcamp.parkinglot;

import bootcamp.parkinglot.boy.BaseWorker;
import bootcamp.parkinglot.exception.TakingFailException;

import java.util.*;

public class ParkingManager extends BaseWorker {

    private List<BaseWorker> boys = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public void hire(BaseWorker baseBoy) {
        boys.add(baseBoy);
    }

    @Override
    public Optional<Map.Entry<Integer, ParkingLot>> getParkingLot() {
        Optional<BaseWorker> firstBoy = boys.stream().filter(baseBoy -> !baseBoy.isFull()).findFirst();
        if (firstBoy.isPresent()) {
            return firstBoy.get().getParkingLot();
        }
        if (!super.isFull()) {
            return lotIdParkingLotMap.entrySet().stream()
                    .filter(entry -> !entry.getValue().isFull()).min(Comparator.comparingInt(Map.Entry::getKey));
        }
        return Optional.empty();
    }

    @Override
    public Car take(Token token) {
        for (BaseWorker boy : boys) {
            try {
                return boy.take(token);
            } catch (TakingFailException ignored) {
            }
        }
        return super.take(token);
    }
}
