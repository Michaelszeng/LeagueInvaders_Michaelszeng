import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	final int width = 500;
	final int height = 800;
	
	JFrame window;
	
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
	
	public LeagueInvaders() {
		window = new JFrame();
	}
	
	void setup() {
		window.add(new GamePanel());
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.pack();
	}
	
}
