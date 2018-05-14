package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerOption;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.PacketHeader;
import io.titan.net.packet.Sendable;

/**
 * Shows a context menu while right clicking another player.
 *
 * @author Seven
 */
public final class SetPlayerOptionPacket implements Sendable {

  /**
   * The option to display.
   */
  private PlayerOption option;

  /**
   * If this option should be shown on top.
   */
  private boolean top;

  /**
   * The flag to remove this option.
   */
  private boolean disable;

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   */
  public SetPlayerOptionPacket(PlayerOption option) {
    this(option, false, false);
  }

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   *
   * @param disable The flag to remove the context menu.
   */
  public SetPlayerOptionPacket(PlayerOption option, boolean disable) {
    this(option, false, disable);
  }

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   *
   * @param top The flag to display this as the first option.
   *
   * @param disable The flag to remove this option.
   */
  public SetPlayerOptionPacket(PlayerOption option, boolean top, boolean disable) {
    this.option = option;
    this.top = top;
    this.disable = disable;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(104, PacketHeader.VARIABLE_BYTE);

    builder.write(option.getSlot(), ByteModification.NEGATION)
        .write(top ? 1 : 0, ByteModification.ADDITION)
        .writeString(disable ? "null" : option.getName());
    return builder.toOutgoingPacket();
  }

}
