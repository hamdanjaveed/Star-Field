package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

/**
 * User: hamdan
 * Date: 2013-06-06
 * Time: 6:33 PM
 */
public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		initDisplay();
		initGL();
		programLoop();
	}

	private void initDisplay() {
		// create the display
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Star field");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}

	private void initGL() {
		// edit projection matrix
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(70.0f, 800.0f / 600.0f, 0.001f, 100.0f);
		// go back to model matrix
		glMatrixMode(GL_MODELVIEW);
	}

	private void programLoop() {
		while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Display.update();
			Display.sync(60);
		}
		exitProgram();
	}

	private void exitProgram() {
		Display.destroy();
		System.exit(0);
	}

}
