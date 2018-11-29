import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	public ObjectManager(RocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}
	
	void update() {
		rocketShip.update();
		for (int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}
	
	void draw(Graphics g) {
		rocketShip.draw(g);
		for (int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien(Alien alien) {
		aliens.add(alien);
	}
}
