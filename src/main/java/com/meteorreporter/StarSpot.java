package com.meteorreporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.coords.WorldPoint;

final class StarSpot
{
	private static final Map<Long, String> SPOTS = new HashMap<>();
	/** Landing sites by the region a telescope names, so a reading can list what it might mean. */
	private static final Map<String, List<String>> SITES = new HashMap<>();

	static
	{
		spot(2974, 3241, "Rimmington mine", "Asgarnia");
		spot(2940, 3280, "Crafting Guild", "Asgarnia");
		spot(2906, 3355, "West Falador mine", "Asgarnia");
		spot(3030, 3348, "East Falador bank", "Asgarnia");
		spot(3018, 3443, "North Dwarven Mine entrance", "Asgarnia");
		spot(2882, 3474, "Taverley house portal", "Asgarnia");
		spot(2736, 3221, "Brimhaven northwest gold mine", "Crandor and Karamja");
		spot(2742, 3143, "Brimhaven south dungeon entrance", "Crandor and Karamja");
		spot(2845, 3037, "Nature Altar mine north of Shilo", "Crandor and Karamja");
		spot(2827, 2999, "Shilo Village gem mine", "Crandor and Karamja");
		spot(2835, 3296, "North Crandor", "Crandor and Karamja");
		spot(2822, 3238, "South Crandor", "Crandor and Karamja");
		spot(3296, 3298, "Al Kharid mine", "Kharidian Desert");
		spot(3276, 3164, "Al Kharid bank", "Kharidian Desert");
		spot(3341, 3267, "Emir's Arena", "Kharidian Desert");
		spot(3424, 3160, "Northwest of Uzer", "Kharidian Desert");
		spot(3434, 2889, "Nardah bank", "Kharidian Desert");
		spot(3316, 2867, "Agility Pyramid mine", "Kharidian Desert");
		spot(3171, 2910, "Desert Quarry mine", "Kharidian Desert");
		spot(2567, 2858, "Corsair Cove bank", "Feldip Hills and the Isle of Souls");
		spot(2483, 2886, "Corsair Resource Area", "Feldip Hills and the Isle of Souls");
		spot(2468, 2842, "Myths' Guild", "Feldip Hills and the Isle of Souls");
		spot(2571, 2964, "Feldip Hills fairy ring", "Feldip Hills and the Isle of Souls");
		spot(2630, 2993, "Rantz's cave", "Feldip Hills and the Isle of Souls");
		spot(2200, 2792, "Soul Wars south mine", "Feldip Hills and the Isle of Souls");
		spot(3818, 3801, "Fossil Island Volcanic Mine entrance", "Fossil Island and Mos Le'Harmless");
		spot(3774, 3814, "Fossil Island rune rocks", "Fossil Island and Mos Le'Harmless");
		spot(3686, 2969, "Mos Le'Harmless west bank", "Fossil Island and Mos Le'Harmless");
		spot(2727, 3683, "Keldagrim entrance mine", "Fremennik Lands and Lunar Isle");
		spot(2683, 3699, "Rellekka mine", "Fremennik Lands and Lunar Isle");
		spot(2393, 3814, "Jatizso mine entrance", "Fremennik Lands and Lunar Isle");
		spot(2375, 3832, "Neitiznot rune rock", "Fremennik Lands and Lunar Isle");
		spot(2528, 3887, "Miscellania mine", "Fremennik Lands and Lunar Isle");
		spot(2139, 3938, "Lunar Isle mine entrance", "Fremennik Lands and Lunar Isle");
		spot(2602, 3086, "Yanille bank", "Kandarin");
		spot(2624, 3141, "Port Khazard mine", "Kandarin");
		spot(2608, 3233, "Ardougne Monastery", "Kandarin");
		spot(2705, 3333, "South of Legends' Guild", "Kandarin");
		spot(2804, 3434, "Catherby bank", "Kandarin");
		spot(2589, 3478, "Coal Trucks west of Seers' Village", "Kandarin");
		spot(1778, 3493, "Hosidius mine", "Great Kourend");
		spot(1769, 3709, "Port Piscarilius mine", "Great Kourend");
		spot(1597, 3648, "Shayzien mine", "Great Kourend");
		spot(1534, 3747, "South Lovakengj bank", "Great Kourend");
		spot(1437, 3840, "Lovakite mine", "Great Kourend");
		spot(1760, 3853, "Arceuus dense essence mine", "Great Kourend");
		spot(1322, 3816, "Mount Karuulm bank", "Kebos Lowlands");
		spot(1279, 3817, "Mount Karuulm mine", "Kebos Lowlands");
		spot(1210, 3651, "Kebos Swamp mine", "Kebos Lowlands");
		spot(1258, 3564, "Chambers of Xeric bank", "Kebos Lowlands");
		spot(3258, 3408, "Varrock east bank", "Misthalin");
		spot(3290, 3353, "Southeast Varrock mine", "Misthalin");
		spot(3175, 3362, "Champions' Guild mine", "Misthalin");
		spot(3094, 3235, "Draynor Village", "Misthalin");
		spot(3153, 3150, "West Lumbridge Swamp mine", "Misthalin");
		spot(3230, 3155, "East Lumbridge Swamp mine", "Misthalin");
		spot(3635, 3340, "Darkmeyer essence mine entrance", "Morytania");
		spot(3650, 3214, "Theatre of Blood bank", "Morytania");
		spot(3505, 3485, "Canifis bank", "Morytania");
		spot(3500, 3219, "Burgh de Rott bank", "Morytania");
		spot(3451, 3233, "Abandoned Mine west of Burgh de Rott", "Morytania");
		spot(2444, 3490, "West of Grand Tree", "Piscatoris and the Gnome Stronghold");
		spot(2448, 3436, "Gnome Stronghold spirit tree", "Piscatoris and the Gnome Stronghold");
		spot(2341, 3635, "Piscatoris fairy ring", "Piscatoris and the Gnome Stronghold");
		spot(2329, 3163, "Lletya", "Tirannwn");
		spot(2269, 3158, "Isafdar runite rocks", "Tirannwn");
		spot(3274, 6055, "Prifddinas Zalcano entrance", "Tirannwn");
		spot(2318, 3269, "Arandar mine", "Tirannwn");
		spot(2173, 3409, "Mynydd northwest of Prifddinas", "Tirannwn");
		spot(3108, 3569, "Mage of Zamorak mine (level 7 Wilderness)", "Wilderness");
		spot(3018, 3593, "Skeleton mine (level 10 Wilderness)", "Wilderness");
		spot(3093, 3756, "Hobgoblin mine (level 30 Wilderness)", "Wilderness");
		spot(3057, 3887, "Lava Maze runite mine (level 46 Wilderness)", "Wilderness");
		spot(3049, 3940, "Pirates' Hideout (level 53 Wilderness)", "Wilderness");
		spot(3091, 3962, "Mage Arena bank (level 56 Wilderness)", "Wilderness");
		spot(3188, 3932, "Wilderness Resource Area", "Wilderness");
		// Varlamore, from the wiki's mine pages rather than a confirmed landing. An exact-match miss
		// just falls through to "Unknown spot", so a wrong guess costs nothing.
		spot(1282, 3412, "Custodia Mountains mine", "Varlamore");
		spot(1432, 2882, "Mistrock mine", "Varlamore");
	}

