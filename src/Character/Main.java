package Character;

public class Main {

	public static void main(String[] args) {
		SkillList skills=new SkillList();
		
		skills.addCraftSkill("Armor");
		
		skills.setSkillFeatBonus("Stealth", 3);
		
		System.out.println("Steath: "+skills.getSkillTotal("Stealth"));
	}

}
