package ez2java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(EZ2JAVA.game == null) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			EZ2JAVA.game.pressS();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"S\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			EZ2JAVA.game.pressD();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"D\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			EZ2JAVA.game.pressF();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"F\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			EZ2JAVA.game.pressSpace();
			new Music("drumBig3.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"Space\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			EZ2JAVA.game.pressJ();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"J\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			EZ2JAVA.game.pressK();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"K\"),");
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			EZ2JAVA.game.pressL();
			new Music("drumSmall1.mp3", false).start();
			System.out.println("new Beat(" + EZ2JAVA.game.getGameMusic().getTime() + ", \"L\"),");
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(EZ2JAVA.game == null) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			EZ2JAVA.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			EZ2JAVA.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			EZ2JAVA.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			EZ2JAVA.game.releaseSpace();	
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			EZ2JAVA.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			EZ2JAVA.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			EZ2JAVA.game.releaseL();
		}
	}

}
