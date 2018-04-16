package lifeGAME;

import static org.junit.Assert.*;

import javax.swing.Timer;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Ignore;
import org.junit.runner.RunWith;

public class WorldMapTest {

	WorldMap map = new WorldMap(); 
	   private final char[][] world = {  //给定初始状态
	    		{ 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }, 
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }, 
	            { 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'N', 'N', 'A', 'A', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'A', 'N', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'N',  'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'A', 'A', 'A', 'N', 'A', 'A', 'N', 'A', 'A', 'N', 'A', 'A',  'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'A', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'A', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'A', 'A', 'A', 'N', 'A', 'A', 'N', 'A', 'A', 'N', 'A', 'A',  'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'A', 'N', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'A', 'N', 'N',  'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'N', 'N', 'A', 'A', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }, 
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
	  
	    }; 
	   private char[][] nextStatus = new char[world.length][world[0].length]; //下一状态
	   
	    private char[][] tempStatus = new char[world.length][world[0].length];  //初始状态
	    
	@Before
	public void setUp() throws Exception {//赋初始值
		      for (int row = 0; row < world.length; row++) {  
		          for (int col = 0; col < world[0].length; col++) {  
		              nextStatus[row][col] = world[row][col];  
		              tempStatus[row][col] = world[row][col]; }
		          } 
		          
	}

	@Test
	public void testChangeCellStatus() {//测试返回值是否正确
		map.startAnimation();
		assertEquals(3,map.neighborsCount(3,3));
	}


	@Test
	public void testStartAnimation() {//测试初始条件值
		map.startAnimation();
		assertEquals('N',nextStatus[2][2]);
		assertEquals('A',nextStatus[3][3]);
	}

	@Test
	public void testCopyWorldMap() {//测试下一状态值
		map.startAnimation();
		assertEquals('N',tempStatus[1][1]);
		assertEquals('A',tempStatus[4][4]);
	}

}
