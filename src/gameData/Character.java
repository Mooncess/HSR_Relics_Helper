package gameData;

import enums.MainStat;
import enums.SubsidiaryStat;

public class Character {
	String name;
	
	String[] bestRelicSet;
	String[] altRelicSet;
	
	String planetarySet;
	String[] altPlanetarySet;
	
	MainStat[] mainBodyStat;
	MainStat[] mainFeetStat;
	MainStat[] mainPlanarSphereStat;
	MainStat[] mainLinkRopeStat;
	
	SubsidiaryStat[] subStatTier_1;
	SubsidiaryStat[] subStatTier_2;
	SubsidiaryStat[] subStatTier_3;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBestRelicSet(String[] bestRelicSet) {
		this.bestRelicSet = bestRelicSet;
	}
	
	public String[] getBestRelicSet() {
		return bestRelicSet;
	}
	
	public void setAltRelicSet(String[] altRelicSet) {
		this.altRelicSet = altRelicSet;
	}
	
	public String[] getAltRelicSet() {
		return altRelicSet;
	}
	
	public void setPlanetarySet(String planetarySet) {
		this.planetarySet = planetarySet;
	}
	
	public void setAltPlanetarySet(String[] altPlanetarySet) {
		this.altPlanetarySet = altPlanetarySet;
	}
	
	public void setMainBodyStat(MainStat[] mainBodyStat) {
		this.mainBodyStat = mainBodyStat;
	}
	
	public MainStat[] getMainBodyStat() {
		return mainBodyStat;
	}
	
	public void setMainFeetStat(MainStat[] mainFeetStat) {
		this.mainFeetStat = mainFeetStat;
	}
	
	public MainStat[] getMainFeetStat() {
		return mainFeetStat;
	}
	
	public void setMainPlanarSphereStat(MainStat[] mainPlanarSphereStat) {
		this.mainPlanarSphereStat = mainPlanarSphereStat;
	}
	
	public MainStat[] getMainPlanarSphereStat() {
		return mainPlanarSphereStat;
	}
	
	public void setMainLinkRopeStat(MainStat[] mainLinkRopeStat) {
		this.mainLinkRopeStat = mainLinkRopeStat;
	}
	
	public MainStat[] getMainLinkRopeStat() {
		return mainLinkRopeStat;
	}
	
	public void setSubStatTier_1(SubsidiaryStat[] subStatTier_1) {
		this.subStatTier_1 = subStatTier_1;
	}
	
	public SubsidiaryStat[] getSubStatTier_1() {
		return subStatTier_1;
	}
	
	public void setSubStatTier_2(SubsidiaryStat[] subStatTier_2) {
		this.subStatTier_2 = subStatTier_2;
	}
	
	public SubsidiaryStat[] getSubStatTier_2() {
		return subStatTier_2;
	}
	
	public void setSubStatTier_3(SubsidiaryStat[] subStatTier_3) {
		this.subStatTier_3 = subStatTier_3;
	}
	
	public SubsidiaryStat[] getSubStatTier_3() {
		return subStatTier_3;
	}
}
