package com.amazon.ata.unittesting.texttruncator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the <code>TextTruncator</code> behavior.
 */
public class TextTruncatorTest {
    @Test
    public void truncateTo_stringLongerThanNumChars_shortensToFirstNumChars() {
        // GIVEN
        String original = "One two three four five";
        TextTruncator truncator = new TextTruncator(original);

        // WHEN
        String truncatedString = truncator.truncateTo(7);

        // THEN
        Assertions.assertEquals("One two", truncatedString,
                                "Expected to truncate to the first 7 characters");

    }

    /* ADD YOUR TESTS HERE */
    @Test
    public void truncateTo_receivesNullString_returnsEmptyString() {
        String original = null;
        TextTruncator truncator = new TextTruncator(original);

        String truncatedString = truncator.truncateTo(10);

        Assertions.assertEquals("", truncatedString,"Expected to return an empty string: '' ");
    }

    @Test
    public void truncateTo_stringLongerThanNumChars_shortensToDesiredLength() {
        String original = "I want to truncate you as nicely as possible.";
        TextTruncator truncator = new TextTruncator(original);

        String truncatedString = truncator.truncateTo(9);

        Assertions.assertEquals(9,truncatedString.length(), "Expected truncated length to be 8 characters long");

    }

    @Test
    public void truncateTo_stringShorterThanNumChars_doesNotAppendSuffix() {
        String original = "I am short enough; don't touch me!";
        TextTruncator truncator = new TextTruncator(original);

        String truncatedString = truncator.truncateTo(34, "!");

        Assertions.assertEquals(original, truncatedString, "Expected the string to remain untouched");
    }


}
