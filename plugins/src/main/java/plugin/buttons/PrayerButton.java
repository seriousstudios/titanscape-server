package plugin.buttons;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.combat.CombatPrayer;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class PrayerButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		player.getCombatPrayer().clickButton(event.getButton());
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return CombatPrayer.isPrayerButton(event.getButton());
	}

}
