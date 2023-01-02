package cat.xtec.ioc.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import cat.xtec.ioc.objects.ScrollHandler;
import cat.xtec.ioc.objects.Spacecraft;
import cat.xtec.ioc.utils.Settings;


public class GameScreen implements Screen {

    private Stage stage;
    private Spacecraft spacecraft;
    private ScrollHandler scrollHandler;

    public GameScreen() {

        // Creem l'stage
        stage = new Stage();

        // Creem la nau i la resta d'objectes
        spacecraft = new Spacecraft(Settings.SPACECRAFT_STARTX, Settings.SPACECRAFT_STARTY, Settings.SPACECRAFT_WIDTH, Settings.SPACECRAFT_HEIGHT);
        scrollHandler = new ScrollHandler();

       // Afegim els actors a l'stage
        stage.addActor(scrollHandler);
        stage.addActor(spacecraft);

    }

    @Override
    public void show() {

    }

    public Stage getStage() {
        return stage;
    }

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    @Override
    public void render(float delta) {
        /*Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/
        // Dibuixem i actualitzem tots els actors de l'stage
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
