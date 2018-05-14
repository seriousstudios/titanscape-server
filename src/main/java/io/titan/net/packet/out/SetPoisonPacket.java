package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.combat.dmg.Poison.PoisonType;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class SetPoisonPacket implements Sendable {

  /**
   * The type of poison.
   */
  private final PoisonType type;

  /**
   * The type of poison.
   */
  public SetPoisonPacket(PoisonType type) {
    this.type = type;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder();
    builder.write(type.getType(), ByteModification.NEGATION);
    return builder.toOutgoingPacket();
  }

}
