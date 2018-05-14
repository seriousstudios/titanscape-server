package plugin.click.npc;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.NpcFirstClickEvent;
import io.titan.game.world.entity.mob.player.Player;
import plugin.dialog.AppearanceDialogue;
import plugin.dialog.BankerDialogue;
import plugin.dialog.DefaultDialogue;
import plugin.dialog.GeneralStoreDialogue;

@SubscribesTo(NpcFirstClickEvent.class)
public final class NpcFirstClick implements EventSubscriber<NpcFirstClickEvent> {

  @Override
  public void subscribe(EventContext context, Player player, NpcFirstClickEvent event) {
    switch (event.getNpc().getId()) {

      case 494:
      case 495:
        player.getDialogueFactory().sendDialogue(new BankerDialogue());
        break;

      case 599:
        player.getDialogueFactory().sendDialogue(new AppearanceDialogue());
        break;

      case 528:
        player.getDialogueFactory().sendDialogue(new GeneralStoreDialogue());
        break;

      default:
        player.getDialogueFactory().sendDialogue(new DefaultDialogue(event.getNpc().getId()));
        break;

    }
  }

}
