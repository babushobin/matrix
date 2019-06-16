/**
 * 
 */
package com.rms.matrix;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Babu Shobin Jose
 *
 */
class MatrixTest {

	@Test
	void test_productAdjacent3by3() {
		Matrix m = new Matrix();
		int grid[][] = { { 1, 1, 1 }, { 1, 2, 1 }, { 1, 1, 3 } };
		assertEquals(6, m.findProduct(grid, 3));
	}
	@Test
	void test_productAdjacent3by1() {
		Matrix m = new Matrix();
		int grid[][] = { { 1, 1, 1 } };
		assertEquals(1, m.findProduct(grid, 3));
	}
	@Test
	void test_productAdjacent1by1() {
		Matrix m = new Matrix();
		int grid[][] = { { 1 } };
		assertEquals(Long.MIN_VALUE, m.findProduct(grid, 3));
	}
	@Test
	void test_productAdjacentNull() {
		Matrix m = new Matrix();
		int grid[][] =null;
		assertEquals(Long.MIN_VALUE, m.findProduct(grid, 3));
	}
	
	@Test
	void test_productAdjacent10by10() {
		Matrix m = new Matrix();
		
		  int grid[][] = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75}, {49, 49, 99, 40, 17,
		  81, 18, 57, 60, 87}, {81, 49, 31, 73, 55, 79, 14, 29, 93, 71}, {52, 70, 95,
		  23, 4, 60, 11, 42, 69, 24}, {22, 31, 16, 71, 51, 67, 63, 89, 41, 92}, {24,
		  47, 32, 60, 99, 3, 45, 2, 44, 75}, {32, 98, 81, 28, 64, 23, 67, 10, 26, 38},
		  {67, 26, 20, 68, 2, 62, 12, 20, 95, 63}, {24, 55, 58, 5, 66, 73, 99, 26, 97,
		  17}, {21, 36, 23, 9, 75, 0, 76, 44, 20, 45}};
		 
		assertEquals(667755, m.findProduct(grid, 3));
	}
	@Test
	void test_productAdjacent4by3() {
		Matrix m = new Matrix();
		int grid[][] = { { 1, 1, 1,1 }, { 1, 2, 1,1 }, { 9, 9, 9,1 } };
		assertEquals(9*9*9, m.findProduct(grid, 3));
	}


}
