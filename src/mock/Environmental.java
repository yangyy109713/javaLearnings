package mock;

public abstract class Environmental {
	boolean playedWav = false;
	public abstract long getTime();
	public abstract boolean wavWasPlayed();
	public abstract void resetWav();
}
