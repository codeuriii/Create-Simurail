package com.crystaelix.simurail.content;

import com.crystaelix.simurail.Simurail;
import com.crystaelix.simurail.content.automatic_coupler.AutomaticCouplerBlockEntity;
import com.crystaelix.simurail.content.automatic_coupler.AutomaticCouplerRenderer;
import com.crystaelix.simurail.content.automatic_coupler.AutomaticCouplerVisual;
import com.crystaelix.simurail.content.bogey.PhysicsBogeyBlockEntity;
import com.crystaelix.simurail.content.bogey.PhysicsBogeyRenderer;
import com.crystaelix.simurail.content.bogey.PhysicsBogeyVisual;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class SimurailBlockEntities {

	private static final CreateRegistrate REGISTRATE = Simurail.registrate();

	public static final BlockEntityEntry<PhysicsBogeyBlockEntity> PHYSICS_BOGEY = REGISTRATE.
			blockEntity("physics_bogey", PhysicsBogeyBlockEntity::new).
			visual(() -> PhysicsBogeyVisual::new, false).
			renderer(() -> PhysicsBogeyRenderer::new).
			validBlocks(SimurailBlocks.PHYSICS_BOGEY).
			registerCapability(PhysicsBogeyBlockEntity::registerCapabilities).
			register();
	public static final BlockEntityEntry<AutomaticCouplerBlockEntity> COUPLER = REGISTRATE.
			blockEntity("coupler", AutomaticCouplerBlockEntity::new).
			visual(() -> AutomaticCouplerVisual::new, false).
			renderer(() -> AutomaticCouplerRenderer::new).
			validBlocks(SimurailBlocks.AUTOMATIC_COUPLER).
			register();

	public static void register() {
	}
}
