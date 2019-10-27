package br.com.debpay.Entities;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    CREDIT(1),
    DEBIT(2);

    private int value;
    private static Map<Integer, OperationType> map = new HashMap<>();

    OperationType(int value) {
        this.value = value;
    }

    static {
        for (OperationType type : OperationType.values()) {
            map.put(type.value, type);
        }
    }

    public static OperationType valueOf(int type) {
        return map.get(type);
    }

    public int getValue() {
        return value;
    }
}
