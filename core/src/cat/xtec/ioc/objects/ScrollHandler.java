package cat.xtec.ioc.objects;


import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

public class ScrollHandler extends Group {
    // Fons de pantalla
    Background bg, bg_back;

    // Asteroides
    int numAsteroids;
    ArrayList<Asteroid> asteroids;

    // Objecte random
    Random r;

    public ScrollHandler() {
    }
}
