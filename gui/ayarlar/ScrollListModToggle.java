package pixelclient.gui.ayarlar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import pixelclient.gui.hud.HUDManager;
import pixelclient.gui.hud.IRenderer;
import pixelclient.mods.Mod;

public class ScrollListModToggle extends GuiListExtended {
    private final List<ModEntry> entrys = new ArrayList();

    public ScrollListModToggle(Minecraft mcIn, GuiModToggle inGui) {
        super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
        Iterator var3 = HUDManager.getInstance().getRegisteredRenderers().iterator();

        while(var3.hasNext()) {
            IRenderer r = (IRenderer)var3.next();
            if (r instanceof Mod) {
                Mod m = (Mod)r;
                this.entrys.add(new ModEntry(inGui, m));
            }
        }

        Collections.sort(this.entrys);
    }

    public IGuiListEntry getListEntry(int index) {
        return (IGuiListEntry)this.entrys.get(index);
    }

    protected int getSize() {
        return this.entrys.size();
    }
}
