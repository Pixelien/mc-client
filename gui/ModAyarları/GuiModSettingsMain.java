package pixelclient.gui.ModAyarları;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import pixelclient.RectTool;
import pixelclient.gui.hud.HUDManager;
import pixelclient.mods.ModInstances;

public class GuiModSettingsMain extends GuiScreen {
    ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
    boolean armorChecked = ModInstances.getModArmorStatus().isEnabled();
    boolean fpsChecked = ModInstances.getModFPS().isEnabled();
    boolean pingChecked = ModInstances.getModPing().isEnabled();
    boolean keystrokesChecked = ModInstances.getModKlavye().isEnabled();
    boolean XYZChecked = ModInstances.getModXYZ().isEnabled();
    boolean MiniPlayer = ModInstances.getModMiniPlayer().isEnabled();
    boolean iksirstat = ModInstances.getModiksir().isEnabled();
    boolean oksayı = ModInstances.getModOklar().isEnabled();
    boolean esyafizik = ModInstances.getModEsyaFizikleri().isEnabled();

    public GuiModSettingsMain() {
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(61, this.scaledResolution.getScaledWidth() / 2 + 100, this.scaledResolution.getScaledHeight() / 2 - 110, 20, 20, "✎"));
        this.buttonList.add(new GuiModButton(62, this.scaledResolution.getScaledWidth() / 2 - 120, this.scaledResolution.getScaledHeight() / 2 - 45, 70, 10, "Armor", ModInstances.getModArmorStatus(), new ResourceLocation("pixelclient/modlar/ArmorStatus.png")));
        this.buttonList.add(new GuiModButton(63, this.scaledResolution.getScaledWidth() / 2 - 45, this.scaledResolution.getScaledHeight() / 2 - 45, 70, 10, "FPS", ModInstances.getModFPS(), new ResourceLocation("pixelclient/modlar/Fps.png")));
        this.buttonList.add(new GuiModButton(64, this.scaledResolution.getScaledWidth() / 2 + 30, this.scaledResolution.getScaledHeight() / 2 - 45, 70, 10, "Ping", ModInstances.getModPing(), new ResourceLocation("pixelclient/modlar/ping.png")));
        this.buttonList.add(new GuiModButton(65, this.scaledResolution.getScaledWidth() / 2 - 120, this.scaledResolution.getScaledHeight() / 2 + 20, 70, 10, "Tuşlar", ModInstances.getModKlavye(), new ResourceLocation("pixelclient/modlar/Keystrokes.png")));
        this.buttonList.add(new GuiModButton(66, this.scaledResolution.getScaledWidth() / 2 - 45, this.scaledResolution.getScaledHeight() / 2 + 20, 70, 10, "Kordinatlar", ModInstances.getModXYZ(), new ResourceLocation("pixelclient/modlar/Xyz.png")));
        this.buttonList.add(new GuiModButton(67, this.scaledResolution.getScaledWidth() / 2 + 30, this.scaledResolution.getScaledHeight() / 2 + 20, 70, 10, "Ön izleme", ModInstances.getModMiniPlayer(), new ResourceLocation("pixelclient/modlar/Player.png")));
        this.buttonList.add(new GuiModButton(68, this.scaledResolution.getScaledWidth() / 2 - 120, this.scaledResolution.getScaledHeight() / 2 + 85, 70, 10, "İksir status", ModInstances.getModiksir(), new ResourceLocation("pixelclient/modlar/Potion.png")));
        this.buttonList.add(new GuiModButton(69, this.scaledResolution.getScaledWidth() / 2 - 45, this.scaledResolution.getScaledHeight() / 2 + 85, 70, 10, "Ok sayısı", ModInstances.getModOklar(), new ResourceLocation("pixelclient/modlar/Arrow.png")));
        this.buttonList.add(new GuiModButton(70, this.scaledResolution.getScaledWidth() / 2 + 30, this.scaledResolution.getScaledHeight() / 2 + 85, 70, 10, "Eşya Fizikleri", ModInstances.getModOklar(), new ResourceLocation("pixelclient/modlar/ItemDisplay.png")));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        if (button.id == 61) {
            HUDManager.getInstance().openConfigScreen();
        }

        if (button.id == 62) {
            this.armorChecked = !this.armorChecked;
            ModInstances.getModArmorStatus().setEnabled(this.armorChecked);
        }

        if (button.id == 63) {
            this.fpsChecked = !this.fpsChecked;
            ModInstances.getModFPS().setEnabled(this.fpsChecked);
        }

        if (button.id == 64) {
            this.pingChecked = !this.pingChecked;
            ModInstances.getModPing().setEnabled(this.pingChecked);
        }

        if (button.id == 65) {
            this.keystrokesChecked = !this.keystrokesChecked;
            ModInstances.getModKlavye().setEnabled(this.keystrokesChecked);
        }

        if (button.id == 66) {
            this.XYZChecked = !this.XYZChecked;
            ModInstances.getModXYZ().setEnabled(this.XYZChecked);
        }

        if (button.id == 67) {
            this.MiniPlayer = !this.MiniPlayer;
            ModInstances.getModMiniPlayer().setEnabled(this.MiniPlayer);
        }

        if (button.id == 68) {
            this.iksirstat = !this.iksirstat;
            ModInstances.getModiksir().setEnabled(this.iksirstat);
        }

        if (button.id == 69) {
            this.oksayı = !this.oksayı;
            ModInstances.getModOklar().setEnabled(this.oksayı);
        }
        
        if (button.id == 70) {
            this.esyafizik = !this.esyafizik;
            ModInstances.getModEsyaFizikleri().setEnabled(this.esyafizik);
        }


    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawDefaultBackground();
        RectTool.drawRoundedRect((double)(this.scaledResolution.getScaledWidth() / 2 - 130), (double)(this.scaledResolution.getScaledHeight() / 2 - 110), (double)(this.scaledResolution.getScaledWidth() / 2 - 130 + 250), (double)(this.scaledResolution.getScaledHeight() / 2 - 125 + 230), 5.0D, 1711276032);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}
