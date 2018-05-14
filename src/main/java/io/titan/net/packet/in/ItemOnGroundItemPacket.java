package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemOnGroundItemEvent;
import io.titan.game.world.Position;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_GROUND_ITEM)
public final class ItemOnGroundItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int z = reader.readShort(ByteOrder.LITTLE);
    final int used = reader.readShort(false, ByteModification.ADDITION);
    final int id = reader.readShort();
    final int y = reader.readShort(false, ByteModification.ADDITION);
    final int slot = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int x = reader.readShort();

    if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket("used: " + used + " slot: " + slot
          + " groundItem: " + id + " x: " + x + " y: " + y + " z: " + z));
    }

    final Item itemUsed = player.getInventory().get(slot);

    if (itemUsed.getId() != id) {
      return;
    }

    // grab this from a map of ground items, instead of creating the object like this.
    final Item groundItem = new Item(id);

    final Position position = new Position(x, y, z);

    player.post(new ItemOnGroundItemEvent(itemUsed, groundItem, position));

  }

}
