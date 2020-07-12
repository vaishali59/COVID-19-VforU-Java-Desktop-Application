package application;

public interface MediatorInterface {
	
	public void notifyMediator(UI u, String event);
	public UI getNextUI();
	public UI getPreviousUI();
}
