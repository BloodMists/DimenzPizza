package bloods.common.dimenPizza.crops;

import java.util.ArrayList;
import java.util.Random;

import bloods.common.dimenPizza.init.BDPItemsLoader;
import bloods.common.dimenPizza.item.ItemBDP;
import bloods.common.dimenPizza.item.seedTomato;
import bloods.common.dimenPizza.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class cropTomato extends BlockBush implements IGrowable
{
	protected int maxGrowthStage = 5;
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] crop;

	public cropTomato()
	{
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab(null);
		this.setHardness(0.01F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
		this.setBlockName(Reference.getBlockName(textureName));
		this.setBlockTextureName(Reference.ASSETS + crop);
	}

	@Override
	protected boolean canPlaceBlockOn(Block land)
	{
		return land == Blocks.farmland;
	}
	
	@Override
	public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
	{
		super.updateTick(parWorld, parX, parY, parZ, parRand);
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;
		if (growStage > 5)
		{
			growStage = 5;
		}
		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}

	public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ)
	{
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 
				MathHelper.getRandomIntegerInRange(parRand, 2, 5);
		if (growStage > maxGrowthStage)
		{
			growStage = maxGrowthStage;
		}
		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}


	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(BDPItemsLoader.seed, 1));
		if(metadata==7)
		{
			list.add(new ItemStack(BDPItemsLoader.stuffs, 4, 0));
		}
		return list;
	}

	@Override
	public Item getItemDropped(int par1, Random parRand, int parFortune)
	{
		return (BDPItemsLoader.stuffs);
	}
	
/*	@Override
    public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, 1.0f, par7);
    }*/
	
	@Override
	public int getRenderType()
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage)
	{
		return crop[parGrowthStage];
	}

	//Need to implement the IGrowable interface methods
	//(non-Javadoc)@see net.minecraft.block.IGrowable#func_149851_a(net.minecraft.world.World, int, int, int, boolean)
	@Override
	public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_)
	{
		return parWorld.getBlockMetadata(parX, parY, parZ) != 5;
	}

	//(non-Javadoc)@see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World, java.util.Random, int, int, int)
	@Override
	public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_)
	{
		return true;
	}

	//(non-Javadoc)@see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World, java.util.Random, int, int, int)
	@Override
	public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ)
	{
		incrementGrowStage(parWorld, parRand, parX, parY, parZ);
	}

	protected Item func_149866_i()
	   {
	       return Items.wheat_seeds;
	   }

	   protected Item func_149865_P()
	   {
	       return Items.wheat;
	   }
}
