package io.titan.net.packet.in;

import io.titan.game.event.impl.ObjectSecondClickEvent;
import io.titan.game.task.impl.DistancedTask;
import io.titan.game.world.Position;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.object.GameObject;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_2)
public final class ObjectSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int id = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    int y = reader.readShort(ByteOrder.LITTLE);
    int x = reader.readShort(false, ByteModification.ADDITION);

    GameObject object = new GameObject(id, new Position(x, y, player.getPosition().getHeight()));

    if (player == null || object == null || object.getId() != id) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectSecondClickEvent(object));
      }

    });

  }

}
