package blackjack;

public enum Value {
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Value getValue(int value) {
        for (Value v : Value.values()) {
            if (v.getValue() == value) {
                return v;
            }
        }
        return null;
    }
}
