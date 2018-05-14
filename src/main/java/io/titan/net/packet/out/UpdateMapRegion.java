package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class UpdateMapRegion implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(73);
    player.setLastPosition(player.getPosition().copy());
    builder.writeShort(player.getPosition().getRegionalX() + 6, ByteModification.ADDITION)
        .writeShort(player.getPosition().getRegionalY() + 6);
    return builder.toOutgoingPacket();
  }

}
