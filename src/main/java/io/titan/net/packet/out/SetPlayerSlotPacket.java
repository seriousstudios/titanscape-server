package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class SetPlayerSlotPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {

    GamePacketBuilder builder = new GamePacketBuilder(249);

    builder.write(1, ByteModification.ADDITION).writeShort(player.getSlot(),
        ByteModification.ADDITION, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
