package agh.ics.oop;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();
    Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {  // true jak pole jest zajęte
        return objectAt(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position) {
        return animalList.get(position);
    }

    @Override
    public void place(Animal animal) throws IllegalArgumentException {
        Vector2d position = animal.getPosition();
        if (!canMoveTo(position))
            throw new IllegalArgumentException("You can't place animal at: " + position.toString());

        animal.addObserver(this);
        animalList.put(position, animal);
}
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalList.remove(oldPosition);
        animalList.put(newPosition, animalList.get(oldPosition));
    }

    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        Vector2d[] bounds = setPrintBounds();
        return visualization.draw(bounds[0], bounds[1]);
    }

    abstract public Vector2d[] setPrintBounds();
}
