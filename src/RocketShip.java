import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;
	boolean up, down, right, left = false;

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		if (right) {
			x += speed;
		}
		if (left) {
			x -= speed;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
