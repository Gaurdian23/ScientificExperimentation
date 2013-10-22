package minecraft.phoenix.scienceExp.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotReact extends Slot
{
    /** The craft matrix inventory linked to this result slot. */
    private final IInventory resultMatrix;

    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;

    public SlotReact(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6)
    {
        super(par3IInventory, par4, par5, par6);
        this.thePlayer = par1EntityPlayer;
        this.resultMatrix = par2IInventory;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        return super.decrStackSize(par1);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack par1ItemStack, int par2) {}
    
    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack par1ItemStack) {}

    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, resultMatrix);

        for (int i = 0; i < this.resultMatrix.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = this.resultMatrix.getStackInSlot(i);

            if (itemstack1 != null)
            {
                this.resultMatrix.decrStackSize(i, 1);

                if (itemstack1.getItem().hasContainerItem())
                {
                    ItemStack itemstack2 = itemstack1.getItem().getContainerItemStack(itemstack1);

                    if (itemstack2 != null && (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2)))
                    {
                        if (this.resultMatrix.getStackInSlot(i) == null)
                        {
                            this.resultMatrix.setInventorySlotContents(i, itemstack2);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItem(itemstack2);
                        }
                    }
                }
            }
        }
    }
}
