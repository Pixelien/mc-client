package pixelclient.gui.hud;

public interface IRenderer extends IRenderConfig {

	int keyHoldTicks = 0;
	boolean flyBoost = false;
	float flyBoostFactor = 0;

	int getWidth();
	int getHeight();
	
	void render(ScreenPosition pos);
	
	default void renderDummy(ScreenPosition pos) {
		render(pos);
	}

	public default boolean isEnabled() {
		return true;
	}
}
