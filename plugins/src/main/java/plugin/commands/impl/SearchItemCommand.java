package plugin.commands.impl;

import java.util.Arrays;
import java.util.Objects;

import io.titan.cache.impl.def.ItemDefinition;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.CommandEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.packet.out.ServerMessagePacket;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public class SearchItemCommand extends Command {

  @Override
  protected boolean execute(Player player, CommandParser parser) {
    if (parser.hasNext(1)) {
      
      final String keyword = parser.nextLine().toLowerCase();
      
      Arrays.stream(ItemDefinition.getDefinitions()).filter(Objects::nonNull).filter(it -> it.getName().toLowerCase().contains(keyword)).forEach(it -> player.queuePacket(new ServerMessagePacket(it.getId() + ":" + it.getName())));

      return true;
    }
    return false;
  }

  @Override
  public boolean test(CommandEvent event) {
    return event.getName().equalsIgnoreCase("sitem");
  }

  @Override
  protected PlayerRights rights() {
    return PlayerRights.DEVELOPER;
  }

}
