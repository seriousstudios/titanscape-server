package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class DisplayWidgetPacket implements Sendable {

  private final int interfaceId;

  public DisplayWidgetPacket(int interfaceId) {
    this.interfaceId = interfaceId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(97);
    builder.writeShort(interfaceId);
    return builder.toOutgoingPacket();
  }

}
