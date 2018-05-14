package io.titan.net.packet.in;

import io.titan.game.world.World;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.PLAYER_OPTION_3)
public final class PlayerThirdOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int otherPlayerIndex = reader.readShort(ByteOrder.LITTLE);

    if (World.getPlayers().get(otherPlayerIndex) == null) {
      return;
    }

    @SuppressWarnings("unused")
    final Player leader = World.getPlayers().get(otherPlayerIndex);
  }

}
