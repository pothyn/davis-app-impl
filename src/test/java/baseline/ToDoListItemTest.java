/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListItemTest {
    Item item;

    @BeforeEach
    void init() {
        // Initialize new Item
        item = new Item();
    }

    @Test
    void editCompletionTest() {
        // change completion to true and assert it works (using isComplete())
        item.isCompleteProperty().setValue(true);

        assertTrue(item.isComplete());
    }

    @Test
    void editDescriptionTest() {
        // Access and modify description
        item.descriptionProperty().setValue("A");

        assertEquals("A", item.getDescription());
    }

    @Test
    void editDateTest() {
        item.dueDateStringProperty().setValue("2002-06-09");

        assertEquals("2002-06-09", item.getDueDateString());
    }
}