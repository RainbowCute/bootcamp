package bootcamp.length;

public class LengthComparator<T extends Comparable> {

    public int compare(Length<T> var1, Length<T> var2) {
        return var1.compareTo(var2);
    }
}
