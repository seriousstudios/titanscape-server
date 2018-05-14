package io.titan.net.packet.in;

import io.titan.game.world.World;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.PLAYER_OPTION_2)
public final class PlayerSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int otherPlayerIndex = reader.readShort(ByteOrder.LITTLE);
    Player other = World.getPlayers().get(otherPlayerIndex);

    if (other == null) {
      player
          .queuePacket(new ServerMessagePacket("You tried to attack a player that doesn't exist."));
      return;
    }
  }

}
