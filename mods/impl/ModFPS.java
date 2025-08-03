package pixelclient.mods.impl;

import pixelclient.gui.hud.ScreenPosition;
import pixelclient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;

public class ModFPS extends ModDraggable {
	
    public boolean chroma = false;

    public ModFPS() {
    }

    public int getWidth() {
        return this.font.getStringWidth("000 FPS5");
    }

    public int getHeight() {
        return this.font.FONT_HEIGHT + 1;
    }

    public void render(ScreenPosition pos) {
                this.font.drawString(Minecraft.getDebugFPS() + " FPS", pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 2, -1);
            }

    public void renderDummy(ScreenPosition pos) {
        this.font.drawString("120 FPS", pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 2, -1);
    }
}
