package bloods.common.dimenPizza.item;

import bloods.common.dimenPizza.creativetab.CreativetabBBDP;
import bloods.common.dimenPizza.creativetab.CreativetabIBDP;
import bloods.common.dimenPizza.init.BDPBlocksLoader;
import bloods.common.dimenPizza.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class seedTomato extends ItemBDP implements IPlantable
{

	public seedTomato(Block p_i45352_1_, Block p_i45352_2_) {
		super();
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativetabIBDP.Dimenz_Pizza_Items);
		this.setUnlocalizedName(Reference.getItemName(iconString));
	}

	@Override
	public boolean onItemUse(ItemStack stack,EntityPlayer player,World world,int parX,int parY,int parZ,int par7,float par8,float par9,float par10)
	{
		if (par7 != 1)
		{
			return false;
		}
			if (player.canPlayerEdit(parX, parY+1, parZ, par7, stack))
			{
				if (world.getBlock(parX, parY, parZ).canSustainPlant(world,parX,parY,parZ,ForgeDirection.UP,this)&& world.isAirBlock(parX,parY+1,parZ))
				{
					world.setBlock(parX, parY+1, parZ, BDPBlocksLoader.tomato);
				}
				--stack.stackSize;
				return true;
				}
		else
		{
			return false;
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return BDPBlocksLoader.tomato;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

}
