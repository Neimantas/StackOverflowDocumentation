package models.enums;

public enum Languages {
    Java(5),
    Csharp(1),
    JavaScript(2),
    PHP(3),
    Rubby(4);
    private final int value;

    Languages(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
