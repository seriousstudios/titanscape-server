package io.titan.net.packet.in;

import io.titan.game.event.impl.NpcSecondClickEvent;
import io.titan.game.task.impl.DistancedTask;
import io.titan.game.world.World;
import io.titan.game.world.entity.mob.npc.Npc;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode({IncomingPacket.NPC_OPTION_2})
public final class NpcSecondClickPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final Npc npc = World.getNpcs()
        .get(packet.getReader().readShort(ByteOrder.LITTLE, ByteModification.ADDITION));

    if (npc == null) {
      return;
    }

    player.startAction(new DistancedTask(player, npc.getPosition(), 2) {

      @Override
      public void onReached() {
        player.setInteractingEntity(npc);
        npc.setInteractingEntity(player);
        player.post(new NpcSecondClickEvent(npc));
        stop();

      }

    });

  }

}
