package com.scjp.www;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;



public class VersionTest {

    Version underTest;
    // expected error messages
    static final String errorVersionMustNotBeNull = "'version' must not be null";
    static final String errorOtherMustNotBeNull = "'other' must not be null";
    static final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Condition 00 
     * Check the toString() method of Version
     */
    @Test
    public void test2VersionsAreEqual() {
        Version v1 = new Version("2.0.0");
        Version v2 = new Version("2.0.0");
        Assert.assertEquals(v1, v2);
    }

    /**
     * Condition 01
     * Passing null to the constructor throws IllegalArgumentExpection error
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVersionWithEmptyArgument() {
        this.underTest = new Version(null);
        thrown.expectMessage(containsString(errorOtherMustNotBeNull));
    }

    /**
     * Condition 02
     * Passing random string to the constructor throws IllegalArgumentExpection error
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVersionIncorrectExpression() {
        this.underTest = new Version("Pramod");
        thrown.expectMessage(containsString(errorVersionMustMatchPattern));
    }


    /**
     * Condition 03
     * ??
     */


     /**
     * Condition 04
     * Test should pass with valid argument to the Constructor
     */
    @Test(expected = Test.None.class /*No exception expectd*/)
    public void passVersionWithCorrectArgument() {
        this.underTest = new Version("3.8.0-SNAPSHOT");
    }

    /**
     * Condition 05
     * Check Snapshot phrase present to be truthy
     */
    @Test
    public void checkSnapShotPresentToBeTruthy() {
        this.underTest = new Version("3.8.0-SNAPSHOT");
        Assert.assertEquals(true, this.underTest.isSnapshot());
    }

    /**
     * Condition 06
     * Check Snapshot phrase absent to be falsy
     */
    @Test
    public void checkSnapShoAbsentToBeFalsy() {
        this.underTest = new Version("3.8.0");
        Assert.assertEquals(false, this.underTest.isSnapshot());
    }

    /**
     * Condition 07
     * Null Argument to be compared with
     */
    @Test(expected = IllegalArgumentException.class)
    public void passNullArgumentToCompareToThrowsError() {
        this.underTest = new Version("3.8.0-SNAPSHOT");
        underTest.compareTo(null);
        thrown.expectMessage(containsString(errorOtherMustNotBeNull));
    }


}
