package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that changes the settings/toggle on a client. This packet is very
 * similar to {@link SetWidgetConfigPacket} however supports integer values.
 * 
 * @author SeVen
 */
public final class SetToggleOnWidgetPacket implements Sendable {

  /**
   * The configuration id.
   */
  private final int id;

  /**
   * The value to change.
   */
  private final int value;

  /**
   * Creates a new {@link SetToggleOnWidgetPacket).
   * 
   * @param id The configuration id.
   * 
   * @param value The value to change.
   */
  public SetToggleOnWidgetPacket(int id, int value) {
    this.id = id;
    this.value = value;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(87);
    builder.writeShort(id, ByteOrder.LITTLE).writeInt(value, ByteOrder.MIDDLE);
    return builder.toOutgoingPacket();
  }

}
