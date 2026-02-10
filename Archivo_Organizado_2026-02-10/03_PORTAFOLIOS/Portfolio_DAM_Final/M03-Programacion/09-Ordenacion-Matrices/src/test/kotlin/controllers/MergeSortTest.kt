package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeSortTest {
    //Es comprova que funcioni en cas d'un array de tamany imparell
    @Test
    fun Test1() {
        val arr: IntArray = intArrayOf(5,2,1)
        val expected: IntArray = intArrayOf(1,2,5)
        var ordenat: IntArray = mergeSort(arr)
        assertArrayEquals(ordenat, expected)
    }
    //Es comprova que funcioni en cas de contindre nombres negatius
    @Test
    fun Test2() {
        val arr: IntArray = intArrayOf(5,2,1,-1)
        val expected: IntArray = intArrayOf(-1,1,2,5)
        var ordenat: IntArray = mergeSort(arr)
        assertArrayEquals(ordenat, expected)
    }
    //Es comprova que funcioni en cas d'un array de mida 1
    @Test
    fun Test3() {
        val arr: IntArray = intArrayOf(1)
        val expected: IntArray = intArrayOf(1)
        var ordenat: IntArray = mergeSort(arr)
        assertArrayEquals(ordenat, expected)
    }
    //Es comprova que funcioni en cas d'un array buit
    @Test
    fun Test4() {
        val arr: IntArray = intArrayOf()
        val expected: IntArray = intArrayOf()
        var ordenat: IntArray = mergeSort(arr)
        assertArrayEquals(ordenat, expected)
    }
}