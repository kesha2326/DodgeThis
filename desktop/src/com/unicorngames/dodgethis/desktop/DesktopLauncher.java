package com.unicorngames.dodgethis.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.unicorngames.dodgethis.DodgeThis;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = DodgeThis.WIDTH;
		config.height = DodgeThis.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new DodgeThis(), config);
	}
}
