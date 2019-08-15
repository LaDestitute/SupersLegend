package superworldsun.superslegend.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	//Weapons
		kokiri_sword	(2, -2f, 0, 0, 0, ItemList.kokiri_sword),
		razor_sword		(3, -2f, 100, 1, 0, ItemList.razor_sword),
		gilded_sword	(4, -2f, 0, 2, 0, ItemList.gilded_sword),
		
		rupee_sword			(2, -2f, 32, 0, 0, ItemList.rupee_sword),
		blue_rupee_sword	(3, -2f, 74, 1, 0, ItemList.blue_rupee_sword),
		red_rupee_sword		(4, -2f, 240, 2, 0, ItemList.red_rupee_sword),
		orange_rupee_sword	(5, -2f, 1244, 3, 0, ItemList.orange_rupee_sword),
		
		//Tools
		rupee_pickaxe		(1, 2f, 32, 0, 0, ItemList.rupee_pickaxe),
		blue_rupee_pickaxe	(2, 3f, 74, 1, 0, ItemList.blue_rupee_pickaxe),
		red_rupee_pickaxe	(2, 4f, 240, 2, 0, ItemList.red_rupee_pickaxe),
		orange_rupee_pickaxe(3, 5f, 1244, 3, 0, ItemList.orange_rupee_pickaxe),
		
		rupee_axe			(1, 2f, 12, 0, 0, ItemList.rupee_axe),
		blue_rupee_axe		(2, 3f, 30, 1, 0, ItemList.blue_rupee_axe),
		red_rupee_axe		(2, 4f, 120, 2, 0, ItemList.red_rupee_axe),
		orange_rupee_axe	(3, 5f, 1080, 3, 0, ItemList.orange_rupee_axe),
		
		rupee_shovel			(1, 2f, 12, 0, 0, ItemList.rupee_shovel),
		blue_rupee_shovel		(2, 3f, 30, 1, 0, ItemList.blue_rupee_shovel),
		red_rupee_shovel		(2, 4f, 120, 2, 0, ItemList.red_rupee_shovel),
		orange_rupee_shovel		(3, 5f, 1080, 3, 0, ItemList.orange_rupee_shovel),
		
		rupee_hoe		(1, 2f, 32, 0, 0, ItemList.rupee_hoe),
		blue_rupee_hoe	(2, 3f, 74, 1, 0, ItemList.blue_rupee_hoe),
		red_rupee_hoe	(2, 4f, 240, 2, 0, ItemList.red_rupee_hoe),
		orange_rupee_hoe(3, 5f, 1244, 3, 0, ItemList.orange_rupee_hoe);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestlevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestlevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() 
	{
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
