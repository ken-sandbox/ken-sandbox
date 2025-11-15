package com.example.androidappsample

/**
 * Simple utility class for greeting operations.
 * Demonstrating a testable class with pure functions.
 */
object GreetingUtil {

    /**
     * Generate a greeting message.
     * @param name The name to greet
     * @return A greeting string
     */
    fun greet(name: String): String {
        return if (name.isBlank()) {
            "Hello, World!"
        } else {
            "Hello, $name!"
        }
    }

    /**
     * Check if a name is valid (not empty and not just whitespace).
     * @param name The name to validate
     * @return true if valid, false otherwise
     */
    fun isValidName(name: String): Boolean {
        return name.isNotBlank()
    }

    /**
     * Count words in a greeting message.
     * @param message The message to count
     * @return Number of words
     */
    fun countWords(message: String): Int {
        return message.split("\\s+".toRegex())
            .filter { it.isNotEmpty() }
            .size
    }
}
