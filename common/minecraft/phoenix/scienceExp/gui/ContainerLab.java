package minecraft.phoenix.scienceExp.gui;

import minecraft.phoenix.scienceExp.blocks.Blocks;
import minecraft.phoenix.scienceExp.blocks.TileEntityLab;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.util.InventoryReact;
import minecraft.phoenix.scienceExp.util.ReactionManager;
import minecraft.phoenix.scienceExp.util.SlotReact;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLab extends Container
{
    /** The crafting matrix inventory (4x4). */
    public InventoryReact labMatrix = new InventoryReact(this, 4, 4, "container." + Strings.LAB);
    public InventoryReact labResult = new InventoryReact(this, 4, 4, "Result");
    private TileEntityLab tileEntityLab;

    public ContainerLab(InventoryPlayer inventoryPlayer, TileEntityLab tileEntityLab)
    {
        this.tileEntityLab = tileEntityLab;
    	
        int l;
        int i1;
        
        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.labMatrix, i1 + l * 3, 8 + i1 * 18, 17 + l * 18));
            }
        }
        
        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(this.addSlotToContainer(new SlotReact(inventoryPlayer.player, this.labMatrix, this.labResult, i1 + l * 3, 116 + i1 * 18, 17 + l * 18)));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.labMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.labResult.setInventorySlotContents(ReactionManager.getInstance().calculateOutput(this.labMatrix, this.labResult, this.tileEntityLab.worldObj));
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.tileEntityLab.worldObj.getBlockId(this.tileEntityLab.xCoord, this.tileEntityLab.yCoord, this.tileEntityLab.zCoord) != Blocks.lab.blockID ? false : par1EntityPlayer.getDistanceSq((double)this.tileEntityLab.xCoord + 0.5D, (double)this.tileEntityLab.yCoord + 0.5D, (double)this.tileEntityLab.zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 >= 10 && par2 < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

    public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
    {
        return par2Slot.inventory != this.labResult && super.func_94530_a(par1ItemStack, par2Slot);
    }
}
