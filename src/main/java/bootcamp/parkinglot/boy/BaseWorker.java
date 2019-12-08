package bootcamp.parkinglot.boy;

import bootcamp.parkinglot.Car;
import bootcamp.parkinglot.exception.ParkingFailException;
import bootcamp.parkinglot.ParkingLot;
import bootcamp.parkinglot.exception.TakingFailException;
import bootcamp.parkinglot.Token;

import java.util.*;

public abstract class BaseWorker {

    protected Map<Integer, ParkingLot> lotIdParkingLotMap = new HashMap<>();

    public BaseWorker(List<ParkingLot> parkingLots) {
        if (Objects.nonNull(parkingLots)) {
            for (int i = 0; i < parkingLots.size(); i++) {
                lotIdParkingLotMap.put(i + 1, parkingLots.get(i));
            }
        }
    }

    public abstract Optional<Map.Entry<Integer, ParkingLot>> getParkingLot();

    public Token park(Car car) {
        Optional<Map.Entry<Integer, ParkingLot>> entry = getParkingLot();
        if (!entry.isPresent()) {
            throw new ParkingFailException();
        }
        Integer lotId = entry.get().getKey();
        ParkingLot parkingLot = entry.get().getValue();
        return parkingLot.park(lotId, car);
    }

    public Car take(Token token) {
        return Optional.ofNullable(token)
                .map(tokenByTake -> {
                    ParkingLot parkingLot = lotIdParkingLotMap.get(tokenByTake.getLotId());
                    if (Objects.isNull(parkingLot)) {
                        throw new TakingFailException();
                    }
                    return parkingLot.take(tokenByTake);
                })
                .orElseThrow(() -> new TakingFailException());
    }

    public boolean isFull(){
        return lotIdParkingLotMap.values().stream().allMatch(ParkingLot::isFull);
    }

}
