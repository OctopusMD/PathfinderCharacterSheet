package Character;

import java.util.ArrayList;


public class SkillList {
	private int myStr, myDex, myCon, myInt, myWis, myCha;	//Character stats which are added to certain skills
	private int mySkillRanks[]=new int[32];					//points put into each skill by user
	private int mySkillLists[][]=new int[32][5];			//matrix of modifiers from 0:feats, 1:Race, 2:Traits, 3:items, 4:other
	private ArrayList<int[]> myCraftSkills;					//arraylist for craft skills so you can have more than one
	private ArrayList<int[]> myPerformSkills;				//arraylist for perform skills so you can have more than one
	private ArrayList<int[]> myProfessionSkills;			//arraylist for profession skills so you can have more than one
	private String mySkillNames[]=new String[32];			//the names of each of the skills in mySkillList
	private String mySkillAttr[]=new String[32];			//the corresponding stat of each of the skills in mySkillList
	private ArrayList<String> myCraftSkillNames;			//the name of each craft skill
	private ArrayList<String> myPerformSkillNames;			//the name of each perform skill
	private ArrayList<String> myProfessionSkillNames;		//the name of each profession skill
	private boolean mySkillTraining[]=new boolean[32];		//holds if you can use skill untrained 
	private boolean mySkillPenalty[]=new boolean[32];		//holds if armor check penalty apply
	
