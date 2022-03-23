package ez2java;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image yellowNoteImage = new ImageIcon(Main.class.getResource("../images/yellownoteimage.png")).getImage();
	private Image blueNoteImage = new ImageIcon(Main.class.getResource("../images/bluenoteimage.png")).getImage();
	private Image selectedNoteImage;
	
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean 	isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	
	private int x,y = 515 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	//x간 간격 ( 108, 168, 228, 288, 350, 414, 475 )
	
	public Note(String noteType) {
		if(noteType.equals("S") || noteType.equals("F") || noteType.equals("J") || noteType.equals("L"))
			selectedNoteImage = yellowNoteImage;
		else selectedNoteImage = blueNoteImage;
		
		if(noteType.equals("S")) x = 108;
		else if(noteType.equals("D")) x = 168;
		else if(noteType.equals("F")) x = 228;
		else if(noteType.equals("Space")) x = 288;
		else if(noteType.equals("J")) x = 350;
		else if(noteType.equals("K")) x = 414;
		else if(noteType.equals("L")) x = 475;
		
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
			g.drawImage(selectedNoteImage, x, y, null);
	}
	
	public void drop() {
		y  += Main.NOTE_SPEED;
		if(y > 620) {
			close();
		}
	}
	
	@Override //노트 사이에 휴식 (렉)
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
					}
				}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		
		if( y >= 560 ) {
			close();
			return "Late";
		}
		
		else if( y >= 541) {
			close();
			return "Good";
		}
		
		else if( y >= 528 ) {
			close();
			return "Great";
		}
		
		else if( y >= 515 ) {
			close();
			return "Perfect";
		}
		
		else if( y >= 502 ) {
			close();
			return "Great";
		}
		
		else if( y >= 489 ) {
			close();
			return "Good";
		}
		
		else if( y >= 476 ) {
			close();
			return "Early";
		}
		return "None";
		
	}

	public int getY() {
		return y;
	}


}
