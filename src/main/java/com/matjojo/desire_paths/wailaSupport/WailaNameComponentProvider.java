package com.matjojo.desire_paths.wailaSupport;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITaggableList;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.Identifier;

import java.util.List;

import static com.matjojo.desire_paths.core.Util.getBlockNameStringForTrampleableBlock;
import static com.matjojo.desire_paths.core.Util.getItemStackForTrampleableBlock;

public class WailaNameComponentProvider implements IComponentProvider {

    static IComponentProvider INSTANCE = new WailaNameComponentProvider();
    private static final Identifier MOD_NAME_TAG = new Identifier(Waila.MODID, "mod_name");
    private static final Identifier OBJECT_NAME_TAG = new Identifier(Waila.MODID, "object_name");

    @Override
    public void appendHead(List<Component> tooltip, IDataAccessor accessor, IPluginConfig config) {

        String blockName = getBlockNameStringForTrampleableBlock(accessor.getBlock());

        String blockNameFormatted = String.format(Waila.CONFIG.get().getFormatting().getBlockName(), blockName);
        ((ITaggableList<Identifier, Component>) tooltip).setTag(OBJECT_NAME_TAG, new TextComponent(blockNameFormatted));
    }

    @Override
    public void appendTail(List<Component> tooltip, IDataAccessor accessor, IPluginConfig config) {

        String modNameFormatted = String.format(Waila.CONFIG.get().getFormatting().getModName(), "DesirePaths");

        ((ITaggableList<Identifier, Component>) tooltip).setTag(MOD_NAME_TAG, new TextComponent(modNameFormatted));
    }

    @Override
    public ItemStack getStack(IDataAccessor accessor, IPluginConfig config) {
        return getItemStackForTrampleableBlock(accessor.getBlock());
    }
}