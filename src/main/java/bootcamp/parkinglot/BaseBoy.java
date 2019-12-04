package bootcamp.parkinglot;

import java.util.*;

public abstract class BaseBoy {

    protected Map<Integer, ParkingLot> lotIdParkingLotMap = new HashMap<>();

    public BaseBoy(List<ParkingLot> parkingLots) {
        if (Objects.nonNull(parkingLots)) {
            for (int i = 0; i < parkingLots.size(); i++) {
                lotIdParkingLotMap.put(i + 1, parkingLots.get(i));
            }
        }
    }

    protected abstract Optional<Map.Entry<Integer, ParkingLot>> getParkingLot();

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
                .map(token1 -> {
                    ParkingLot parkingLot = lotIdParkingLotMap.get(token1.getLotId());
                    if (Objects.isNull(parkingLot)) {
                        throw new TakingFailException("not have parking lot");
                    }
                    return parkingLot.take(token);
                })
                .orElseThrow(() -> new TakingFailException("ticket is invalid"));
    }
}
