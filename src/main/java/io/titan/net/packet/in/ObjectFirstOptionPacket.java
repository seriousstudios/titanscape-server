package io.titan.net.packet.in;

import io.titan.game.event.impl.ObjectFirstClickEvent;
import io.titan.game.task.impl.DistancedTask;
import io.titan.game.world.Position;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.object.GameObject;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_1)
public final class ObjectFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int x = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    int id = reader.readShort(false);
    int y = reader.readShort(false, ByteModification.ADDITION);

    GameObject object = new GameObject(id, new Position(x, y));

    if (player == null || object == null) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectFirstClickEvent(object));
      }

    });

  }

}
