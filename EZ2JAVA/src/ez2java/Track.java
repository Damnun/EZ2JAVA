// ���� ���� ������ ���� Ŭ����
// ǥ�� ���� ��������

package ez2java;

public class Track {

	private String TitleImage; // ���� �κ� �̹���
	private String startImage; // ���� ���� â ǥ�� �̹���
	private String gameImage; // �ΰ��� �̹���
	
	private String startMusic; // ���� ���� â ����
	private String gameMusic; // �ΰ��� ����
	private String titleName; // �� ����
	
	public String getTitleImage() {
		return TitleImage;
	}
	public void setTitleImage(String titleImage) {
		TitleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
		super();
		TitleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}

	
}
