package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class SetSideBarWidgetPacket implements Sendable {

  private final int tabId;

  private final int interfaceId;

  public SetSideBarWidgetPacket(int tabId, int interfaceId) {
    this.tabId = tabId;
    this.interfaceId = interfaceId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(71);
    builder.writeShort(interfaceId).write(tabId, ByteModification.ADDITION);
    return builder.toOutgoingPacket();
  }

}
