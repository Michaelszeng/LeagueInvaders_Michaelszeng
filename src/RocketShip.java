import java.awt.Color;

public class RocketShip extends GameObject{
	
	public RocketShip(x, y, width , height) {
		super(x, y, widht, height);
	}
	
	update() {
		
	}
	
	draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
}
