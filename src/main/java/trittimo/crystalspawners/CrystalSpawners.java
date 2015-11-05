package trittimo.crystalspawners;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import trittimo.crystalspawners.eventhandlers.MobDeathHandler;
import trittimo.crystalspawners.proxies.CommonProxy;
import trittimo.crystalspawners.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.MODNAME)
public class CrystalSpawners {
	
	@SidedProxy(clientSide = Reference.Proxy.CLIENT_SIDE, serverSide = Reference.Proxy.SERVER_SIDE)
	public static CommonProxy proxy;
	
	@Instance(value = Reference.MODID)
	public static CrystalSpawners instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDeathHandler());
	}
	
}
