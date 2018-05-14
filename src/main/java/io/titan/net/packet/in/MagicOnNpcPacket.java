package io.titan.net.packet.in;

import io.titan.cache.impl.def.NpcDefinition;
import io.titan.game.world.World;
import io.titan.game.world.entity.mob.npc.Npc;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode({IncomingPacket.MAGIC_ON_NPC})
public final class MagicOnNpcPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final int slot = packet.getReader().readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final Npc mobMagic = World.getNpcs().get(slot);
    @SuppressWarnings("unused")
    final int spell = packet.getReader().readShort(ByteModification.ADDITION);

    if (mobMagic == null) {
      player.queuePacket(new ServerMessagePacket("You tried to attack a mob that doesn't exist."));
      return;
    }

    NpcDefinition def = NpcDefinition.lookup(mobMagic.getId());

    if (def == null) {
      return;
    }
  }

}
