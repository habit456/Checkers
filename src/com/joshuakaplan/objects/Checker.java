package com.joshuakaplan.objects;

import com.joshuakaplan.Color;
import com.joshuakaplan.utility.ConsoleColors;

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
        String display;

        if (color == Color.RED) {
            if (isKing) {
                display = "K";
            } else {
                display = "R";
            }

            return ConsoleColors.RED_BOLD + display + ConsoleColors.RESET;
        } else {
            if (isKing) {
                display = "K";
            } else {
                display = "B";
            }

            return ConsoleColors.CYAN_BOLD + display + ConsoleColors.RESET;
        }
    }
}
