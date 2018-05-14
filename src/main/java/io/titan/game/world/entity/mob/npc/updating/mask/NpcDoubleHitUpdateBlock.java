package io.titan.game.world.entity.mob.npc.updating.mask;

import io.titan.game.world.entity.mob.combat.dmg.Hit;
import io.titan.game.world.entity.mob.npc.Npc;
import io.titan.game.world.entity.mob.npc.updating.NpcUpdateBlock;
import io.titan.game.world.entity.mob.update.UpdateFlag;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;

public final class NpcDoubleHitUpdateBlock extends NpcUpdateBlock {
  private final Hit hit;

  public NpcDoubleHitUpdateBlock(Hit hit) {
    super(0x8, UpdateFlag.HIT);
    this.hit = hit;
  }

  @Override
  public void encode(Npc npc, GamePacketBuilder builder) {
    builder.write(hit.getDamage(), ByteModification.ADDITION)
        .write(hit.getType().getId(), ByteModification.NEGATION)
        // .write(hit.getDamageType().getId()) // custom
        .write(npc.getCurrentHealth(), ByteModification.ADDITION).write(npc.getMaximumHealth());
  }

}
