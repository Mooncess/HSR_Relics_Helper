package gameData;

import enums.MainStat;
import enums.SubsidiaryStat;

public class CharacterBuilder {
	private Character character = new Character();
	
	public CharacterBuilder setName(String name) {
		character.setName(name);
		return this;
	}
	
	public CharacterBuilder setBestRelicSet(String[] bestRelicSet) {
		character.bestRelicSet = bestRelicSet;
		return this;
	}
	
	public CharacterBuilder setAltRelicSet(String[] altRelicSet) {
		character.altRelicSet = altRelicSet;
		return this;
	}
	
	public CharacterBuilder setPlanetarySet(String planetarySet) {
		character.planetarySet = planetarySet;
		return this;
	}
	
	public CharacterBuilder setAltPlanetarySet(String[] altPlanetarySet) {
		character.altPlanetarySet = altPlanetarySet;
		return this;
	}
	
	public CharacterBuilder setMainBodyStat(MainStat[] mainBodyStat) {
		character.mainBodyStat = mainBodyStat;
		return this;
	}
	
	public CharacterBuilder setMainFeetStat(MainStat[] mainFeetStat) {
		character.mainFeetStat = mainFeetStat;
		return this;
	}
	
	public CharacterBuilder setMainPlanarSphereStat(MainStat[] mainPlanarSphereStat) {
		character.mainPlanarSphereStat = mainPlanarSphereStat;
		return this;
	}
	
	public CharacterBuilder setMainLinkRopeStat(MainStat[] mainLinkRopeStat) {
		character.mainLinkRopeStat = mainLinkRopeStat;
		return this;
	}
	
	public CharacterBuilder setSubStatTier_1(SubsidiaryStat[] subStatTier_1) {
		character.subStatTier_1 = subStatTier_1;
		return this;
	}
	
	public CharacterBuilder setSubStatTier_2(SubsidiaryStat[] subStatTier_2) {
		character.subStatTier_2 = subStatTier_2;
		return this;
	}
	
	public CharacterBuilder setSubStatTier_3(SubsidiaryStat[] subStatTier_3) {
		character.subStatTier_3 = subStatTier_3;
		return this;
	}
	
	public Character build() {
		return character;
	}
}
