import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font normalFont;
	RocketShip rocketShip = new RocketShip(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocketShip);

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Ubuntu", Font.BOLD, 56);
		normalFont = new Font("Ubuntu", Font.PLAIN, 24);
	}

	void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Invaders", LeagueInvaders.width / 28, (int) (LeagueInvaders.height * 0.25));
		g.setFont(normalFont);
		g.drawString("Press ENTER To Start", LeagueInvaders.width / 4, (int) (LeagueInvaders.height * 0.625));
		g.drawString("Press SPACE For Instructions", LeagueInvaders.width / 6, (int) (LeagueInvaders.height * 0.75));
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}
		
		if (currentState==GAME_STATE) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
				rocketShip.up = true;
			}
			else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				rocketShip.down = true;
			}
			else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				rocketShip.right = true;
			}
			else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				rocketShip.left = true;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Projectile projectile = new Projectile(rocketShip.x+rocketShip.width/2-5, rocketShip.y, 10, 10);
			objectManager.addProjectile(projectile);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			rocketShip.up = false;
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocketShip.down = false;
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocketShip.right = false;
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocketShip.left = false;
		}
	}
}
