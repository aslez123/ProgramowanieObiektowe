package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    int x;
    int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other) {
        return (other.x >= this.x) && (other.y >= this.y);
    }

    public boolean follows(Vector2d other) {
        return (other.x <= this.x) && (other.y <= this.y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(other.x + this.x, other.y + this.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(other.x - this.x, other.y - this.y);
    }

    public Vector2d upperRight(Vector2d other) {
        if (this.y > other.y) {
            if (this.x > other.x) {
                return new Vector2d(this.x, this.y);
            } else {
                return new Vector2d(other.x, this.y);
            }
        } else {
            if (this.x > other.x) {
                return new Vector2d(this.x, other.y);
            } else {
                return new Vector2d(other.x, other.y);
            }
        }
    }

    public Vector2d lowerLeft(Vector2d other) {
        if (this.y < other.y) {
            if (this.x < other.x) {
                return new Vector2d(this.x, this.y);
            } else {
                return new Vector2d(other.x, this.y);
            }
        } else {
            if (this.x < other.x) {
                return new Vector2d(this.x, other.y);
            } else {
                return new Vector2d(other.x, other.y);
            }
        }
    }

    public Vector2d opposite() {
        return new Vector2d(this.y, this.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;

        Vector2d new_other = (Vector2d) other;
        return this.x == new_other.x && this.y == new_other.y;
    }
}
