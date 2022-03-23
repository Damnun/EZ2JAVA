// 곡의 대한 정보를 담은 클래스
// 표지 제목 음악파일

package ez2java;

public class Track {

	private String TitleImage; // 제목 부분 이미지
	private String startImage; // 게임 선택 창 표지 이미지
	private String gameImage; // 인게임 이미지
	
	private String startMusic; // 게임 선택 창 음악
	private String gameMusic; // 인게임 음악
	private String titleName; // 곡 제목
	
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
