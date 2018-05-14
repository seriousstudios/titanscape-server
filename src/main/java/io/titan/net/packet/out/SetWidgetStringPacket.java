package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.PacketHeader;
import io.titan.net.packet.Sendable;

public final class SetWidgetStringPacket implements Sendable {

  private final String string;

  private final int id;

  public SetWidgetStringPacket(String string, int id) {
    this.string = string;
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(126, PacketHeader.VARIABLE_SHORT);
    builder.writeString(string).writeShort(id, ByteModification.ADDITION);
    return builder.toOutgoingPacket();
  }
}
