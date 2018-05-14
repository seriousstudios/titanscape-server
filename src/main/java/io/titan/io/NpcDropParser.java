package io.titan.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

import io.titan.game.world.entity.mob.npc.drop.NpcDrop;
import io.titan.util.GsonObjectParser;

public final class NpcDropParser extends GsonObjectParser<NpcDrop> {

  public NpcDropParser() {
    super("./data/npc/npc_drops");
  }

  @Override
  public NpcDrop[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, NpcDrop[].class);
  }

  @Override
  public void onRead(NpcDrop[] array) throws IOException {
    Arrays.stream(array).forEach(it -> NpcDrop.npcDrops.put(it.getNpcId(), it.getDrops()));
  }

}
