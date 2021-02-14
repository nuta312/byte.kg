package tests.junit;

import methods.Intersection;
import org.junit.Assert;
import org.junit.Test;



public class ArrayIntersectionTest {

    Intersection in = new Intersection();

    //intersection method should take 2 int arrays
    // and return an array with the matching values in both arrays
    // if any of the array are empty return null;
    // if the are no matching values in neither of the arrays then return empty
    // If any of array is null return null

    // Don't use - return empty array == I ASSUME


    @Test
    public void twoEmptyArrays(){
        Intersection in = new Intersection();
        int[] arr1 = {};
        int [] arr2 = {};
        int [] expected = null;

        int [] actual = in.intersection(arr1,arr2);

        Assert.assertEquals("Two arrays are empty failure",expected,actual);

    }

    @Test
    public void oneEmptyArrayTest(){
        // arr1 = {}
        // arr2 = {22}
        Intersection in = new Intersection();
        int[] arr1 = {};
        int[] arr2 = {22};

        int[] expected = null;
        int[] actual = in.intersection(arr1,arr2);

        Assert.assertEquals("One array empty failure",expected,actual );
    }

    @Test
    public void oneEmptyArrayTest2(){

        // arr1 = {22}
        // arr2 = {}
        Intersection in = new Intersection();
        int[] arr1 = {22};
        int[] arr2 = {};

        int[] expected = null;
        int[] actual = in.intersection(arr1,arr2);

        Assert.assertEquals("One array empty failure",expected,actual );
    }

    @Test
    public void noMatchingValuesTest(){
        // arr1 = {20,24}
        // arr2 = {2}
        Intersection in = new Intersection();
        int[] arr1 = {20,24};
        int[] arr2 = {2};

        int[] expected = {};
        int[] actual = in.intersection(arr1,arr2);

        Assert.assertEquals("No matching array failure", expected,actual);
    }

    @Test
    public void twoMatchingValuesTest(){
        // arr1 = {10,5,25,4};
        //arr2 = {3,4,60,10};

        int[] arr1 = {10,5,25,4};
        int[] arr2 = {3,4,60,10};

        int[] expected = {10, 4, 0, 0, 0, 0, 0, 0};
        int[] actual = in.intersection(arr1,arr2);

        // assertEquals => expected == actual. For objects assertEquals compares hashcode.

        // We can loop trough an expected and actual arrays and compare each value in each index.

     //   Assert.assertEquals("Matching values test failure", expected,actual);
        Assert.assertArrayEquals("Two matching Values Test Failure " , expected,actual);
    }

    @Test
    public void oneArrayIsNull(){
        // arr1 = {null}
        // arr2 = {22,33}

        int[] arr1 = null; // null means object does not exist
        int[] arr2 = {223,445};

        // When your variable is pointing to null, any attempt to use "." For the variable will cause a NullPointException
        int[] expected = null;
        int[] actual = in.intersection(arr1,arr2);


        // When your test fails due to runtime exceptions like NullPointerExceptions before doing the assertions
        //that test is invalid. We need to fix the test so that it fails on assertion only, not anywhere else.
        // And if it does fail before assertion, it should be due to application error.(exception coming from dev code)
        // Our test framework has a problem
        //What do you do when a test case in the framework fails?
        // 1. I rerun the test by itself
        // 2. Find if the test is failing due to assertion or before assertion
        // 3. If before assertion I have to fix the test on my side (test framework side)
        // 4. If in assertion i have to make sure the expected result of the test is valid.
        // 5. And if the expected result is valid and actual result is not per requirements
        // 6. I report the bug

        //Check if the actual is null
        Assert.assertNull("First array is null failure ",actual);

       // Assert.assertArrayEquals("two matching Values Test failure", expected,actual);



    }

    // Task: Fix Intersection method so that all tests in ArrayIntersectionTests pass.
    // Add more test cases. (edge case) get creative.
}
