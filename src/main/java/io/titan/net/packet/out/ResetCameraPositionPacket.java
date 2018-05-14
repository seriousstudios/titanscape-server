package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class ResetCameraPositionPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    return new GamePacketBuilder(107).toOutgoingPacket();
  }

}
