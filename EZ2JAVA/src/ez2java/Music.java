package ez2java;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread { //Thread > 하나의 작은 프로그램  (곡을 재생해주는)

	private Player player;
	private boolean isLoop; //곡의 반복 여부
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // 쓰레드를 종료해줌
	}

	@Override
	public void run() {
		try { 
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
