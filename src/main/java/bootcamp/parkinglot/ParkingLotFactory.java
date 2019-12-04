package bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFactory {


//    public static Map<Integer, ParkingLot> create(int parkingLotNum, int parkingLotCapacity) {
//        Map<Integer, ParkingLot> lotIdParkingLotMap = new HashMap<>();
//        for (int i = 0; i < parkingLotNum; i++) {
//            lotIdParkingLotMap.put(i, new ParkingLot(parkingLotCapacity));
//        }
//        return lotIdParkingLotMap;
//    }

    public static List<ParkingLot> create(int parkingLotNum, int parkingLotCapacity) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < parkingLotNum; i++) {
            parkingLots.add(new ParkingLot(parkingLotCapacity));
        }
        return parkingLots;
    }
}
