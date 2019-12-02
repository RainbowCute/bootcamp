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
                .map(token1 -> lotIdParkingLotMap.get(token1.getLotId()).take(token1))
                .orElseThrow(TakingFailException::new);
    }
}