	private StarSpot()
	{
	}

	private static void spot(int x, int y, String name, String region)
	{
		SPOTS.put(key(x, y), name);
		SITES.computeIfAbsent(region, unused -> new ArrayList<>()).add(name);
	}

	static String forPoint(WorldPoint point)
	{
		return SPOTS.getOrDefault(key(point.getX(), point.getY()),
			"Unknown spot (" + point.getX() + ", " + point.getY() + ")");
	}

	/**
	 * A telescope says "Piscatoris or the Gnome Stronghold"; readings shared before the parser
	 * understood the paired names say just "Gnome Stronghold". Both have to find the same sites.
	 */
	private static final Map<String, String> ALIASES = new HashMap<>();

	static
	{
		ALIASES.put("Gnome Stronghold", "Piscatoris and the Gnome Stronghold");
		ALIASES.put("Piscatoris", "Piscatoris and the Gnome Stronghold");
		ALIASES.put("Karamja", "Crandor and Karamja");
		ALIASES.put("Crandor", "Crandor and Karamja");
		ALIASES.put("Fossil Island", "Fossil Island and Mos Le'Harmless");
		ALIASES.put("Mos Le'Harmless", "Fossil Island and Mos Le'Harmless");
		ALIASES.put("Feldip Hills", "Feldip Hills and the Isle of Souls");
		ALIASES.put("Isle of Souls", "Feldip Hills and the Isle of Souls");
		ALIASES.put("Fremennik", "Fremennik Lands and Lunar Isle");
		ALIASES.put("Lunar Isle", "Fremennik Lands and Lunar Isle");
		ALIASES.put("Kourend", "Great Kourend");
		ALIASES.put("Kebos", "Kebos Lowlands");
		ALIASES.put("Desert", "Kharidian Desert");
	}

	/**
	 * Every landing site a star could be at, given what the telescope said. A reading names a
	 * region and nothing finer, so this is as close to an answer as scouting can get.
	 */
	static List<String> sitesIn(String region)
	{
		if (region == null) return Collections.emptyList();
		List<String> sites = SITES.get(region);
		if (sites == null) sites = SITES.get(ALIASES.get(region));
		return sites == null ? Collections.emptyList() : Collections.unmodifiableList(sites);
	}

	private static long key(int x, int y)
	{
		return ((long) x << 32) | (y & 0xffffffffL);
	}
}
