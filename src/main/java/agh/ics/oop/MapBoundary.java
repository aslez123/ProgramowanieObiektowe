package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    public SortedSet<Vector2d > set_x = new TreeSet<>(Comparator.comparingInt(o -> o.x));
    public SortedSet<Vector2d > set_y = new TreeSet<>(Comparator.comparingInt(o -> o.y));
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        remove(oldPosition);
        add(newPosition);
    }
    public void add(Object obj) {
        if(obj instanceof Animal){
            add(((Animal) obj).getPosition());
        }
        if(obj instanceof Grass){
            add(((Grass) obj).getPosition());
        }
    }
    private void add(Vector2d pos) {
        set_x.add(pos);
        set_y.add(pos);
    }

    private void remove(Vector2d pos) {
        set_x.remove(pos);
        set_y.remove(pos);
    }

    public Vector2d getUpperRight() {
        return new Vector2d(set_x.last().x, set_y.last().y);
    }

    public Vector2d getLowerLeft() {
        return new Vector2d(set_x.first().x, set_y.first().y);
    }
}
