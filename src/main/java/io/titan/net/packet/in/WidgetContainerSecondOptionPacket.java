package io.titan.net.packet.in;

import io.titan.game.event.impl.WidgetContainerSecondOptionEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_2)
public final class WidgetContainerSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int widgetId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int itemId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int itemSlot = reader.readShort(ByteOrder.LITTLE);

    player.post(new WidgetContainerSecondOptionEvent(widgetId, itemId, itemSlot));
  }

}
