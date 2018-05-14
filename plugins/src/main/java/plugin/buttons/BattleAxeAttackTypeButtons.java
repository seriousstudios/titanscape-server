package plugin.buttons;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.combat.def.AttackType;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class BattleAxeAttackTypeButtons extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()){
		case 1704:
			player.setAttackType(AttackType.BATTLEAXE_CHOP);
			break;
			
		case 1705:
			player.setAttackType(AttackType.BATTLEAXE_BLOCK);
			break;
			
		case 1706:
			player.setAttackType(AttackType.BATTLEAXE_SMASH);
			break;
			
		case 1707:
			player.setAttackType(AttackType.BATTLEAXE_HACK);
			break;
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch(event.getButton()) {
		case 1704:
		case 1705:
		case 1706:
		case 1707:
			return true;			
		}
		return false;
	}

}
