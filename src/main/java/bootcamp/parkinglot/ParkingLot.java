package bootcamp.parkinglot;

import bootcamp.parkinglot.exception.ParkingFailException;
import bootcamp.parkinglot.exception.TakingFailException;

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

    public Car take(Token token) {
        if (Objects.isNull(token)) {
            throw new TakingFailException();
        }
        Car car = tokenCarMap.get(token);
        if (Objects.nonNull(car)) {
            tokenCarMap.remove(token);
            ++freeSpace;
            return car;
        }
        throw new TakingFailException();
    }

    public Token park(Car car) {
        return park(0, car);
    }

    public Token park(int lotId, Car car) {
        if (Objects.isNull(car) || freeSpace == 0) {
            throw new ParkingFailException();
        }
        --freeSpace;
        Token token = new Token(lotId);
        tokenCarMap.put(token, car);
        return token;
    }

    public boolean isFull() {
        return freeSpace == 0;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public Double getFreeSpaceRate() {
        if (capacity == 0) {
            return 0.0;
        }
        return (freeSpace + 0.0) / capacity;
    }
}
