package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.mob.npc.Npc;

public final class NpcSecondClickEvent implements Event {

  private final Npc npc;

  public NpcSecondClickEvent(Npc npc) {
    this.npc = npc;
  }

  public Npc getNpc() {
    return npc;
  }

}
