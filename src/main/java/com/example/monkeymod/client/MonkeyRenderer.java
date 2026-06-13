package com.example.monkeymod.client;

import com.example.monkeymod.MonkeyMod;
import com.example.monkeymod.entity.MonkeyEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MonkeyRenderer extends MobRenderer<MonkeyEntity, MonkeyModel<MonkeyEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(MonkeyMod.MODID, "textures/entity/monkey.png");

    public MonkeyRenderer(EntityRendererProvider.Context context) {
        super(context, new MonkeyModel<>(context.bakeLayer(MonkeyModel.LAYER)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(MonkeyEntity entity) {
        return TEXTURE;
    }
}
