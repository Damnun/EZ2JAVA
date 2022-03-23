package ez2java;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EZ2JAVA extends JFrame{

	private int token = 1;
	private Image screenImage;
	private Graphics screenGraphics;

	private Image background = new ImageIcon(Main.class.getResource("../images/TitleBackground.png")).getImage();


	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/leftbutton.png"));
	private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getResource("../images/leftbuttonentered.png"));
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/rightbutton.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getResource("../images/rightbuttonentered.png"));
	private ImageIcon exitButtonBasic = new ImageIcon(Main.class.getResource("../images/exitbutton.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(Main.class.getResource("../images/enteredexitbutton.png"));
	private ImageIcon startButton = new ImageIcon(Main.class.getResource("../images/gamestartbutton.png"));
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../images/gamestartbuttonentered.png"));

	private boolean isMainScreen = false; // 메인화면에서는 false
	private boolean isGameScreen = false;

	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton gameStartButton = new JButton(startButton);

	ArrayList<Track> trackList = new ArrayList<Track>();

	Music introMusic = new Music("introMusic.mp3", true);

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;

	public static Game game; //프로젝트 전체에서 통용되는 하나의 변수여서 static화

	public EZ2JAVA() {
		
		trackList.add(new Track("saythatyoutitle.png", "saythatyoubg.png",
				"saythatyouingamebg.png", "saythatyouhighlight.mp3", "saythatyou.mp3", "Say that you"));

		trackList.add(new Track("whitemoontitle.png", "whitemoonbg.png",
				"whitemooningamebg.png", "whitemoonhighlight.mp3", "whitemoon.mp3", "White moon"));

		trackList.add(new Track("nightmadnesstitle.png", "nightmadnessbg.png",
				"nightmadnessingamebg.png", "nightmadnesshighlight.mp3", "nightmadness.mp3", "Night madness"));
		
		
		setUndecorated(true); // 처음엔 보이지 않게
		this.setTitle("EZ2JAVA");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 화면 정중앙에 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0)); //paintcomponents시 배경색 하얗게
		setLayout(null); // button,label을 절대위치에 지정해주기 위함

		addKeyListener(new KeyboardListener() );

		introMusic.start();

		exitButton.setVisible(false);
		exitButton.setBounds(1200, 630, 60, 60);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEntered);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);



		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEntered);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftButton);


		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEntered);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
				selectRight();
			}
		});
		add(rightButton);


		gameStartButton.setVisible(false);
		gameStartButton.setBounds(510, 580, 250, 67);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);
		gameStartButton.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				gameStartButton.setIcon(startButtonEntered);
				gameStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameStartButton.setIcon(startButton);
				gameStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
				gameStart(nowSelected);
			}
		});
		add(gameStartButton);

		
		addKeyListener(new KeyListener() { // 스페이스키를 누르면 메인화면으로 진행
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				if(token == 1) {
					switch (keycode) {
					case KeyEvent.VK_ESCAPE: System.exit(0);
					case KeyEvent.VK_SPACE: enterMain(); token++; break;			
					}
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});


		requestFocus();
		setFocusable(true);


	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // add되지 않은 이미지를 보여줌 역동적인 이미지(동적)는 drawImage로
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen)
		{
			game.screenDraw(g);
		}
		paintComponents(g); // 메인 화면에 추가된 요소를 보여줌 (add), 단순한, 정지된, 정적인 이미지 는 paintComponents로
		try {
			Thread.sleep(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.repaint();
	}

	public void selectedTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close(); 
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if(nowSelected == 0) nowSelected = trackList.size() - 1;
		else nowSelected--;
		selectedTrack(nowSelected);
	}

	public void selectRight() {
		if(nowSelected == trackList.size() - 1) nowSelected = 0;
		else nowSelected++;
		selectedTrack(nowSelected);
	}

	public void gameStart(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		gameStartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}

	public void enterMain() {
		gameStartButton.setVisible(true);
		exitButton.setVisible(true); 
		isMainScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/selectbg.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		introMusic.close();
		selectedTrack(0);
	}
}

