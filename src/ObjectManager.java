import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;

	public ObjectManager(RocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}

	void update() {
		rocketShip.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}

	void draw(Graphics g) {
		rocketShip.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocketShip.collisionBox.intersects(a.collisionBox)) {
				rocketShip.isAlive = false;
			} else {
				for (Projectile p : projectiles) {
					if (p.collisionBox.intersects(a.collisionBox)) {
						a.isAlive = false;
						p.isAlive = false;
						score++;
					}
				}
			}
		}
	}

	public int getScore() {
		return score;
	}
}
