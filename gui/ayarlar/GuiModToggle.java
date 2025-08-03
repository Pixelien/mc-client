package pixelclient.gui.ayarlar;

import java.io.IOException;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiModToggle extends GuiScreen {
    private ScrollListModToggle scrollPanel;

    public GuiModToggle() {
    }

    public void initGui() {
        this.scrollPanel = new ScrollListModToggle(this.mc, this);
        this.buttonList.clear();
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.scrollPanel.handleMouseInput();
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.scrollPanel.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.scrollPanel.mouseReleased(mouseX, mouseY, state);
        super.mouseReleased(mouseX, mouseY, state);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution scaledRes = new ScaledResolution(this.mc);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("pixelclient/mainmenu.png"));
        drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, scaledRes.getScaledWidth(), scaledRes.getScaledHeight(), scaledRes.getScaledWidth(), scaledRes.getScaledHeight(), (float)scaledRes.getScaledWidth(), (float)scaledRes.getScaledHeight());
        this.scrollPanel.drawScreen(mouseX, mouseY, partialTicks);
        this.drawCenteredString(this.fontRendererObj, "Mod Ayarlarý", this.width / 2, 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public boolean doesGuiPauseGame() {
        return true;
    }
}
