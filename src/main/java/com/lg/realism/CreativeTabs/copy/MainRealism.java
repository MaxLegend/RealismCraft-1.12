package com.lg.realism.CreativeTabs.copy;

import com.lg.realism.Realism;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MainRealism extends CreativeTabs {
	public MainRealism(String label) {
		super(label);
	//	this.setBackgroundImageName(Realism.MODID + ":maincreativebg.png");
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.STICK);
	}
}
