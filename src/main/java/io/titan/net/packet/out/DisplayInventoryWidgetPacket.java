package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class DisplayInventoryWidgetPacket implements Sendable {

  private final int widgetId;

  private final int sidebarId;

  public DisplayInventoryWidgetPacket(int widgetId, int sidebarId) {

    this.widgetId = widgetId;
    this.sidebarId = sidebarId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(248);
    builder.writeShort(widgetId, ByteModification.ADDITION).writeShort(sidebarId);
    return builder.toOutgoingPacket();
  }

}
