package com.lg.realism.event.DelRecipesEvent;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public class DelRecipesHundler
{
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> e)
    {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) e.getRegistry();

        modRegistry.remove(new ResourceLocation("minecraft:glass_pane"));
    }
}