package plugin.click.widget;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.WidgetContainerFirstOptionEvent;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.packet.out.ServerMessagePacket;
import plugin.shops.Shops;

@SubscribesTo(WidgetContainerFirstOptionEvent.class)
public final class WidgetContainerFirstClick implements EventSubscriber<WidgetContainerFirstOptionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, WidgetContainerFirstOptionEvent event) {
		if (player.getRights().greaterOrEqual(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket("[WidgetContainerFirstClick] widget: " + event.getWidgetId()
					+ " id: " + event.getItemId() + " slot: " + event.getItemSlot()));
		}

		switch (event.getWidgetId()) {

		case 1688:
			player.getEquipment().unequip(event.getItemSlot(), true);
			break;
			
        case 3823:
        	Shops.search(player).ifPresent(it -> it.sendSellingPrice(player, new Item(event.getItemId())));
            break;
			
		case 3900:
			Shops.search(player).ifPresent(it -> it.sendPurchasePrice(player, new Item(event.getItemId())));
			break;

		case 5064:
			player.getBank().depositFromInventory(event.getItemSlot(), 1);
			break;

		case 5382:
			player.getBank().withdraw(event.getItemSlot(), 1, true);
			break;

		}
	}

}
