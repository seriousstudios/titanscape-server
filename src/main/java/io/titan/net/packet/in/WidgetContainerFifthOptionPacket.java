package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_5)
public final class WidgetContainerFifthOptionPacket implements Receivable {

  @SuppressWarnings("unused")
  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int itemSlot = reader.readShort(ByteOrder.LITTLE);
    int interfaceId = reader.readShort(ByteModification.ADDITION);
    int itemId = reader.readShort(ByteOrder.LITTLE);
  }

}
