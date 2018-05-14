package io.titan.net.packet.in;

import io.titan.game.event.impl.NpcThirdClickEvent;
import io.titan.game.task.impl.DistancedTask;
import io.titan.game.world.World;
import io.titan.game.world.entity.mob.npc.Npc;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode({IncomingPacket.NPC_OPTION_3})
public final class NpcThirdClickPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final Npc npc = World.getNpcs().get(packet.getReader().readShort());

    if (npc == null) {
      return;
    }

    player.startAction(new DistancedTask(player, npc.getPosition(), 2) {

      @Override
      public void onReached() {
        player.setInteractingEntity(npc);
        npc.setInteractingEntity(player);
        player.post(new NpcThirdClickEvent(npc));
        stop();

      }

    });

  }

}