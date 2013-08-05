package ccm.trade_stuffs.utils.handler;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class WorldHandler {

	@ForgeSubscribe
	public void worldLoad(WorldEvent.Load event) {
		if(event.world.isRemote) {
			return;
		}
		SaveHandler sm = new SaveHandler(event.world.getSaveHandler(), event.world);
		sm.loadBank();
	}

	@ForgeSubscribe
	public void worldSave(WorldEvent.Save event) {
		if(event.world.isRemote) {
			return;
		}
		SaveHandler sm = new SaveHandler(event.world.getSaveHandler(), event.world);
		sm.saveBank();
	}
}
