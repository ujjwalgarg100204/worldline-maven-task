package com.ujjwalgarg;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {

  @Test
  void testMain() {
    // Arrange
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Act
    App.main(new String[]{});

    // Assert
    assertEquals("Hello World!\n", outContent.toString());
  }
}
