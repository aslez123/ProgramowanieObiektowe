package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;

public abstract class World {
    public static void main(String[] args){

        try {
            MapBoundary mapBoundary = new MapBoundary();
            GrassField grassMap = new GrassField(mapBoundary,7);
            grassMap.add_grass();
            System.out.println(mapBoundary.set_x);
            System.out.println(mapBoundary.set_y);
            List<Direction> directions = OptionsParser.parse(/*new String[]{"f", "b", "f"}*/ args);
            List<Vector2d> positions = List.of(new Vector2d(3, 4), new Vector2d(1, 4));
            SimulationEngine engine = new SimulationEngine(directions, grassMap, positions);
            grassMap.animalList = engine.run();
            System.out.println(grassMap.toString());
            Application.launch(App.class, args);
        } catch (IllegalArgumentException e){
            System.out.println("incorrect input, " + e.getMessage());
        }
    }
}

//wykorzystujemy gradle żeby zaciągnąć java fx
//wyświetlenie: ten sam typ, nie zależy,
// dodajemy elementy odświżamy

//lab 8 jest podzielone na 2 czescie
//1: konsolowa nie jest specjalnie skomplikowana ale dużo daje
//WĄTKI: grafika ma dużo pikseli ale funkcje zbyt długo przetwarzają to ale w takiej jednowątkowej sytuacji i to długo trwa
// w sytuacji wielowątkowej to się liczy w tle w osobnym wątku a my jesteśmy w głównym wątku
//możemy dać kilka parametrów i możemy obserwować jak zwirzaki się zachowują
//z wątkiem mogą sie różne rzeczy podziać więc wrzucamy go do try catch
//2: rozszerzenie graficzne
//wykorzystamy folder source od pola, możemy pobrać obrazki albo wymienic w source obrazek i on bedzie zamieniony
//

//robie najpierw wstawienie później usunięcie a ma być odwrotnie, przy przesunięciu usuniecie włożenie
//abstract word map possition change