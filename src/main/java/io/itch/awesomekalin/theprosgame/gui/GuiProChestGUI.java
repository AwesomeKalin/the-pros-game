
package io.itch.awesomekalin.theprosgame.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

import io.itch.awesomekalin.theprosgame.TheProsGameMod;
import io.itch.awesomekalin.theprosgame.ElementsTheProsGameMod;

@ElementsTheProsGameMod.ModElement.Tag
public class GuiProChestGUI extends ElementsTheProsGameMod.ModElement {
	public static int GUIID = 1;
	public static HashMap guistate = new HashMap();
	public GuiProChestGUI(ElementsTheProsGameMod instance) {
		super(instance, 16);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}
	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private IInventory internal;
		private World world;
		private EntityPlayer entity;
		private int x, y, z;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			this.internal = new InventoryBasic("", true, 236);
			TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
			if (ent instanceof IInventory)
				this.internal = (IInventory) ent;
			this.customSlots.put(0, this.addSlotToContainer(new Slot(internal, 0, 5, 17) {
			}));
			this.customSlots.put(1, this.addSlotToContainer(new Slot(internal, 1, 23, 17) {
			}));
			this.customSlots.put(2, this.addSlotToContainer(new Slot(internal, 2, 41, 17) {
			}));
			this.customSlots.put(3, this.addSlotToContainer(new Slot(internal, 3, 59, 17) {
			}));
			this.customSlots.put(4, this.addSlotToContainer(new Slot(internal, 4, 77, 17) {
			}));
			this.customSlots.put(5, this.addSlotToContainer(new Slot(internal, 5, 95, 17) {
			}));
			this.customSlots.put(6, this.addSlotToContainer(new Slot(internal, 6, 113, 17) {
			}));
			this.customSlots.put(7, this.addSlotToContainer(new Slot(internal, 7, 131, 17) {
			}));
			this.customSlots.put(8, this.addSlotToContainer(new Slot(internal, 8, 149, 17) {
			}));
			this.customSlots.put(9, this.addSlotToContainer(new Slot(internal, 9, 167, 17) {
			}));
			this.customSlots.put(10, this.addSlotToContainer(new Slot(internal, 10, 185, 17) {
			}));
			this.customSlots.put(11, this.addSlotToContainer(new Slot(internal, 11, 203, 17) {
			}));
			this.customSlots.put(12, this.addSlotToContainer(new Slot(internal, 12, 221, 17) {
			}));
			this.customSlots.put(13, this.addSlotToContainer(new Slot(internal, 13, 239, 17) {
			}));
			this.customSlots.put(14, this.addSlotToContainer(new Slot(internal, 14, 257, 17) {
			}));
			this.customSlots.put(15, this.addSlotToContainer(new Slot(internal, 15, 275, 17) {
			}));
			this.customSlots.put(16, this.addSlotToContainer(new Slot(internal, 16, 293, 17) {
			}));
			this.customSlots.put(17, this.addSlotToContainer(new Slot(internal, 17, 311, 17) {
			}));
			this.customSlots.put(18, this.addSlotToContainer(new Slot(internal, 18, 329, 17) {
			}));
			this.customSlots.put(19, this.addSlotToContainer(new Slot(internal, 19, 347, 17) {
			}));
			this.customSlots.put(20, this.addSlotToContainer(new Slot(internal, 20, 365, 17) {
			}));
			this.customSlots.put(21, this.addSlotToContainer(new Slot(internal, 21, 383, 17) {
			}));
			this.customSlots.put(22, this.addSlotToContainer(new Slot(internal, 22, 5, 35) {
			}));
			this.customSlots.put(23, this.addSlotToContainer(new Slot(internal, 23, 23, 35) {
			}));
			this.customSlots.put(24, this.addSlotToContainer(new Slot(internal, 24, 41, 35) {
			}));
			this.customSlots.put(25, this.addSlotToContainer(new Slot(internal, 25, 59, 35) {
			}));
			this.customSlots.put(26, this.addSlotToContainer(new Slot(internal, 26, 77, 35) {
			}));
			this.customSlots.put(27, this.addSlotToContainer(new Slot(internal, 27, 95, 35) {
			}));
			this.customSlots.put(28, this.addSlotToContainer(new Slot(internal, 28, 113, 35) {
			}));
			this.customSlots.put(29, this.addSlotToContainer(new Slot(internal, 29, 131, 35) {
			}));
			this.customSlots.put(30, this.addSlotToContainer(new Slot(internal, 30, 149, 35) {
			}));
			this.customSlots.put(31, this.addSlotToContainer(new Slot(internal, 31, 167, 35) {
			}));
			this.customSlots.put(32, this.addSlotToContainer(new Slot(internal, 32, 185, 35) {
			}));
			this.customSlots.put(33, this.addSlotToContainer(new Slot(internal, 33, 203, 35) {
			}));
			this.customSlots.put(34, this.addSlotToContainer(new Slot(internal, 34, 221, 35) {
			}));
			this.customSlots.put(35, this.addSlotToContainer(new Slot(internal, 35, 239, 35) {
			}));
			this.customSlots.put(36, this.addSlotToContainer(new Slot(internal, 36, 257, 35) {
			}));
			this.customSlots.put(37, this.addSlotToContainer(new Slot(internal, 37, 275, 35) {
			}));
			this.customSlots.put(38, this.addSlotToContainer(new Slot(internal, 38, 293, 35) {
			}));
			this.customSlots.put(39, this.addSlotToContainer(new Slot(internal, 39, 311, 35) {
			}));
			this.customSlots.put(40, this.addSlotToContainer(new Slot(internal, 40, 329, 35) {
			}));
			this.customSlots.put(41, this.addSlotToContainer(new Slot(internal, 41, 347, 35) {
			}));
			this.customSlots.put(42, this.addSlotToContainer(new Slot(internal, 42, 365, 35) {
			}));
			this.customSlots.put(43, this.addSlotToContainer(new Slot(internal, 43, 383, 35) {
			}));
			this.customSlots.put(44, this.addSlotToContainer(new Slot(internal, 44, 5, 53) {
			}));
			this.customSlots.put(45, this.addSlotToContainer(new Slot(internal, 45, 23, 53) {
			}));
			this.customSlots.put(46, this.addSlotToContainer(new Slot(internal, 46, 41, 53) {
			}));
			this.customSlots.put(47, this.addSlotToContainer(new Slot(internal, 47, 59, 53) {
			}));
			this.customSlots.put(48, this.addSlotToContainer(new Slot(internal, 48, 77, 53) {
			}));
			this.customSlots.put(49, this.addSlotToContainer(new Slot(internal, 49, 95, 53) {
			}));
			this.customSlots.put(50, this.addSlotToContainer(new Slot(internal, 50, 113, 53) {
			}));
			this.customSlots.put(51, this.addSlotToContainer(new Slot(internal, 51, 131, 53) {
			}));
			this.customSlots.put(52, this.addSlotToContainer(new Slot(internal, 52, 149, 53) {
			}));
			this.customSlots.put(53, this.addSlotToContainer(new Slot(internal, 53, 167, 53) {
			}));
			this.customSlots.put(54, this.addSlotToContainer(new Slot(internal, 54, 185, 53) {
			}));
			this.customSlots.put(55, this.addSlotToContainer(new Slot(internal, 55, 203, 53) {
			}));
			this.customSlots.put(56, this.addSlotToContainer(new Slot(internal, 56, 221, 53) {
			}));
			this.customSlots.put(57, this.addSlotToContainer(new Slot(internal, 57, 239, 53) {
			}));
			this.customSlots.put(58, this.addSlotToContainer(new Slot(internal, 58, 257, 53) {
			}));
			this.customSlots.put(59, this.addSlotToContainer(new Slot(internal, 59, 275, 53) {
			}));
			this.customSlots.put(60, this.addSlotToContainer(new Slot(internal, 60, 293, 53) {
			}));
			this.customSlots.put(61, this.addSlotToContainer(new Slot(internal, 61, 311, 53) {
			}));
			this.customSlots.put(62, this.addSlotToContainer(new Slot(internal, 62, 329, 53) {
			}));
			this.customSlots.put(63, this.addSlotToContainer(new Slot(internal, 63, 347, 53) {
			}));
			this.customSlots.put(64, this.addSlotToContainer(new Slot(internal, 64, 365, 53) {
			}));
			this.customSlots.put(65, this.addSlotToContainer(new Slot(internal, 65, 383, 53) {
			}));
			this.customSlots.put(66, this.addSlotToContainer(new Slot(internal, 66, 5, 71) {
			}));
			this.customSlots.put(67, this.addSlotToContainer(new Slot(internal, 67, 23, 71) {
			}));
			this.customSlots.put(68, this.addSlotToContainer(new Slot(internal, 68, 41, 71) {
			}));
			this.customSlots.put(69, this.addSlotToContainer(new Slot(internal, 69, 59, 71) {
			}));
			this.customSlots.put(70, this.addSlotToContainer(new Slot(internal, 70, 77, 71) {
			}));
			this.customSlots.put(71, this.addSlotToContainer(new Slot(internal, 71, 95, 71) {
			}));
			this.customSlots.put(72, this.addSlotToContainer(new Slot(internal, 72, 113, 71) {
			}));
			this.customSlots.put(73, this.addSlotToContainer(new Slot(internal, 73, 131, 71) {
			}));
			this.customSlots.put(74, this.addSlotToContainer(new Slot(internal, 74, 149, 71) {
			}));
			this.customSlots.put(75, this.addSlotToContainer(new Slot(internal, 75, 167, 71) {
			}));
			this.customSlots.put(76, this.addSlotToContainer(new Slot(internal, 76, 185, 71) {
			}));
			this.customSlots.put(77, this.addSlotToContainer(new Slot(internal, 77, 203, 71) {
			}));
			this.customSlots.put(78, this.addSlotToContainer(new Slot(internal, 78, 221, 71) {
			}));
			this.customSlots.put(79, this.addSlotToContainer(new Slot(internal, 79, 239, 71) {
			}));
			this.customSlots.put(80, this.addSlotToContainer(new Slot(internal, 80, 257, 71) {
			}));
			this.customSlots.put(81, this.addSlotToContainer(new Slot(internal, 81, 275, 71) {
			}));
			this.customSlots.put(82, this.addSlotToContainer(new Slot(internal, 82, 293, 71) {
			}));
			this.customSlots.put(83, this.addSlotToContainer(new Slot(internal, 83, 311, 71) {
			}));
			this.customSlots.put(84, this.addSlotToContainer(new Slot(internal, 84, 329, 71) {
			}));
			this.customSlots.put(85, this.addSlotToContainer(new Slot(internal, 85, 347, 71) {
			}));
			this.customSlots.put(86, this.addSlotToContainer(new Slot(internal, 86, 365, 71) {
			}));
			this.customSlots.put(87, this.addSlotToContainer(new Slot(internal, 87, 383, 71) {
			}));
			this.customSlots.put(88, this.addSlotToContainer(new Slot(internal, 88, 5, 89) {
			}));
			this.customSlots.put(89, this.addSlotToContainer(new Slot(internal, 89, 23, 89) {
			}));
			this.customSlots.put(90, this.addSlotToContainer(new Slot(internal, 90, 41, 89) {
			}));
			this.customSlots.put(91, this.addSlotToContainer(new Slot(internal, 91, 59, 89) {
			}));
			this.customSlots.put(92, this.addSlotToContainer(new Slot(internal, 92, 77, 89) {
			}));
			this.customSlots.put(93, this.addSlotToContainer(new Slot(internal, 93, 95, 89) {
			}));
			this.customSlots.put(94, this.addSlotToContainer(new Slot(internal, 94, 113, 89) {
			}));
			this.customSlots.put(95, this.addSlotToContainer(new Slot(internal, 95, 131, 89) {
			}));
			this.customSlots.put(96, this.addSlotToContainer(new Slot(internal, 96, 149, 89) {
			}));
			this.customSlots.put(97, this.addSlotToContainer(new Slot(internal, 97, 167, 89) {
			}));
			this.customSlots.put(98, this.addSlotToContainer(new Slot(internal, 98, 185, 89) {
			}));
			this.customSlots.put(99, this.addSlotToContainer(new Slot(internal, 99, 203, 89) {
			}));
			this.customSlots.put(100, this.addSlotToContainer(new Slot(internal, 100, 221, 89) {
			}));
			this.customSlots.put(101, this.addSlotToContainer(new Slot(internal, 101, 239, 89) {
			}));
			this.customSlots.put(102, this.addSlotToContainer(new Slot(internal, 102, 257, 89) {
			}));
			this.customSlots.put(103, this.addSlotToContainer(new Slot(internal, 103, 275, 89) {
			}));
			this.customSlots.put(104, this.addSlotToContainer(new Slot(internal, 104, 293, 89) {
			}));
			this.customSlots.put(105, this.addSlotToContainer(new Slot(internal, 105, 311, 89) {
			}));
			this.customSlots.put(106, this.addSlotToContainer(new Slot(internal, 106, 329, 89) {
			}));
			this.customSlots.put(107, this.addSlotToContainer(new Slot(internal, 107, 347, 89) {
			}));
			this.customSlots.put(108, this.addSlotToContainer(new Slot(internal, 108, 365, 89) {
			}));
			this.customSlots.put(109, this.addSlotToContainer(new Slot(internal, 109, 383, 89) {
			}));
			this.customSlots.put(110, this.addSlotToContainer(new Slot(internal, 110, 5, 107) {
			}));
			this.customSlots.put(111, this.addSlotToContainer(new Slot(internal, 111, 23, 107) {
			}));
			this.customSlots.put(112, this.addSlotToContainer(new Slot(internal, 112, 41, 107) {
			}));
			this.customSlots.put(113, this.addSlotToContainer(new Slot(internal, 113, 59, 107) {
			}));
			this.customSlots.put(114, this.addSlotToContainer(new Slot(internal, 114, 77, 107) {
			}));
			this.customSlots.put(115, this.addSlotToContainer(new Slot(internal, 115, 95, 107) {
			}));
			this.customSlots.put(116, this.addSlotToContainer(new Slot(internal, 116, 113, 107) {
			}));
			this.customSlots.put(117, this.addSlotToContainer(new Slot(internal, 117, 131, 107) {
			}));
			this.customSlots.put(118, this.addSlotToContainer(new Slot(internal, 118, 149, 107) {
			}));
			this.customSlots.put(119, this.addSlotToContainer(new Slot(internal, 119, 167, 107) {
			}));
			this.customSlots.put(120, this.addSlotToContainer(new Slot(internal, 120, 185, 107) {
			}));
			this.customSlots.put(121, this.addSlotToContainer(new Slot(internal, 121, 203, 107) {
			}));
			this.customSlots.put(122, this.addSlotToContainer(new Slot(internal, 122, 221, 107) {
			}));
			this.customSlots.put(123, this.addSlotToContainer(new Slot(internal, 123, 239, 107) {
			}));
			this.customSlots.put(124, this.addSlotToContainer(new Slot(internal, 124, 257, 107) {
			}));
			this.customSlots.put(125, this.addSlotToContainer(new Slot(internal, 125, 275, 107) {
			}));
			this.customSlots.put(126, this.addSlotToContainer(new Slot(internal, 126, 293, 107) {
			}));
			this.customSlots.put(127, this.addSlotToContainer(new Slot(internal, 127, 311, 107) {
			}));
			this.customSlots.put(128, this.addSlotToContainer(new Slot(internal, 128, 329, 107) {
			}));
			this.customSlots.put(129, this.addSlotToContainer(new Slot(internal, 129, 347, 107) {
			}));
			this.customSlots.put(130, this.addSlotToContainer(new Slot(internal, 130, 365, 107) {
			}));
			this.customSlots.put(131, this.addSlotToContainer(new Slot(internal, 131, 383, 107) {
			}));
			this.customSlots.put(132, this.addSlotToContainer(new Slot(internal, 132, 5, 125) {
			}));
			this.customSlots.put(133, this.addSlotToContainer(new Slot(internal, 133, 23, 125) {
			}));
			this.customSlots.put(134, this.addSlotToContainer(new Slot(internal, 134, 41, 125) {
			}));
			this.customSlots.put(135, this.addSlotToContainer(new Slot(internal, 135, 59, 125) {
			}));
			this.customSlots.put(136, this.addSlotToContainer(new Slot(internal, 136, 77, 125) {
			}));
			this.customSlots.put(137, this.addSlotToContainer(new Slot(internal, 137, 95, 125) {
			}));
			this.customSlots.put(138, this.addSlotToContainer(new Slot(internal, 138, 113, 125) {
			}));
			this.customSlots.put(139, this.addSlotToContainer(new Slot(internal, 139, 131, 125) {
			}));
			this.customSlots.put(140, this.addSlotToContainer(new Slot(internal, 140, 149, 125) {
			}));
			this.customSlots.put(141, this.addSlotToContainer(new Slot(internal, 141, 167, 125) {
			}));
			this.customSlots.put(142, this.addSlotToContainer(new Slot(internal, 142, 185, 125) {
			}));
			this.customSlots.put(143, this.addSlotToContainer(new Slot(internal, 143, 203, 125) {
			}));
			this.customSlots.put(144, this.addSlotToContainer(new Slot(internal, 144, 221, 125) {
			}));
			this.customSlots.put(145, this.addSlotToContainer(new Slot(internal, 145, 239, 125) {
			}));
			this.customSlots.put(146, this.addSlotToContainer(new Slot(internal, 146, 257, 125) {
			}));
			this.customSlots.put(147, this.addSlotToContainer(new Slot(internal, 147, 275, 125) {
			}));
			this.customSlots.put(148, this.addSlotToContainer(new Slot(internal, 148, 293, 125) {
			}));
			this.customSlots.put(149, this.addSlotToContainer(new Slot(internal, 149, 311, 125) {
			}));
			this.customSlots.put(150, this.addSlotToContainer(new Slot(internal, 150, 329, 125) {
			}));
			this.customSlots.put(151, this.addSlotToContainer(new Slot(internal, 151, 347, 125) {
			}));
			this.customSlots.put(152, this.addSlotToContainer(new Slot(internal, 152, 365, 125) {
			}));
			this.customSlots.put(153, this.addSlotToContainer(new Slot(internal, 153, 383, 125) {
			}));
			this.customSlots.put(154, this.addSlotToContainer(new Slot(internal, 154, 5, 143) {
			}));
			this.customSlots.put(155, this.addSlotToContainer(new Slot(internal, 155, 23, 143) {
			}));
			this.customSlots.put(156, this.addSlotToContainer(new Slot(internal, 156, 41, 143) {
			}));
			this.customSlots.put(157, this.addSlotToContainer(new Slot(internal, 157, 59, 143) {
			}));
			this.customSlots.put(158, this.addSlotToContainer(new Slot(internal, 158, 77, 143) {
			}));
			this.customSlots.put(159, this.addSlotToContainer(new Slot(internal, 159, 95, 143) {
			}));
			this.customSlots.put(160, this.addSlotToContainer(new Slot(internal, 160, 113, 143) {
			}));
			this.customSlots.put(161, this.addSlotToContainer(new Slot(internal, 161, 131, 143) {
			}));
			this.customSlots.put(162, this.addSlotToContainer(new Slot(internal, 162, 149, 143) {
			}));
			this.customSlots.put(163, this.addSlotToContainer(new Slot(internal, 163, 167, 143) {
			}));
			this.customSlots.put(164, this.addSlotToContainer(new Slot(internal, 164, 185, 143) {
			}));
			this.customSlots.put(165, this.addSlotToContainer(new Slot(internal, 165, 203, 143) {
			}));
			this.customSlots.put(166, this.addSlotToContainer(new Slot(internal, 166, 221, 143) {
			}));
			this.customSlots.put(167, this.addSlotToContainer(new Slot(internal, 167, 239, 143) {
			}));
			this.customSlots.put(168, this.addSlotToContainer(new Slot(internal, 168, 257, 143) {
			}));
			this.customSlots.put(169, this.addSlotToContainer(new Slot(internal, 169, 275, 143) {
			}));
			this.customSlots.put(170, this.addSlotToContainer(new Slot(internal, 170, 293, 143) {
			}));
			this.customSlots.put(171, this.addSlotToContainer(new Slot(internal, 171, 311, 143) {
			}));
			this.customSlots.put(172, this.addSlotToContainer(new Slot(internal, 172, 329, 143) {
			}));
			this.customSlots.put(173, this.addSlotToContainer(new Slot(internal, 173, 347, 143) {
			}));
			this.customSlots.put(174, this.addSlotToContainer(new Slot(internal, 174, 365, 143) {
			}));
			this.customSlots.put(175, this.addSlotToContainer(new Slot(internal, 175, 383, 143) {
			}));
			this.customSlots.put(176, this.addSlotToContainer(new Slot(internal, 176, 5, 161) {
			}));
			this.customSlots.put(177, this.addSlotToContainer(new Slot(internal, 177, 23, 161) {
			}));
			this.customSlots.put(178, this.addSlotToContainer(new Slot(internal, 178, 41, 161) {
			}));
			this.customSlots.put(179, this.addSlotToContainer(new Slot(internal, 179, 59, 161) {
			}));
			this.customSlots.put(180, this.addSlotToContainer(new Slot(internal, 180, 77, 161) {
			}));
			this.customSlots.put(181, this.addSlotToContainer(new Slot(internal, 181, 95, 161) {
			}));
			this.customSlots.put(182, this.addSlotToContainer(new Slot(internal, 182, 293, 161) {
			}));
			this.customSlots.put(183, this.addSlotToContainer(new Slot(internal, 183, 311, 161) {
			}));
			this.customSlots.put(184, this.addSlotToContainer(new Slot(internal, 184, 329, 161) {
			}));
			this.customSlots.put(185, this.addSlotToContainer(new Slot(internal, 185, 347, 161) {
			}));
			this.customSlots.put(186, this.addSlotToContainer(new Slot(internal, 186, 365, 161) {
			}));
			this.customSlots.put(187, this.addSlotToContainer(new Slot(internal, 187, 383, 161) {
			}));
			this.customSlots.put(188, this.addSlotToContainer(new Slot(internal, 188, 5, 179) {
			}));
			this.customSlots.put(189, this.addSlotToContainer(new Slot(internal, 189, 23, 179) {
			}));
			this.customSlots.put(190, this.addSlotToContainer(new Slot(internal, 190, 41, 179) {
			}));
			this.customSlots.put(191, this.addSlotToContainer(new Slot(internal, 191, 59, 179) {
			}));
			this.customSlots.put(192, this.addSlotToContainer(new Slot(internal, 192, 77, 179) {
			}));
			this.customSlots.put(193, this.addSlotToContainer(new Slot(internal, 193, 95, 179) {
			}));
			this.customSlots.put(194, this.addSlotToContainer(new Slot(internal, 194, 293, 179) {
			}));
			this.customSlots.put(195, this.addSlotToContainer(new Slot(internal, 195, 311, 179) {
			}));
			this.customSlots.put(196, this.addSlotToContainer(new Slot(internal, 196, 329, 179) {
			}));
			this.customSlots.put(197, this.addSlotToContainer(new Slot(internal, 197, 347, 179) {
			}));
			this.customSlots.put(198, this.addSlotToContainer(new Slot(internal, 198, 365, 179) {
			}));
			this.customSlots.put(199, this.addSlotToContainer(new Slot(internal, 199, 383, 179) {
			}));
			this.customSlots.put(200, this.addSlotToContainer(new Slot(internal, 200, 5, 197) {
			}));
			this.customSlots.put(201, this.addSlotToContainer(new Slot(internal, 201, 23, 197) {
			}));
			this.customSlots.put(202, this.addSlotToContainer(new Slot(internal, 202, 41, 197) {
			}));
			this.customSlots.put(203, this.addSlotToContainer(new Slot(internal, 203, 59, 197) {
			}));
			this.customSlots.put(204, this.addSlotToContainer(new Slot(internal, 204, 77, 197) {
			}));
			this.customSlots.put(205, this.addSlotToContainer(new Slot(internal, 205, 95, 197) {
			}));
			this.customSlots.put(206, this.addSlotToContainer(new Slot(internal, 206, 293, 197) {
			}));
			this.customSlots.put(207, this.addSlotToContainer(new Slot(internal, 207, 311, 197) {
			}));
			this.customSlots.put(208, this.addSlotToContainer(new Slot(internal, 208, 329, 197) {
			}));
			this.customSlots.put(209, this.addSlotToContainer(new Slot(internal, 209, 347, 197) {
			}));
			this.customSlots.put(210, this.addSlotToContainer(new Slot(internal, 210, 365, 197) {
			}));
			this.customSlots.put(211, this.addSlotToContainer(new Slot(internal, 211, 383, 197) {
			}));
			this.customSlots.put(212, this.addSlotToContainer(new Slot(internal, 212, 5, 215) {
			}));
			this.customSlots.put(213, this.addSlotToContainer(new Slot(internal, 213, 23, 215) {
			}));
			this.customSlots.put(214, this.addSlotToContainer(new Slot(internal, 214, 41, 215) {
			}));
			this.customSlots.put(215, this.addSlotToContainer(new Slot(internal, 215, 59, 215) {
			}));
			this.customSlots.put(216, this.addSlotToContainer(new Slot(internal, 216, 77, 215) {
			}));
			this.customSlots.put(217, this.addSlotToContainer(new Slot(internal, 217, 95, 215) {
			}));
			this.customSlots.put(218, this.addSlotToContainer(new Slot(internal, 218, 293, 215) {
			}));
			this.customSlots.put(219, this.addSlotToContainer(new Slot(internal, 219, 311, 215) {
			}));
			this.customSlots.put(220, this.addSlotToContainer(new Slot(internal, 220, 329, 215) {
			}));
			this.customSlots.put(221, this.addSlotToContainer(new Slot(internal, 221, 347, 215) {
			}));
			this.customSlots.put(222, this.addSlotToContainer(new Slot(internal, 222, 365, 215) {
			}));
			this.customSlots.put(223, this.addSlotToContainer(new Slot(internal, 223, 383, 215) {
			}));
			this.customSlots.put(224, this.addSlotToContainer(new Slot(internal, 224, 5, 233) {
			}));
			this.customSlots.put(225, this.addSlotToContainer(new Slot(internal, 225, 23, 233) {
			}));
			this.customSlots.put(226, this.addSlotToContainer(new Slot(internal, 226, 41, 233) {
			}));
			this.customSlots.put(227, this.addSlotToContainer(new Slot(internal, 227, 59, 233) {
			}));
			this.customSlots.put(228, this.addSlotToContainer(new Slot(internal, 228, 77, 233) {
			}));
			this.customSlots.put(229, this.addSlotToContainer(new Slot(internal, 229, 95, 233) {
			}));
			this.customSlots.put(230, this.addSlotToContainer(new Slot(internal, 230, 293, 233) {
			}));
			this.customSlots.put(231, this.addSlotToContainer(new Slot(internal, 231, 311, 233) {
			}));
			this.customSlots.put(232, this.addSlotToContainer(new Slot(internal, 232, 329, 233) {
			}));
			this.customSlots.put(233, this.addSlotToContainer(new Slot(internal, 233, 347, 233) {
			}));
			this.customSlots.put(234, this.addSlotToContainer(new Slot(internal, 234, 365, 233) {
			}));
			this.customSlots.put(235, this.addSlotToContainer(new Slot(internal, 235, 383, 233) {
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 115 + 8 + sj * 18, 85 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlotToContainer(new Slot(player.inventory, si, 115 + 8 + si * 18, 85 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 236) {
					if (!this.mergeItemStack(itemstack1, 236, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 236, false)) {
					if (index < 236 + 27) {
						if (!this.mergeItemStack(itemstack1, 236 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 236, 236 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem()
							&& (!stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata())
							&& ItemStack.areItemStackTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.splitStack(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.splitStack(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				TheProsGameMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class GuiWindow extends GuiContainer {
		private World world;
		private int x, y, z;
		private EntityPlayer entity;
		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 406;
			this.ySize = 256;
		}
		private static final ResourceLocation texture = new ResourceLocation("the_pros_game:textures/pro_chest_gui.png");
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawModalRectWithCustomSizedTexture(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			zLevel = 100.0F;
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			this.fontRenderer.drawString("Pro Chest", 175, 7, -12829636);
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 406) / 2;
			this.guiTop = (this.height - 256) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			TheProsGameMod.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {
		int buttonID, x, y, z;
		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
	}

	public static class GUISlotChangedMessage implements IMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}
	}
	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
