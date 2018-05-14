package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.PacketHeader;
import io.titan.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that sends a message to a {@link Player}s chatbox.
 * 
 * @author SeVen
 */
public final class ServerMessagePacket implements Sendable {

  /**
   * The message to send.
   */
  private final String message;

  /**
   * Creates a new {@link ServerMessagePacket}.
   */
  public ServerMessagePacket(String message) {
    this.message = message;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(253, PacketHeader.VARIABLE_BYTE);
    builder.writeString(message);
    return builder.toOutgoingPacket();
  }

}
