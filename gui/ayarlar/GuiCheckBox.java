package pixelclient.gui.ayarlar;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiCheckBox extends GuiButton {
    public boolean checked;
    private static final String X = "x";
    private static final String CHECK = "/";
    private static final Color X_COLOR;
    private static final Color CHECK_COLOR;

    public GuiCheckBox(int buttonId, int x, int y) {
        this(buttonId, x, y, false);
    }

    public GuiCheckBox(int buttonId, int x, int y, boolean checked) {
        this(buttonId, x, y, 20, 20, checked);
    }

    public GuiCheckBox(int buttonId, int x, int y, int width, int height) {
        this(buttonId, x, y, width, height, false);
    }

    public GuiCheckBox(int buttonId, int x, int y, int width, int height, boolean checked) {
        super(buttonId, x, y, width, height, "");
        this.checked = checked;
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(buttonTextures);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            this.displayString = "x";
            int color = X_COLOR.getRGB();
            if (this.checked) {
                this.displayString = "/";
                color = CHECK_COLOR.getRGB();
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);
        }

    }

    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
            this.checked = !this.checked;
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    static {
        X_COLOR = Color.RED;
        CHECK_COLOR = Color.GREEN;
    }
}
