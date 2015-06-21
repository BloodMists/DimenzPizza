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
	public IIcon[] crop;

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
		this.setBlockTextureName(Reference.ASSETS + "cropTomato");
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
		if(metadata==5)
		{
			list.add(new ItemStack(BDPItemsLoader.stuffs, 4, 0));
		}
		return list;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) 
	{
		crop = new IIcon[5];
		for(int i=0;i<this.crop.length;i++)
		crop[i] = reg.registerIcon(this.getTextureName() + i);
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage)
	{
		return crop[parGrowthStage>=4?4:parGrowthStage];
	}

	@Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float f, int i)
	{
    	super.dropBlockAsItemWithChance(world, x, y, z, meta, f, 0);
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

	public int damageDropped(int meta){ return 0;}
	
	protected Item func_149866_i(){return BDPItemsLoader.seed;}

	protected Item func_149865_P(){return BDPItemsLoader.stuffs;}
}
