package io.titan.net.packet.out;

import java.util.Objects;
import java.util.Optional;

import io.titan.game.world.Position;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

/**
 * The {@link Sendable} implementation that displays an item on the ground.
 * 
 * @author Vult-R
 */
public final class AddGroundItemPacket implements Sendable {

  private final Position position;
  
  private final Item item;

  public AddGroundItemPacket(Position position, Item item) {
    this.position = Objects.requireNonNull(position);
    this.item = Objects.requireNonNull(item);
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    player.queuePacket(new SetUpdateRegionPacket(position));
    
    final GamePacketBuilder builder = new GamePacketBuilder(44);
    builder.writeShort(item.getId(), ByteModification.ADDITION, ByteOrder.LITTLE)
        .writeShort(item.getAmount()).write(0); // offset
    return builder.toOutgoingPacket();
  }

}
