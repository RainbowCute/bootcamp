package bootcamp.parkinglot;

import java.util.*;

public class SmartParkingBoy {

    private Map<Integer, ParkingLot> lotIdParkingLotMap = new HashMap<>();

    public Token park(Car car) {
        Optional<Map.Entry<Integer, ParkingLot>> maxFreeSpaceParkingLot = lotIdParkingLotMap.entrySet().stream()
                .max(Comparator.comparingInt(o -> o.getValue().getFreeSpace()));
        return maxFreeSpaceParkingLot.map(entry -> {
            Integer lotId = maxFreeSpaceParkingLot.get().getKey();
            ParkingLot parkingLot = maxFreeSpaceParkingLot.get().getValue();
            return parkingLot.park(lotId, car);
        }).orElseThrow(ParkingFailException::new);
    }

    public void addParkingLot(int lotId, ParkingLot parkingLot) {
        lotIdParkingLotMap.put(lotId, parkingLot);
    }

    public Car take(Token token) {
        return Optional.ofNullable(token)
                .map(token1 -> {
                    ParkingLot parkingLot = lotIdParkingLotMap.get(token1.getLotId());
                    if(Objects.isNull(parkingLot)){
                        throw new TakingFailException("not have parking lot");
                    }
                    return parkingLot.take(token);
                })
                .orElseThrow(() -> new TakingFailException("ticket is invalid"));
    }
}
