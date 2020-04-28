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
        if (color == Color.RED) {
            return ConsoleColors.RED_BOLD + "R" + ConsoleColors.RESET;
        } else {
            return ConsoleColors.CYAN_BOLD + "B" + ConsoleColors.RESET;
        }
    }
}
