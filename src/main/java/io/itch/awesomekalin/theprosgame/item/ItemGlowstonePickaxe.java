
package io.itch.awesomekalin.theprosgame.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

import io.itch.awesomekalin.theprosgame.ElementsTheProsGameMod;

@ElementsTheProsGameMod.ModElement.Tag
public class ItemGlowstonePickaxe extends ElementsTheProsGameMod.ModElement {
	@GameRegistry.ObjectHolder("the_pros_game:glowstone_pickaxe")
	public static final Item block = null;
	public ItemGlowstonePickaxe(ElementsTheProsGameMod instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("GLOWSTONE_PICKAXE", 1, 1000, 4f, -3f, 13)) {
			{
				this.attackSpeed = 2f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 1);
				return ret.keySet();
			}
		}.setUnlocalizedName("glowstone_pickaxe").setRegistryName("glowstone_pickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("the_pros_game:glowstone_pickaxe", "inventory"));
	}
}
