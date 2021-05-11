Feature: index_page

  @consumers
  Scenario Outline: Mytime Automation Assignment, Author: Felipe Amorim, Category: Automation Assignment, Device: Google Chrome
    Given Access mytime consumers page
    When Search for <service> in <location>
    Then Assert that at least <resultAmount> results are shown
    When Open business name <businessName>
    And On the results screen - Select All services in the services filter from the left panel
    And On the results screen - Select second staff from the staff filter in the left side panel
    And On the results screen - Click the Book button for the Mens Haircut service
    And On the results screen - Press Select Time in the add-on modal opened
    Then Verify that the user is presented with a list of available time slots with at least <entriesAmount> entries
    And Verify in the right side panel - Service displayed is the one selected in the step before
    And Verify in the right side panel - Service price is the same as the one displayed in the step before
    And Verify in the right side panel - Staff selected is the staff chosen before

    Examples:
      | service   | location            | resultAmount | businessName        | entriesAmount |
      | "haircut" | "San Francisco, CA" | 3            | "Test - Sabre Cuts" | 2             |