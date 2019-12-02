package bootcamp.length;

public class Length<T extends Comparable>{
    private T value;

    public Length(T value) {
        this.value = value;
    }

    private T getValue() {
        return value;
    }

    int compareTo(Length o) {
        return value.compareTo(o.getValue());
    }
}
