package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that plays a song.
 * 
 * @author SeVen
 */
public final class PlaySongPacket implements Sendable {

  /**
   * The id of the song.
   */
  private final int id;

  /**
   * Creates a new {@link PlaySongPacket}.
   * 
   * @param id The id of the song.
   */
  public PlaySongPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(74);
    if (!player.attr().get(Player.MUSIC_KEY) || id == -1) {
      return Optional.empty();
    }
    builder.writeShort(id, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
