import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	final static int width = 500;
	final static int height = 800;
	GamePanel gamepanel;
	
	JFrame window;
	
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
	
	public LeagueInvaders() {
		window = new JFrame();
		gamepanel = new GamePanel();
	}
	
	void setup() {
		window.add(gamepanel);
		window.addKeyListener(gamepanel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.pack();
		
		gamepanel.startGame();
	}
	
}
