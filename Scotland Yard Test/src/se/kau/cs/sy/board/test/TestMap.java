package se.kau.cs.sy.board.test;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import se.kau.cs.sy.board.Board;
import se.kau.cs.sy.board.TransportType;

public class TestMap {

	@Test
	public void testMapLoaded() {
		Board map = Board.create();
		assertNotNull("Map was not loaded", map);
	}

	@Test
	public void testLinksForNode1() {
		Board map = Board.create();
		assertTrue("Wrong number of links for node 1", map.getLinks(1).size()==5);
	}
	
	@Test
	public void testNeighboursOfNode1() {
		Board map = Board.create();
		Set<Integer> neighbours = map.getNeighbourNodes(1);
		Set<Integer> expected = new HashSet<>();
		expected.add(8);
		expected.add(9);
		expected.add(46);
		expected.add(58);
		assertTrue("Set of neighbours for node 1 is wrong: " + neighbours.toString(),
				neighbours.containsAll(expected) && expected.containsAll(neighbours));
	}
	
	@Test
	public void testBusNeighboursOf1() {
		Board map = Board.create();
		Set<Integer> neighbours = map.getNeighbourNodes(1, TransportType.BUS);
		Set<Integer> expected = new HashSet<>();
		expected.add(46);
		expected.add(58);
		assertTrue("Set of bus neighbours for node 1 is wrong: " + neighbours.toString(),
				neighbours.containsAll(expected) && expected.containsAll(neighbours));
	}
}
