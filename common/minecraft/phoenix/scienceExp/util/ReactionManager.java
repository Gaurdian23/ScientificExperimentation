package minecraft.phoenix.scienceExp.util;

import minecraft.phoenix.scienceExp.items.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ReactionManager
{
	/** The static instance of this class */
    private static final ReactionManager instance = new ReactionManager();
	
	public static ReactionManager getInstance()
	{
		return instance;
	}

	public ItemStack[] calculateOutput(InventoryReact labMatrix, InventoryReact labResultMatrix, World worldObj)
	{
		ItemStack[] output = new ItemStack[labResultMatrix.getSizeInventory()];
		output[0] = new ItemStack(Items.compound, 1, 0);
		setLore("H₂SO₄", output[0]);
		return output;
	}
	
	@SideOnly(Side.CLIENT)
	public static void setLore(String lore, ItemStack itemStack)
	{
		NBTTagCompound tag = itemStack.getTagCompound() != null ? itemStack.getTagCompound() : new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagString("Lore", lore));
        tag.setTag("Lore", list);
        itemStack.setTagInfo("display", tag);
    }
}
