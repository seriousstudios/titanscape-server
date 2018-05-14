package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode({IncomingPacket.TYPE_ON_WIDGET})
public final class TypeOnWidgetPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
