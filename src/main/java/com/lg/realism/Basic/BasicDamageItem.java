package com.lg.realism.Basic;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lg.realism.Realism;

public class BasicDamageItem extends Item{
	public BasicDamageItem(String name,int maxStackSize,int maxDamage){
		this.setRegistryName(name);
		this.setCreativeTab(Realism.tabMain);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
		this.setMaxDamage(maxDamage);
	}
	  @Override
	     public ItemStack getContainerItem(ItemStack stack) {
	    stack.attemptDamageItem(1, new Random(), null);
	         return stack.copy();
	       }
	  
	  @Override
	  public boolean hasContainerItem(ItemStack stack) {
	         return true;
	  }
}