	//default constructor
	public SkillList() {
		//initialize all stats to 10 if not given
		myStr=10;
		myDex=10;
		myCon=10;
		myInt=10;
		myWis=10;
		myCha=10;
		
		//call constructor for all arraylists
		myCraftSkills=new ArrayList<int[]>();
		myPerformSkills=new ArrayList<int[]>();
		myProfessionSkills=new ArrayList<int[]>();
		myCraftSkillNames=new ArrayList<String>();
		myPerformSkillNames=new ArrayList<String>();
		myProfessionSkillNames=new ArrayList<String>();
		
		//start all items in mySkillRanks at 0
		for(int i=0; i<32; i++) {
			for(int j=0; j<5; j++) {
				mySkillLists[i][j]=0;
			}
			
			//set all skill ranks to start at 0
			mySkillRanks[i]=0;
		}
		
		//set up mySkillNames
		mySkillNames[0]="Acrobatics";
		mySkillNames[1]="Appraise";
		mySkillNames[2]="Bluff";
		mySkillNames[3]="Climb";
		mySkillNames[4]="Diplomancy";
		mySkillNames[5]="Disable Device";
		mySkillNames[6]="Disguise";
		mySkillNames[7]="Escape Artist";
		mySkillNames[8]="Fly";
		mySkillNames[9]="Handle Animal";
		mySkillNames[10]="Heal";
		mySkillNames[11]="Intimidate";
		mySkillNames[12]="Knowledge(arcana)";
		mySkillNames[13]="Knowledge(dungeoneering)";
		mySkillNames[14]="Knowledge(engineering)";
		mySkillNames[15]="Knowledge(geography)";
		mySkillNames[16]="Knowledge(history)";
		mySkillNames[17]="Knowledge(local)";
		mySkillNames[18]="Knowledge(nature)";
		mySkillNames[19]="Knowledge(nobility)";
		mySkillNames[20]="Knowledge(planes)";
		mySkillNames[21]="Knowledge(religion)";
		mySkillNames[22]="Linguistics";
		mySkillNames[23]="Perception";
		mySkillNames[24]="Ride";
		mySkillNames[25]="Sense Motive";
		mySkillNames[26]="Sleight of Hand";
		mySkillNames[27]="Spellcraft";
		mySkillNames[28]="Stealth";
		mySkillNames[29]="Survival";
		mySkillNames[30]="Swim";
		mySkillNames[31]="Use Magic Device";
		
		//set up mySkillAttr
		mySkillAttr[0]="Dex";
		mySkillAttr[1]="Int";
		mySkillAttr[2]="Cha";
		mySkillAttr[3]="Str";
		mySkillAttr[4]="Cha";
		mySkillAttr[5]="Dex";
		mySkillAttr[6]="Cha";
		mySkillAttr[7]="Dex";
		mySkillAttr[8]="Dex";
		mySkillAttr[9]="Cha";
		mySkillAttr[10]="Wis";
		mySkillAttr[11]="Cha";
		mySkillAttr[12]="Int";
		mySkillAttr[13]="Int";
		mySkillAttr[14]="Int";
		mySkillAttr[15]="Int";
		mySkillAttr[16]="Int";
		mySkillAttr[17]="Int";
		mySkillAttr[18]="Int";
		mySkillAttr[19]="Int";
		mySkillAttr[20]="Int";
		mySkillAttr[21]="Int";
		mySkillAttr[22]="Int";
		mySkillAttr[23]="Wis";
		mySkillAttr[24]="Dex";
		mySkillAttr[25]="Wis";
		mySkillAttr[26]="Dex";
		mySkillAttr[27]="Int";
		mySkillAttr[28]="Dex";
		mySkillAttr[29]="Wis";
		mySkillAttr[30]="Str";
		mySkillAttr[31]="Cha";
		
		//set up mySkillTraining
		mySkillTraining[0]=false;
		mySkillTraining[1]=false;
		mySkillTraining[2]=false;
		mySkillTraining[3]=false;
		mySkillTraining[4]=false;
		mySkillTraining[5]=true;
		mySkillTraining[6]=false;
		mySkillTraining[7]=false;
		mySkillTraining[8]=false;
		mySkillTraining[9]=true;
		mySkillTraining[10]=false;
		mySkillTraining[11]=false;
		mySkillTraining[12]=true;
		mySkillTraining[13]=true;
		mySkillTraining[14]=true;
		mySkillTraining[15]=true;
		mySkillTraining[16]=true;
		mySkillTraining[17]=true;
		mySkillTraining[18]=true;
		mySkillTraining[19]=true;
		mySkillTraining[20]=true;
		mySkillTraining[21]=true;
		mySkillTraining[22]=true;
		mySkillTraining[23]=false;
		mySkillTraining[24]=false;
		mySkillTraining[25]=false;
		mySkillTraining[26]=false;
		mySkillTraining[27]=true;
		mySkillTraining[28]=false;
		mySkillTraining[29]=false;
		mySkillTraining[30]=false;
		mySkillTraining[31]=true;
		
		//set up mySkillPenalty
		mySkillPenalty[0]=true;
		mySkillPenalty[1]=false;
		mySkillPenalty[2]=false;
		mySkillPenalty[3]=true;
		mySkillPenalty[4]=false;
		mySkillPenalty[5]=true;
		mySkillPenalty[6]=false;
		mySkillPenalty[7]=true;
		mySkillPenalty[8]=true;
		mySkillPenalty[9]=false;
		mySkillPenalty[10]=false;
		mySkillPenalty[11]=false;
		mySkillPenalty[12]=false;
		mySkillPenalty[13]=false;
		mySkillPenalty[14]=false;
		mySkillPenalty[15]=false;
		mySkillPenalty[16]=false;
		mySkillPenalty[17]=false;
		mySkillPenalty[18]=false;
		mySkillPenalty[19]=false;
		mySkillPenalty[20]=false;
		mySkillPenalty[21]=false;
		mySkillPenalty[22]=false;
		mySkillPenalty[23]=false;
		mySkillPenalty[24]=true;
		mySkillPenalty[25]=false;
		mySkillPenalty[26]=true;
		mySkillPenalty[27]=false;
		mySkillPenalty[28]=true;
		mySkillPenalty[29]=false;
		mySkillPenalty[30]=true;
		mySkillPenalty[31]=false;
	}
	
