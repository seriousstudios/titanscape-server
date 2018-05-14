package plugin.click.widget;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.WidgetContainerThirdOptionEvent;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.packet.out.ServerMessagePacket;
import plugin.shops.Shops;

@SubscribesTo(WidgetContainerThirdOptionEvent.class)
public final class WidgetContainerThirdClick implements EventSubscriber<WidgetContainerThirdOptionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, WidgetContainerThirdOptionEvent event) {
		if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket("[WidgetContainerThirdClick] widgetId: " + event.getWidgetId()
					+ " id: " + event.getItemId() + " slot: " + event.getItemSlot()));
		}

		switch (event.getWidgetId()) {
		
        case 3823:
        	Shops.search(player).ifPresent(it -> it.sell(player, new Item(event.getItemId(), 5), event.getItemSlot()));
            break;
		
        case 3900:
            Shops.search(player).ifPresent(it -> it.purchase(player, new Item(event.getItemId(), 5)));
            break;

		case 5064:
			player.getBank().depositFromInventory(event.getItemSlot(), 10);
			break;

		case 5382:
			player.getBank().withdraw(event.getItemSlot(), 10, true);
			break;

		}
	}

}
