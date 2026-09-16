package com.nexus;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void applicationStarts() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}