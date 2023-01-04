package cat.xtec.ioc;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import cat.xtec.ioc.SpaceRace;
import cat.xtec.ioc.utils.Settings;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("spacerace");
		config.setWindowedMode(Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT * 2);
		//config.width = Settings.GAME_WIDTH * 2;
		//config.height = Settings.GAME_HEIGHT * 2;
		new Lwjgl3Application(new SpaceRace(), config);
	}
}
