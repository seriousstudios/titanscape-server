package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class DisplayMultiIconPacket implements Sendable {

  private final boolean hide;

  public DisplayMultiIconPacket(boolean hide) {
    this.hide = hide;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(61);
    builder.write(hide ? 0 : 1);
    return builder.toOutgoingPacket();
  }

}
