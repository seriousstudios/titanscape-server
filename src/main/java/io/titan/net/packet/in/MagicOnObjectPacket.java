package io.titan.net.packet.in;

import io.titan.game.event.impl.MagicOnObjectEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;
import io.titan.net.packet.out.ServerMessagePacket;

/**
 * The packet responsible for when the user uses a spell on an object.
 * 
 * @author Freyr
 */
@IncomingPacketOpcode(IncomingPacket.MAGIC_ON_OBJECT)
public final class MagicOnObjectPacket implements Receivable {

	@Override
	public void handlePacket(Player player, IncomingPacket packet) {
		
		ByteBufReader reader = packet.getReader();
		
		final int objectX = reader.readShort(ByteOrder.LITTLE);		
		final int spellId = reader.readShort(false, ByteModification.ADDITION);		
	    final int objectY = reader.readShort(false, ByteModification.ADDITION);
		final int objectId = reader.readShort(ByteOrder.LITTLE); 

		player.post(new MagicOnObjectEvent(spellId, objectId, objectX, objectY));
	    
	    if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket(String.format("[MagicOnObject] used spell: %d on object: %d [x: %d y: %d]", spellId, objectId, objectX, objectY)));
		}
	}

}
