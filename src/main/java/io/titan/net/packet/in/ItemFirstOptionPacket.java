package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemFirstClickEvent;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_1)
public final class ItemFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int widgetId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int slot = reader.readShort(false, ByteModification.ADDITION);
    final int id = reader.readShort(ByteOrder.LITTLE);

    final Item item = player.getInventory().get(slot);

    if (item.getId() != id) {
      return;
    }

    player.post(new ItemFirstClickEvent(item, widgetId));
  }

}
