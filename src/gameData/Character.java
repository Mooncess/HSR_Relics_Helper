package gameData;

import enums.MainStat;
import enums.PlanetarySet;
import enums.RelicSet;
import enums.SubsidiaryStat;

public abstract class Character {
	String name;
	
	RelicSet[] bestRelicSet;
	RelicSet[] altRelicSet;
	
	PlanetarySet planetarySet;
	PlanetarySet[] altPlanetarySet;
	
	MainStat[] mainBodyStat;
	MainStat[] mainFeetStat;
	MainStat[] mainPlanarSphereStat;
	MainStat[] mainLinkRopeStat;
	
	SubsidiaryStat[] subStatTier_1;
	SubsidiaryStat[] subStatTier_2;
	SubsidiaryStat[] subStatTier_3;
}
