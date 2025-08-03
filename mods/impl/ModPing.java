package pixelclient.mods.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import pixelclient.gui.hud.ScreenPosition;
import pixelclient.mods.ModDraggable;

public class ModPing extends ModDraggable {
    public static NetworkPlayerInfo networkPlayerInfo;
    public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");

    public ModPing() {
    }

    public int getWidth() {
        FontRenderer var10001 = this.font;
        StringBuilder var10002 = new StringBuilder();
        Minecraft var10003 = this.mc;
        NetHandlerPlayClient var1 = Minecraft.getMinecraft().getNetHandler();
        Minecraft var10004 = this.mc;
        return 10 + var10001.getStringWidth(var10002.append(var1.getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime()).append(" ms").toString());
    }

    public int getHeight() {
        return 8;
    }

    public void render(ScreenPosition pos) {
        Minecraft var10000 = this.mc;
        NetHandlerPlayClient var7 = Minecraft.getMinecraft().getNetHandler();
        Minecraft var10001 = this.mc;
        int ping = var7.getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
        this.font.drawString(ping + " ms", pos.getAbsoluteX() + 12, pos.getAbsoluteY(), -1);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(icons);
        int i = 0;
        int j = 0;
        byte j1;
        if (ping < 0) {
            j1 = 5;
        } else if (ping < 150) {
            j1 = 0;
        } else if (ping < 300) {
            j1 = 1;
        } else if (ping < 600) {
            j1 = 2;
        } else if (ping < 1000) {
            j1 = 3;
        } else {
            j1 = 4;
        }

        Gui gui = new Gui();
        gui.drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY(), 0 + i * 10, 176 + j1 * 8, 10, 8);
    }
}
