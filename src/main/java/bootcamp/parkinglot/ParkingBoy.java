package bootcamp.parkinglot;

import java.util.Map;
import java.util.Objects;

public class ParkingBoy {

    private Map<Integer, ParkingLot> lotIdParkingLotMap;

    public ParkingBoy(Map<Integer, ParkingLot> lotIdParkingLotMap) {
        this.lotIdParkingLotMap = lotIdParkingLotMap;
    }

    public Token park(Car car) {
        for (Integer lotId : lotIdParkingLotMap.keySet()) {
            ParkingLot parkingLot = lotIdParkingLotMap.get(lotId);
            Token token = parkingLot.park(lotId, car);
            if (Objects.nonNull(token)) {
                return token;
            }
        }
        return null;
    }

    public Car take(Token token) {
        ParkingLot parkingLot = lotIdParkingLotMap.get(token.getLotId());
        return parkingLot.take(token);
    }

}
