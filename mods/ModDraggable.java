package pixelclient.mods;

import java.io.File;

import pixelclient.FileManager;
import pixelclient.gui.hud.IRenderer;
import pixelclient.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer {
	
	protected ScreenPosition pos;
	
	public ModDraggable() {
		pos = loadPositionFromFile();
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		savePositionToFile();
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}
	
	private File getFolder() {
		File folder = new File(FileManager.getModsDirectory(), getClass().getSimpleName());
		folder.mkdirs();
		return folder;
	}
	
	private void savePositionToFile() {
		FileManager.writeJsonToFile(new File(getFolder(), "Pozisyon.json"), pos);
		
	}
	
	private ScreenPosition loadPositionFromFile() {
		
		ScreenPosition loaded = FileManager.readFromJson(new File(getFolder(), "Pozisyon.json"), ScreenPosition.class);
		
		if(loaded == null) {
			loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
			this.pos = loaded;
			savePositionToFile();
		}
		
		return loaded;
		
	}
	
	public final int getLineOffset(ScreenPosition pos, int lineNum) {
		return pos.getAbsoluteY() + getLineOffset(lineNum);	
	}
	
	private int getLineOffset(int lineNum) {
		return (font.FONT_HEIGHT + 3) * lineNum;
	}

}
