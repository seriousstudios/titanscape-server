package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

/**
 * The packet responsible for removing ground items.
 *
 * @author Vult-R
 */
public final class RemoveGroundItemPacket implements Sendable {

  private final Item item;

  public RemoveGroundItemPacket(Item item) {
    this.item = item;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    final GamePacketBuilder builder = new GamePacketBuilder(156);
    builder.write(0, ByteModification.SUBTRACTION).writeShort(item.getId());
    return builder.toOutgoingPacket();
  }

}
