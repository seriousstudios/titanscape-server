package io.titan.game.world.entity.mob.player.skill;

public class Skill {
	
	  public static final int ATTACK = 0;
	  public static final int DEFENCE = 1;
	  public static final int STRENGTH = 2;
	  public static final int HITPOINTS = 3;
	  public static final int RANGE = 4;
	  public static final int PRAYER = 5;
	  public static final int MAGIC = 6;
	  public static final int COOKING = 7;
	  public static final int WOODCUTTING = 8;
	  public static final int FLETCHING = 9;
	  public static final int FISHING = 10;
	  public static final int FIREMAKING = 11;
	  public static final int CRAFTING = 12;
	  public static final int SMITHING = 13;
	  public static final int MINING = 14;
	  public static final int HERBLORE = 15;
	  public static final int AGILITY = 16;
	  public static final int THIEVING = 17;
	  public static final int SLAYER = 18;
	  public static final int FARMING = 19;
	  public static final int RUNECRAFTING = 20;
	  public static final int CONSTRUCTION = 21;
	  public static final int HUNTER = 22;

	private int skill;

	private int level;

	private transient int maxLevel;

	private double experience;

	public Skill(int skill, int level, double experience) {
		this.skill = skill;
		this.level = maxLevel = level;
		this.experience = experience;
	}

	public double getExperience() {
		return experience;
	}

	public int getLevel() {
		return level;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public int getSkill() {
		return skill;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public String getName() {
		return SkillData.values()[skill].getName();
	}

	@Override
	public String toString() {
		return "[skill: " + skill + ", level: " + level + ", maxLevel: " + maxLevel + ", experience: " + experience
				+ "]";
	}

}