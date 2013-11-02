package minecraft.phoenix.scienceExp.gui;

import minecraft.phoenix.scienceExp.blocks.TileEntityLab;
import minecraft.phoenix.scienceExp.lib.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLab extends GuiContainer
{
	private static final ResourceLocation guiImage = new ResourceLocation(Reference.modid.toLowerCase(), "textures/gui/lab.png");
	private TileEntityLab labInventory;

    public GuiLab(InventoryPlayer par1InventoryPlayer, TileEntityLab tileEntityLab)
    {
        super(new ContainerLab(par1InventoryPlayer, tileEntityLab));
        this.labInventory = tileEntityLab;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(I18n.getString("container.lab"), 8, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(guiImage);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        
        if (this.labInventory.isBurning())
        {
            i1 = this.labInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.labInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
