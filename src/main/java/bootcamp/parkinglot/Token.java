package bootcamp.parkinglot;

import java.util.Objects;
import java.util.UUID;

public class Token {

    private Integer lotId;
    private String number;

    public Token() {
        this.lotId = 0;
        this.number = UUID.randomUUID().toString();
    }

    public Token(Integer lotId) {
        this.lotId = lotId;
        this.number = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(number, token.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getLotId() {
        return lotId;
    }
}
