package pixelclient.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import pixelclient.mods.ModInstances;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class modgui extends GuiScreen {
    Color color;
    boolean enabled;
    boolean cancel = false;
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GuiHelper.drawPicture(this.width / 2 - 180, this.height / 2 - 90, 365, 190, "pixelclient/Menuler/Temalar/ModMenu1.png");
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
	}
	
	
    public boolean doesGuiPauseGame() {
        return false;
    }
}