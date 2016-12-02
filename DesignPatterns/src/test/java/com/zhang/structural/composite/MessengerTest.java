package com.zhang.structural.composite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.zhang.structural.composite.Messenger.MESSAGE_FROM_JIM;
import static com.zhang.structural.composite.Messenger.MESSAGE_FROM_LILY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhangxiangdong on 2016/12/2.
 */
public class MessengerTest {

    /**
     * The buffer used to capture every write to {@link System#out}
     */
    private ByteArrayOutputStream stdOutBuffer = new ByteArrayOutputStream();

    /**
     * Keep the original std-out so it can be restored after the test
     */
    private final PrintStream realStdOut = System.out;

    /**
     * Inject the mocked std-out {@link PrintStream} into the {@link System} class before each test
     */
    @Before
    public void setUp() {
        this.stdOutBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOutBuffer));
    }

    @Test
    public void testMessageFromJim() {
        final Messenger messenger = new Messenger();
        testMessage(messenger.messageFromJim(), MESSAGE_FROM_JIM);
    }

    @Test
    public void testMessageFromLily() {
        final Messenger messenger = new Messenger();
        testMessage(messenger.messageFromLily(), MESSAGE_FROM_LILY);
    }

    /**
     * Test if the given composed message matches the expected message
     *
     * @param composedMessage The composed message, received from the messenger
     * @param message         The expected message
     */
    private void testMessage(final LetterComposite composedMessage, final String message) {
        // Test is the composed message has the correct number of words
        final String[] words = message.split(" ");
        assertNotNull(composedMessage);
        assertEquals(words.length, composedMessage.count());

        // Print the message to the mocked stdOut ...
        composedMessage.print();
        // ... and verify if the message matches with the expected one
        assertEquals(message, new String(this.stdOutBuffer.toByteArray()).trim());
    }

    /**
     * Removed the mocked std-out {@link PrintStream} again from the {@link System} class
     */
    @After
    public void tearDown() {
        System.setOut(realStdOut);
    }
}