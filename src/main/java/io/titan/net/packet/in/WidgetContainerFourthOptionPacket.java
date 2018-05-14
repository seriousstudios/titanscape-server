package io.titan.net.packet.in;

import io.titan.game.event.impl.WidgetContainerFourthOptionEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_4)
public final class WidgetContainerFourthOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemSlot = reader.readShort(ByteModification.ADDITION);
    final int widgetId = reader.readShort();
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new WidgetContainerFourthOptionEvent(widgetId, itemId, itemSlot));
  }

}
