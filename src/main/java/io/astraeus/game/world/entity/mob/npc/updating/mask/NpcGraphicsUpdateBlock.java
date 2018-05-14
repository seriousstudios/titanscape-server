package io.astraeus.game.world.entity.mob.npc.updating.mask;

import io.astraeus.game.world.entity.mob.npc.Npc;
import io.astraeus.game.world.entity.mob.npc.updating.NpcUpdateBlock;
import io.astraeus.game.world.entity.mob.update.UpdateFlag;
import io.astraeus.net.codec.game.GamePacketBuilder;

public final class NpcGraphicsUpdateBlock extends NpcUpdateBlock {

  public NpcGraphicsUpdateBlock() {
    super(0x80, UpdateFlag.GRAPHICS);
  }

  @Override
  public void encode(Npc entity, GamePacketBuilder builder) {
    builder.writeShort(entity.getGraphic().getId()).writeInt(entity.getGraphic().getHeight());
  }

}
