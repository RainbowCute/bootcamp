package bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {

    private int capacity;
    private int freeSpace;
    private Map<Token, Car> tokenCarMap = new HashMap<>();

    public ParkingLot(int size) {
        this.capacity = size;
        this.freeSpace = this.capacity;
    }

    public Token park(Car car) {
        return park(0, car);
    }

    public Car take(Token token) {
        if (Objects.isNull(token)) {
            throw new TakingFailException("ticket is invalid");
        }
        Car car = tokenCarMap.get(token);
        if (Objects.nonNull(car)) {
            tokenCarMap.remove(token);
            ++freeSpace;
            return car;
        }
        throw new TakingFailException("ticket is invalid");
    }

    public Token park(Integer lotId, Car car) {
        if (Objects.isNull(car) || freeSpace == 0) {
            throw new ParkingFailException();
        }
        --freeSpace;
        Token token = new Token(lotId);
        tokenCarMap.put(token, car);
        return token;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }
}