	//constructor with stats given as parameters
	public SkillList(int str, int dex, int con, int it, int wis, int cha) {
		//initialize all stats to 10 if not given
				myStr=str;
				myDex=dex;
				myCon=con;
				myInt=it;
				myWis=wis;
				myCha=cha;
				
				//call constructor for all arraylists
				myCraftSkills=new ArrayList<int[]>();
				myPerformSkills=new ArrayList<int[]>();
				myProfessionSkills=new ArrayList<int[]>();
				
				//start all items in mySkillRanks at 0
				for(int i=0; i<32; i++) {
					for(int j=0; j<5; j++) {
						mySkillLists[i][j]=0;
					}
					
					//set all skill ranks to start at 0
					mySkillRanks[i]=0;
				}
				
				//set up mySkillNames
				mySkillNames[0]="Acrobatics";
				mySkillNames[1]="Appraise";
				mySkillNames[2]="Bluff";
				mySkillNames[3]="Climb";
				mySkillNames[4]="Diplomancy";
				mySkillNames[5]="Disable Device";
				mySkillNames[6]="Disguise";
				mySkillNames[7]="Escape Artist";
				mySkillNames[8]="Fly";
				mySkillNames[9]="Handle Animal";
				mySkillNames[10]="Heal";
				mySkillNames[11]="Intimidate";
				mySkillNames[12]="Knowledge(arcana)";
				mySkillNames[13]="Knowledge(dungeoneering)";
				mySkillNames[14]="Knowledge(engineering)";
				mySkillNames[15]="Knowledge(geography)";
				mySkillNames[16]="Knowledge(history)";
				mySkillNames[17]="Knowledge(local)";
				mySkillNames[18]="Knowledge(nature)";
				mySkillNames[19]="Knowledge(nobility)";
				mySkillNames[20]="Knowledge(planes)";
				mySkillNames[21]="Knowledge(religion)";
				mySkillNames[22]="Linguistics";
				mySkillNames[23]="Perception";
				mySkillNames[24]="Ride";
				mySkillNames[25]="Sense Motive";
				mySkillNames[26]="Sleight of Hand";
				mySkillNames[27]="Spellcraft";
				mySkillNames[28]="Stealth";
				mySkillNames[29]="Survival";
				mySkillNames[30]="Swim";
				mySkillNames[31]="Use Magic Device";
				
				//set up mySkillAttr
				mySkillAttr[0]="Dex";
				mySkillAttr[1]="Int";
				mySkillAttr[2]="Cha";
				mySkillAttr[3]="Str";
				mySkillAttr[4]="Cha";
				mySkillAttr[5]="Dex";
				mySkillAttr[6]="Cha";
				mySkillAttr[7]="Dex";
				mySkillAttr[8]="Dex";
				mySkillAttr[9]="Cha";
				mySkillAttr[10]="Wis";
				mySkillAttr[11]="Cha";
				mySkillAttr[12]="Int";
				mySkillAttr[13]="Int";
				mySkillAttr[14]="Int";
				mySkillAttr[15]="Int";
				mySkillAttr[16]="Int";
				mySkillAttr[17]="Int";
				mySkillAttr[18]="Int";
				mySkillAttr[19]="Int";
				mySkillAttr[20]="Int";
				mySkillAttr[21]="Int";
				mySkillAttr[22]="Int";
				mySkillAttr[23]="Wis";
				mySkillAttr[24]="Dex";
				mySkillAttr[25]="Wis";
				mySkillAttr[26]="Dex";
				mySkillAttr[27]="Int";
				mySkillAttr[28]="Dex";
				mySkillAttr[29]="Wis";
				mySkillAttr[30]="Str";
				mySkillAttr[31]="Cha";
				
				//set up mySkillTraining
				mySkillTraining[0]=false;
				mySkillTraining[1]=false;
				mySkillTraining[2]=false;
				mySkillTraining[3]=false;
				mySkillTraining[4]=false;
				mySkillTraining[5]=true;
				mySkillTraining[6]=false;
				mySkillTraining[7]=false;
				mySkillTraining[8]=false;
				mySkillTraining[9]=true;
				mySkillTraining[10]=false;
				mySkillTraining[11]=false;
				mySkillTraining[12]=true;
				mySkillTraining[13]=true;
				mySkillTraining[14]=true;
				mySkillTraining[15]=true;
				mySkillTraining[16]=true;
				mySkillTraining[17]=true;
				mySkillTraining[18]=true;
				mySkillTraining[19]=true;
				mySkillTraining[20]=true;
				mySkillTraining[21]=true;
				mySkillTraining[22]=true;
				mySkillTraining[23]=false;
				mySkillTraining[24]=false;
				mySkillTraining[25]=false;
				mySkillTraining[26]=false;
				mySkillTraining[27]=true;
				mySkillTraining[28]=false;
				mySkillTraining[29]=false;
				mySkillTraining[30]=false;
				mySkillTraining[31]=true;
				
				//set up mySkillPenalty
				mySkillPenalty[0]=true;
				mySkillPenalty[1]=false;
				mySkillPenalty[2]=false;
				mySkillPenalty[3]=true;
				mySkillPenalty[4]=false;
				mySkillPenalty[5]=true;
				mySkillPenalty[6]=false;
				mySkillPenalty[7]=true;
				mySkillPenalty[8]=true;
				mySkillPenalty[9]=false;
				mySkillPenalty[10]=false;
				mySkillPenalty[11]=false;
				mySkillPenalty[12]=false;
				mySkillPenalty[13]=false;
				mySkillPenalty[14]=false;
				mySkillPenalty[15]=false;
				mySkillPenalty[16]=false;
				mySkillPenalty[17]=false;
				mySkillPenalty[18]=false;
				mySkillPenalty[19]=false;
				mySkillPenalty[20]=false;
				mySkillPenalty[21]=false;
				mySkillPenalty[22]=false;
				mySkillPenalty[23]=false;
				mySkillPenalty[24]=true;
				mySkillPenalty[25]=false;
				mySkillPenalty[26]=true;
				mySkillPenalty[27]=false;
				mySkillPenalty[28]=true;
				mySkillPenalty[29]=false;
				mySkillPenalty[30]=true;
				mySkillPenalty[31]=false;
	}

