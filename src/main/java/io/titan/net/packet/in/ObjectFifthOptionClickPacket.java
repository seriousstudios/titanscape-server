package io.titan.net.packet.in;

import io.titan.game.event.impl.ObjectFifthClickEvent;
import io.titan.game.task.impl.DistancedTask;
import io.titan.game.world.Position;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.object.GameObject;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_5)
public final class ObjectFifthOptionClickPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int id = reader.readShort(ByteModification.ADDITION);
    int y = reader.readShort(ByteModification.ADDITION);
    int x = reader.readShort();

    // TODO don't create object like this, this is bad
    GameObject object = new GameObject(id, new Position(x, y, player.getPosition().getHeight()));

    if (player == null || object == null || object.getId() != id) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectFifthClickEvent(object));
      }

    });

  }

}
