package cat.xtec.ioc.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import cat.xtec.ioc.utils.Settings;

public class Spacecraft extends Actor {
    // Diferents posicions de l'Spacecraft: recta, pujant i baixant
    public static final int SPACECRAFT_STRAIGHT = 0;
    public static final int SPACECRAFT_UP = 1;
    public static final int SPACECRAFT_DOWN = 2;

    // Paràmetres de l'Spacecraft
    private Vector2 position;
    private int width, height;
    private int direction;

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getDirection() {
        return direction;
    }

    public Spacecraft(float x, float y, int width, int height) {

// Inicialitzem els arguments segons la crida del constructor
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

// Inicialitzem l'Spacecraft a l'estat normal
        direction = SPACECRAFT_STRAIGHT;

    }

    public void act(float delta) {

// Movem l'Spacecraft depenent de la direcció controlant que no surti de la pantalla
        switch (direction) {
            case SPACECRAFT_UP:
                if (this.position.y - Settings.SPACECRAFT_VELOCITY * delta >= 0) {
                    this.position.y -= Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_DOWN:
                if (this.position.y + height + Settings.SPACECRAFT_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_STRAIGHT:
                break;
        }
    }
}
