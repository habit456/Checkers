package com.joshuakaplan.objects;

import com.joshuakaplan.utility.Positions;

public class Position {
    String position;

    public Position(String position) {
        setPosition(position);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (Positions.isValid(position)) {
            this.position = position.toUpperCase();
        }
    }

    @Override
    public String toString() {
        return position;
    }

    public boolean equals(Position position) {
        return this.position.equals(position.position);
    }

    public boolean equals(String position) {
        return this.position.equals(position);
    }

    public String column() {
        return position.substring(0, 1);
    }

    public int row() {
        return Integer.parseInt(position.substring(1, 2));
    }
}
