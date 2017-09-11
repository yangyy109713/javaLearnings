package practices;

public class SystemEnvironment extends Environmental {
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	public void playWavFile(String fileName){
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
