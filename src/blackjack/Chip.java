package blackjack;

import java.io.Serializable;

public class Chip implements Serializable {
    private int quantity;
    private Value value;

    public Chip(int cantidad, Value value) {
        this.quantity = cantidad;
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int cantidad) {
        this.quantity = cantidad;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Chips " +
                "value of the chip: " + value +
                " total quantity: " + quantity +
                ']';
    }
}
