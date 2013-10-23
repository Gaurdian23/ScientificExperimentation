package minecraft.phoenix.scienceExp.chemistry;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import minecraft.phoenix.scienceExp.items.ItemCompound;
import minecraft.phoenix.scienceExp.items.Items;
import minecraft.phoenix.scienceExp.util.InventoryReact;
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
		HashMap<Element, Integer> elements = new HashMap<Element, Integer>();
		ItemStack[] output = new ItemStack[labResultMatrix.getSizeInventory()];
		ItemStack input = labMatrix.getStackInSlot(0);
		Compound compound = new Compound(new HashMap<Object, Integer>());
		compound.components.put(Element.HYDROGEN, 2);
		compound.components.put(Element.SULPHUR, 1);
		compound.components.put(Element.OXYGEN, 4);
		if(input.itemID == Items.compound.itemID)
			Compound.;
		else
			output[0] = new ItemStack(Items.compound);
		setLore(compound.toString(), output[0]);
		
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
	
	private static void writeToNBT(Compound compound, NBTTagCompound tag)
	{
		
	}
}
