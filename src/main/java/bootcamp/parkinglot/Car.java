package bootcamp.parkinglot;

import java.util.Objects;

public class Car {
    String carNumber;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public Car() {
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}
