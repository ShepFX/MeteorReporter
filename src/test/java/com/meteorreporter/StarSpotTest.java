package com.meteorreporter;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Guards the region table. Nothing else would notice if a region string the telescope can emit
 * stopped resolving to anything - the Scouted tab would quietly show no sites and no error.
 */
public class StarSpotTest
{
	@Test
	public void everyRegionTheTelescopeCanNameResolvesToSites()
	{
		for (String region : TelescopeHint.regionNames())
		{
			List<String> sites = StarSpot.sitesIn(region);
			assertFalse("no landing sites for telescope region: " + region, sites.isEmpty());
		}
	}

	@Test
	public void pairedAndShortRegionNamesAgree()
	{
		assertEquals(StarSpot.sitesIn("Piscatoris and the Gnome Stronghold"),
			StarSpot.sitesIn("Gnome Stronghold"));
		assertEquals(StarSpot.sitesIn("Crandor and Karamja"), StarSpot.sitesIn("Karamja"));
		assertEquals(StarSpot.sitesIn("Kharidian Desert"), StarSpot.sitesIn("Desert"));
	}

	@Test
	public void namesTheSitesInARegion()
	{
		List<String> asgarnia = StarSpot.sitesIn("Asgarnia");
		assertEquals(6, asgarnia.size());
		assertTrue(asgarnia.contains("Rimmington mine"));
		assertTrue(asgarnia.contains("Taverley house portal"));
		assertFalse(asgarnia.contains("Varrock east bank"));
	}

	@Test
	public void anUnknownRegionIsEmptyRatherThanNull()
	{
		assertTrue(StarSpot.sitesIn("Atlantis").isEmpty());
		assertTrue(StarSpot.sitesIn(null).isEmpty());
	}

	@Test
	public void timeLeftReadsAsADuration()
	{
		assertEquals("gone", MeteorReporterPanel.timeLeft(0));
		assertEquals("gone", MeteorReporterPanel.timeLeft(-3));
		assertEquals("28m", MeteorReporterPanel.timeLeft(28));
		assertEquals("1h", MeteorReporterPanel.timeLeft(60));
		assertEquals("1h 3m", MeteorReporterPanel.timeLeft(63));
	}

	@Test
	public void theRankLadderClimbsWithoutGaps()
	{
		assertEquals("Reporter", MeteorReporterPanel.rankName(0));
		assertEquals("Spotter", MeteorReporterPanel.rankName(5));
		assertEquals("Scout", MeteorReporterPanel.rankName(15));
		assertEquals("Prospector", MeteorReporterPanel.rankName(71));
		assertEquals("Legend", MeteorReporterPanel.rankName(1500));
		assertEquals("Legend", MeteorReporterPanel.rankName(99999));
		// Every count must name something, and the colour must track the name.
		String previous = null;
		for (int count = 0; count <= 1600; count++)
		{
			String rank = MeteorReporterPanel.rankName(count);
			assertFalse("no rank at " + count, rank == null || rank.isEmpty());
			if (!rank.equals(previous))
			{
				assertFalse("colour repeats across a rank change at " + count,
					previous != null && MeteorReporterPanel.rankColor(count)
						.equals(MeteorReporterPanel.rankColor(count - 1)));
				previous = rank;
			}
		}
	}
}
