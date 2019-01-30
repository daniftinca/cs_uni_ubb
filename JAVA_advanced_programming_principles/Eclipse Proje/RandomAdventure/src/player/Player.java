package player;
/**
 * This is the player object. Holds the name,health,exp,level
 * @author Dan
 *
 */
public class Player {

	private String name;
	private int health = 100;
	private int exp = 0;
	private int level = 1;
	private int strength, agility, intelligence;
	
	public Player(String name,int strength, int agility, int intelligence) {
		super();
		this.name = name;
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
}
