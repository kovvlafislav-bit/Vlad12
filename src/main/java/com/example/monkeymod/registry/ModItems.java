package com.example.monkeymod.registry;

import com.example.monkeymod.MonkeyMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MonkeyMod.MODID);

    // Spawn egg colours: primary (body) and secondary (spots).
    public static final RegistryObject<Item> MONKEY_SPAWN_EGG =
            ITEMS.register("monkey_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.MONKEY, 0x6b4f2a, 0xd9a066, new Item.Properties()));
}
