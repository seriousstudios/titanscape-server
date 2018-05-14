package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public class SetRunEnergyPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(110);
    builder.write(player.getRunEnergy());
    return builder.toOutgoingPacket();
  }

}