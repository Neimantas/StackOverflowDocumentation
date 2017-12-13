package models.enums;

public enum Languages {
    Java(5),
    Csharp(4),
    JavaScript(8),
    Swift(16);
    private final int value;

    Languages(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