	//add new Craft skill with name being parameter name and skill rank of parameter amount
	public void addCraftSkill(String name) {
		//add name to list of craft skills
		myCraftSkillNames.add(name);
		//add array to myCraftSkills
		myCraftSkills.add(new int[6]);
		
		//bonuses initialized to 0
		for(int i=0; i<6; i++) {
			myCraftSkills.get(myCraftSkills.size()-1)[i]=0;
		}
	}
	
	//add new Perform skill with name being parameter name and skill rank of parameter amount
	public void addPerformSkill(String name) {
		//add name to list of Perform skills
		myPerformSkillNames.add(name);
		//add array to myPerformSkills
		myPerformSkills.add(new int[6]);
		
		//bonuses initialized to 0
		for(int i=0; i<6; i++) {
			myPerformSkills.get(myPerformSkills.size()-1)[i]=0;
		}
	}
	
	//add new Profession skill with name being parameter name and skill rank of parameter amount
	public void addProfessionSkill(String name) {
		//add name to list of Perform skills
		myProfessionSkillNames.add(name);
		//add array to myPerformSkills
		myProfessionSkills.add(new int[6]);
		
		//bonuses initialized to 0
		for(int i=0; i<6; i++) {
			myProfessionSkills.get(myProfessionSkills.size()-1)[i]=0;
		}
	}
	
	//remove skill in spot parameter place from CraftSkills and CraftSkillNames
	public void removeCraftSkill(int place) {
		myCraftSkillNames.remove(place);
		myCraftSkills.remove(place);
	}
	
	//remove skill in spot parameter place from CraftSkills and CraftSkillNames
	public void removePerformSkill(int place) {
		myPerformSkillNames.remove(place);
		myPerformSkills.remove(place);
	}
	
	//remove skill in spot parameter place from CraftSkills and CraftSkillNames
	public void removeProfessionSkill(int place) {
		myProfessionSkillNames.remove(place);
		myProfessionSkills.remove(place);
	}
	
