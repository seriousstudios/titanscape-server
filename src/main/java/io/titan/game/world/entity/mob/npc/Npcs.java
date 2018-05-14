package io.titan.game.world.entity.mob.npc;

import java.util.concurrent.TimeUnit;

import io.titan.game.GameConstants;
import io.titan.game.world.Position;
import io.titan.game.world.World;
import io.titan.game.world.entity.mob.update.UpdateFlag;
import io.titan.util.RandomUtils;

/**
 * A static-utility class that contains useful methods for npcs.
 * 
 * @author Vult-R
 */
public final class Npcs {

  /**
   * The private constructor to prevent instantiation of this class.
   */
  private Npcs() {

  }

  /**
   * Spawns a {@link Npc} into the game world.
   * 
   * @param spawn The mob to spawn.
   */
  public static void createSpawn(NpcSpawn spawn) {
    final Npc npc = new Npc(spawn.getId());

    if (World.getNpcs().add(npc)) {
      npc.setPosition(spawn.getPosition());
      npc.setCreatedPosition(new Position(spawn.getPosition()));

      npc.setFacingDirection(spawn.getFacing());
      npc.setRadius(spawn.getRadius());
      npc.setRegistered(true);
      npc.setVisible(true);
      npc.getUpdateFlags().add(UpdateFlag.APPEARANCE);
    }

  }

  /**
   * Handles randomly walking movement for a mob.
   * 
   * @param mob The mob to handle.
   */
  public static void handleRandomWalk(Npc mob) {
    if (mob.getRandomWalkTimer().elapsed(TimeUnit.SECONDS) >= 1) {

      if ((RandomUtils.random(5)) == 1) {

        int randomX = RandomUtils.random(-1, 1);
        int randomY = RandomUtils.random(-1, 1);

        Position nextLocation = new Position(mob.getPosition().getX() + randomX,
            mob.getPosition().getY() + randomY, mob.getPosition().getHeight());

        int distance = Position.getDistance(mob.getCreatedPosition(), nextLocation);

        if (mob.getInteractingEntity() == null
            && distance <= GameConstants.NPC_RANDOM_WALK_DISTANCE) {
          mob.getMovement().walk(nextLocation);
        } else if (mob.getInteractingEntity() == null) {
          mob.getMovement().walk(mob.getCreatedPosition());
        }
        mob.getRandomWalkTimer().reset();
      }
    }
  }

  /**
   * Resets the facing direction of an entity to its default direction.
   * 
   * @param mob The mob to reset.
   */
  public static void resetFacingDirection(Npc mob) {
    if (mob.getRadius() != 0 && mob.getInteractingEntity() == null) {
      return;
    }

    mob.setFacingDirection(mob.getFacingDirection());
  }

}
