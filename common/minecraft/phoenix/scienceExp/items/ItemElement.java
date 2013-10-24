package minecraft.phoenix.scienceExp.items;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecraft.phoenix.scienceExp.chemistry.Elements;
import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemElement extends Item
{
	@SideOnly(Side.CLIENT)
    private Icon[] icons;
	
	public ItemElement(int par1)
	{
		super(par1);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(CommonProxy.elements);
		this.setUnlocalizedName(Strings.ELEMENT);
	}
	
	@SideOnly(Side.CLIENT)
    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, Elements.values().length-1);
        return this.icons[j];
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, Elements.values().length-1);
        return super.getUnlocalizedName() + "." + Elements.values()[i];
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < Elements.values().length; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons = new Icon[Elements.values().length];

        for (int i = 0; i < icons.length; ++i)
        {
            this.icons[i] = par1IconRegister.registerIcon(Reference.modid + ":element" + Elements.values()[i]);
        }
    }
}
