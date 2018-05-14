package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.update.UpdateFlag;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class ForceTabWidgetPacket implements Sendable {

  private final int id;

  public ForceTabWidgetPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(106);
    builder.write(id, ByteModification.NEGATION);
    player.getUpdateFlags().add(UpdateFlag.APPEARANCE);
    return builder.toOutgoingPacket();
  }

}
