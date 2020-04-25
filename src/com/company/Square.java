package com.company;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private Color color;
    private Position position;
    private Checker checker;

    public Square(Color color, Position position, Checker checker) {
        this.color = color;
        this.position = position;
        this.checker = checker;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Object getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public boolean isEmpty() {
        return checker == null;
    }

    @Override
    public String toString() {
        return isEmpty() ? " " : checker.toString();
    }
}
