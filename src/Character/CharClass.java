package Character;
import java.util.ArrayList;

public class CharClass{
	private String myName;								//name of the character class
	private int myLevel;								//the level of the character for this class
	private int myBAB;									//Base attack bonus
	private int myHitDie;								//the type of hit die
	private boolean mySpells;							//true if class can cast spells, false otherwise
	private int[] mySaves = new int[3];					//1: Fortitude Save, 2: Reflex Save, 3: Will Save
	private boolean[] myArmorProf = new boolean[4];		//true if you can equip, false otherwise 1: light armor, 2: medium armor,
														//3: heavy armor, 4: shields
	private ArrayList<String> myWeaponProf;				//list of names of weapons you can equip
	private ArrayList<String> mySkills;					//list of class skills
	private ArrayList<String> myAbilities;				//list of class abilities
	
	//default constructor
	public CharClass(){
		//initialize variables to minimum levels
		myName="None";
		myLevel=0;
		myBAB=0;
		myHitDie=6;
		mySpells=false;
		
		//initialize arrays to hold 0 values
		for(int i=0; i<3; i++) {
			mySaves[i]=0;
		}
		for(int i=0; i<4; i++) {
			myArmorProf[i]=false;
		}
		
		//Initialize arraylists
		myWeaponProf=new ArrayList();
		mySkills=new ArrayList();
		myAbilities=new ArrayList();
	}
	
	//constructor with class name and level as parameters
	public CharClass(String name, int level){
		//save the class name and level
		myName=name;
		myLevel=level;
		
		//get other data from pathfinder srd
		getOnlineData();
	}
	
	//fill out variables based on myClass and myLevel from the pathfinder srd
	private void getOnlineData(){
		//html scraper
	}
	
	//set new name and recompile to match new class
	public void setName(String name){
		myName=name;
		
		//recompile for new class
		getOnlineData();
	}
	
	//set new level and recompile to match new level
	public void setLevel(int level){
		myLevel=level;
		
		//recompile for new level
		getOnlineData();
	}
	
	//set new BAB for class
	public void setBAB(int BAB){
		myBAB=BAB;
	}
	
	//set new hit die for class
	public void setHitDie(int hitDie){
		myHitDie=hitDie;
	}
	
	//set if can cast spells
	public void setSpells(boolean spells){
		mySpells=spells;
	}
	
	//set saves to new array
	public void setSaves(int[] saves){
		mySaves=saves;
	}
	
	//set armor proficencies to match new array
	public void setArmorProf(boolean[] armorProf){
		myArmorProf=armorProf;
	}
	
	//set weapon proficencies to match new arraylist
	public void setWeaponProf(ArrayList<String> weaponProf){
		myWeaponProf=weaponProf;
	}
	
	//set class skills to match new arraylist
	public void setSkills(ArrayList<String> skills){
		mySkills=skills;
	}
	
	//set abilities to match new arraylist
	public void setAbilities(ArrayList<String> abilities){
		myAbilities=abilities;
	}
	
	//get class name
	public String getName(){
		return myName;
	}
	
	//get current level
	public int getLevel(){
		return myLevel;
	}
	
	//get Base Attack Bonus
	public int getBAB(){
		return myBAB;
	}
	
	//get hit die type
	public int getHitDie(){
		return myHitDie;
	}
	
	//get whether or not class can cast spells
	public boolean getSpells(){
		return mySpells;
	}
	
	//get array of saving throw modifiers
	public int[] getSaves(){
		return mySaves;
	}
	
	//get array of armor proficiencies
	public boolean[] getArmorProf(){
		return myArmorProf;
	}
	
	//get arraylist of weapon proficiencies
	public ArrayList<String> getWeaponProf(){
		return myWeaponProf;
	}
	
	//get arraylist of class skills
	public ArrayList<String> getSkills(){
		return mySkills;
	}
	
	//get arraylist of abilities
	public ArrayList<String> getAbilities(){
		return myAbilities;
	}
}