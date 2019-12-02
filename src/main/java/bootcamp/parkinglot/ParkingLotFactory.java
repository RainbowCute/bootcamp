package bootcamp.parkinglot;

import java.util.*;

public class ParkingLotFactory {
    private static Map<Integer, ParkingLot> lotIdParkingLotMap = new HashMap<>();

    public static Map<Integer, ParkingLot> create(int parkingLotNum, int parkingLotCapacity) {
        for (int i = 0; i < parkingLotNum; i++) {
            lotIdParkingLotMap.put(i, new ParkingLot(parkingLotCapacity));
        }
        return lotIdParkingLotMap;
    }


}
