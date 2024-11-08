Feature: Verify external web call

  Scenario: Open an external website and verify content
    Given the user opens the "http://example.com" page
    Then the page title should be "Example Domain"
