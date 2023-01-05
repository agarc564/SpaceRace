package cat.xtec.ioc.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

import cat.xtec.ioc.objects.Asteroid;
import cat.xtec.ioc.objects.ScrollHandler;
import cat.xtec.ioc.objects.Spacecraft;
import cat.xtec.ioc.utils.Settings;


public class GameScreen implements Screen {

    private Stage stage;
    private Spacecraft spacecraft;
    private ScrollHandler scrollHandler;
    // Representació de figures geomètriques
    private ShapeRenderer shapeRenderer;
    // Per obtenir el batch de l'stage
    private Batch batch;

    public GameScreen() {

        // Creem el ShapeRenderer
         shapeRenderer = new ShapeRenderer();
        // Creem la càmera de les dimensions del joc
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        // Posant el paràmetre a true configurem la càmera perquè
        // faci servir el sistema de coordenades Y-Down
        camera.setToOrtho(true);
        // Creem el viewport amb les mateixes dimensions que la càmera
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT , camera);

        // Creem l'stage
        stage = new Stage(viewport);
        //stage = new Stage();
        batch = stage.getBatch();

        // Creem la nau i la resta d'objectes
        spacecraft = new Spacecraft(Settings.SPACECRAFT_STARTX, Settings.SPACECRAFT_STARTY, Settings.SPACECRAFT_WIDTH, Settings.SPACECRAFT_HEIGHT);
        scrollHandler = new ScrollHandler();

        // Afegim els actors a l'stage
        stage.addActor(scrollHandler);
        stage.addActor(spacecraft);

    }

    private void drawElements(){

        /* 1 */
        // Pintem el fons de negre per evitar el "flickering"
        //Gdx.gl20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        //Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /* 2 */
        // Recollim les propietats del Batch de l'Stage
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        // Inicialitzem el shaperenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        /* 3 */
        // Definim el color (verd)
        shapeRenderer.setColor(new Color(0, 1, 0, 1));
        // Pintem la nau
        shapeRenderer.rect(spacecraft.getX(), spacecraft.getY(), spacecraft.getWidth(), spacecraft.getHeight());

        /* 4 */
        // Recollim tots els Asteroid
        ArrayList<Asteroid> asteroids = scrollHandler.getAsteroids();
        Asteroid asteroid;

        for (int i = 0; i < asteroids.size(); i++) {

            asteroid = asteroids.get(i);
            switch (i) {
                case 0:
                    shapeRenderer.setColor(1,0,0,1);
                    break;
                case 1:
                    shapeRenderer.setColor(0,0,1,1);
                    break;
                case 2:
                    shapeRenderer.setColor(1,1,0,1);
                    break;
                default:
                    shapeRenderer.setColor(1,1,1,1);
                    break;
            }
            shapeRenderer.circle(asteroid.getX() + asteroid.getWidth()/2, asteroid.getY() + asteroid.getWidth()/2, asteroid.getWidth()/2);
        }
        /* 5 */
        shapeRenderer.end();
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

        //drawElements();
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
