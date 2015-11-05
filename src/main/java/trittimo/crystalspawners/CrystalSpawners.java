package trittimo.crystalspawners;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import trittimo.crystalspawners.proxy.CommonProxy;
import trittimo.crystalspawners.util.Reference;

@Mod(modid = Reference.modid, name = Reference.modname)
public class CrystalSpawners {
	
	@SidedProxy(clientSide = Reference.Proxy.clientSide, serverSide = Reference.Proxy.serverSide)
	public static CommonProxy proxy;
	
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	public void init(FMLInitializationEvent event) {
		
	}
	
}
