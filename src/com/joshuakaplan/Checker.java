package com.joshuakaplan;

public class Checker {
    private Color color;
    private boolean isKing;

    public Checker(Color color, boolean isKing) {
        this.color = color;
        this.isKing = isKing;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void king() {
        isKing = true;
    }

    @Override
    public String toString() {
        if (color == Color.RED) {
            return "R";
        } else {
            return "B";
        }
    }
}
