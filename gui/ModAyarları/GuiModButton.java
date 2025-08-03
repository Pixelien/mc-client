package pixelclient.gui.ModAyarlarý;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import pixelclient.RectTool;
import pixelclient.mods.Mod;

public class GuiModButton extends GuiButton {
    boolean modName;
    ResourceLocation icon;
    int scrollTotal = 1;
    int boxColor;

    private int getScrollAmount() {
        int i = Mouse.getEventDWheel();
        if (i != 0) {
            if (i > 1) {
                --this.scrollTotal;
            }

            if (i < -1) {
                ++this.scrollTotal;
            }

            if (this.scrollTotal > 30) {
                this.scrollTotal = 30;
            }

            if (this.scrollTotal < -10) {
                this.scrollTotal = -10;
            }
        }

        return this.scrollTotal;
    }

    public GuiModButton(int buttonId, int x, int y, int width, int height, String buttonText, Mod mod, ResourceLocation resourceLocation) {
        super(buttonId, x, y, width, height, buttonText);
        this.icon = resourceLocation;
        this.modName = mod.isEnabled();
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        FontRenderer fontrenderer = mc.fontRendererObj;
        if (this.modName) {
            this.boxColor = Color.green.getRGB();
        }

        if (!this.modName) {
            this.boxColor = Color.gray.getRGB();
        }

        RectTool.drawRoundedRect((double)this.xPosition, (double)(this.yPosition - this.getScrollAmount() - this.height * 5), (double)(this.xPosition + this.width), (double)(this.yPosition - this.getScrollAmount() + 10), 5.0D, 1996488704);
        RectTool.drawBorderedRoundedRect((float)this.xPosition, (float)(this.yPosition - this.getScrollAmount()), (float)(this.xPosition + this.width), (float)(this.yPosition - this.getScrollAmount() + this.height), 5.0F, 1711276032, this.boxColor);
        mc.getTextureManager().bindTexture(this.icon);
        Gui.drawScaledCustomSizeModalRect(this.xPosition + 15, this.yPosition - this.getScrollAmount() - 50, 40.0F, 40.0F, 40, 40, 40, 40, 40.0F, 40.0F);
        int outlineColour = 156587349;
        this.drawHorizontalLine(this.xPosition, this.xPosition + this.width, this.yPosition - this.getScrollAmount(), outlineColour);
        this.drawHorizontalLine(this.xPosition, this.xPosition + this.width, this.yPosition - this.getScrollAmount() + this.height, outlineColour);
        this.drawVerticalLine(this.xPosition, this.yPosition - this.getScrollAmount() + this.height, this.yPosition - this.getScrollAmount(), outlineColour);
        this.drawVerticalLine(this.xPosition + this.width, this.yPosition - this.getScrollAmount() + this.height, this.yPosition - this.getScrollAmount(), outlineColour);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition * this.getScrollAmount() && mouseX < this.xPosition + this.width && mouseY < this.yPosition * this.getScrollAmount() + this.height;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.blendFunc(770, 771);
        this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition - this.getScrollAmount() + (this.height - 8) / 2, -1);
    }

    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        if (this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition - this.getScrollAmount() && mouseX < this.xPosition + this.width && mouseY < this.yPosition - this.getScrollAmount() + this.height) {
            this.modName = !this.modName;
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
