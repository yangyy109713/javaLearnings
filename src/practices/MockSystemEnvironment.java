package practices;

public class MockSystemEnvironment extends Environmental{
	private long currentTime;
	
	@Override
	public long getTime() {
		return currentTime;
	}
	
	public void setTime(long currentTime){
		this.currentTime = currentTime;
	}
	
	public void playedWavFile(String fileName){
		playedWav = true;
	}
	
	@Override
	public boolean wavWasPlayed() {
		return playedWav;
	}
	@Override
	public void resetWav() {
		playedWav = false;
	}
}