	//change the skill rank to parameter amount of skill with the same name as parameter name
	public void setSkillRank(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillRanks[i]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[0]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[0]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[0]=amount;
					return;
				}
			}
		}
	}
	
	//change the skill's feat bonus to parameter amount of skill with the same name as parameter name
	public void setSkillFeatBonus(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillLists[i][0]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[1]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[1]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[1]=amount;
					return;
				}
			}
		}
	}
	
	//change the skill's race bonus to parameter amount of skill with the same name as parameter name
	public void setSkillRaceBonus(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillLists[i][1]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[2]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[2]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[2]=amount;
					return;
				}
			}
		}
	}
	
	//change the skill's trait bonus to parameter amount of skill with the same name as parameter name
	public void setSkillTraitBonus(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillLists[i][2]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[3]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[3]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[3]=amount;
					return;
				}
			}
		}
	}
	
	//change the skill's item bonus to parameter amount of skill with the same name as parameter name
	public void setSkillItemBonus(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillLists[i][3]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[4]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[4]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[4]=amount;
					return;
				}
			}
		}
	}
	
	//change the skill's other bonus to parameter amount of skill with the same name as parameter name
	public void setSkillOtherBonus(String name, int amount) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				mySkillLists[i][4]=amount;
				return;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					myCraftSkills.get(i)[5]=amount;
					return;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					myPerformSkills.get(i)[5]=amount;
					return;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					myProfessionSkills.get(i)[5]=amount;
					return;
				}
			}
		}
	}

	//get the total value for given skill parameter name
	public int getSkillTotal(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//calculate total
				int total=mySkillRanks[i];	
				for(int j=0; j<5; j++) {
					total+=mySkillLists[i][j];
				}
				
				return total;
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//calculate total
					int total=0;
					for(int j=0; j<6; j++) {
						total+=myCraftSkills.get(i)[j];
					}
					
					return total;
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//calculate total
					int total=0;
					for(int j=0; j<6; j++) {
						total+=myPerformSkills.get(i)[j];
					}
					
					return total;
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//calculate total
					int total=0;
					for(int j=0; j<6; j++) {
						total+=myPerformSkills.get(i)[j];
					}
					
					return total;
				}
			}
		}
		
		return 0;
	}
	
	//get the skill rank for given skill parameter name
	public int getSkillRank(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return rank			
				return mySkillRanks[i];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return rank
					return myCraftSkills.get(i)[0];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return rank
					return myPerformSkills.get(i)[0];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[0];
				}
			}
		}
		
		return 0;
	}
	
	//get the Feat Bonus for given skill parameter name
	public int getFeatBonus(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return bonus			
				return mySkillLists[i][0];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return bonus
					return myCraftSkills.get(i)[1];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return bonus
					return myPerformSkills.get(i)[1];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[1];
				}
			}
		}
		
		return 0;
	}
	
	//get the Race Bonus for given skill parameter name
	public int getRaceBonus(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return bonus			
				return mySkillLists[i][1];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return bonus
					return myCraftSkills.get(i)[2];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return bonus
					return myPerformSkills.get(i)[2];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[2];
				}
			}
		}
		
		return 0;
	}
	
	//get the Trait Bonus for given skill parameter name
	public int getTraitBonus(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return bonus			
				return mySkillLists[i][2];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return bonus
					return myCraftSkills.get(i)[3];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return bonus
					return myPerformSkills.get(i)[3];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[3];
				}
			}
		}
		
		return 0;
	}
	
	//get the Item Bonus for given skill parameter name
	public int getItemBonus(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return bonus			
				return mySkillLists[i][3];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return bonus
					return myCraftSkills.get(i)[4];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return bonus
					return myPerformSkills.get(i)[4];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[4];
				}
			}
		}
		
		return 0;
	}
	
	//get the other bonus for given skill parameter name
	public int getOtherBonus(String name) {
		//check to see if name is one of the skills in mySkillNames
		for(int i=0; i<mySkillNames.length;i++) {
			//skill found
			if(name.equalsIgnoreCase(mySkillNames[i])) {
				//return bonus			
				return mySkillLists[i][4];
			}
		}
		
		//myCraftSkillNames has saved skill names
		if(myCraftSkillNames.size()!=0) {
			//check to see if name is one of the skills in myCraftSkillNames
			for(int i=0; i<myCraftSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myCraftSkillNames.get(i))) {
					//return bonus
					return myCraftSkills.get(i)[5];
				}
			}
		}
		
		//myPerformSkillNames has saved skill names
		if(myPerformSkillNames.size()!=0) {
			//check to see if name is one of the skills in myPerformSkillNames
			for(int i=0; i<myPerformSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myPerformSkillNames.get(i))) {
					//return bonus
					return myPerformSkills.get(i)[5];
				}
			}
		}
		//myProfessionSkillNames has saved skill names
		if(myProfessionSkillNames.size()!=0) {
			//check to see if name is one of the skills in myProfessionSkillNames
			for(int i=0; i<myProfessionSkillNames.size(); i++) {
				//skill found
				if(name.equalsIgnoreCase(myProfessionSkillNames.get(i))) {
					//return rank
					return myProfessionSkills.get(i)[5];
				}
			}
		}
		
		return 0;
	}
}
