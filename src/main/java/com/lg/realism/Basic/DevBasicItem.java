package com.lg.realism.Basic;

import net.minecraft.item.Item;

public class DevBasicItem extends Item
{
	public DevBasicItem(String name,int maxStackSize)
	{
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
	}
}