package br.com.debpay.entities;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
  CREDIT(1),
  DEBIT(2);

  private static Map<Integer, OperationType> map = new HashMap<>();

  static {
    for (OperationType type : OperationType.values()) {
      map.put(type.value, type);
    }
  }

  private int value;

  OperationType(int value) {
    this.value = value;
  }

  public static OperationType valueOf(int type) {
    return map.get(type);
  }

  public int getValue() {
    return value;
  }
}
