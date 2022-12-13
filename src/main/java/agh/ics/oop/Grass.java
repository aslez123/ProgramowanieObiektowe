package agh.ics.oop;

import agh.ics.oop.gui.IMapElement;

public class Grass implements IMapElement {
    public Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String getName() {
        return "Trawa";
    }

    public String toString(){
        return "*";
    }
}