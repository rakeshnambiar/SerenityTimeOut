@DataProcessingCheck
Feature: To check the data processing Log performance

  @TC08_AbsDataProcessIndexTest @Abstract
  Scenario: To check the newly loaded/reloaded/deleted PMID's are reflected or NOT in the Index for Abstract Data Pipeline
    Given I have the production Index URL - Abstract to make a query
    And I have all the newly loaded PMID's with me to check the Indexing
    When I check the availability of each PMID using the Index query
    Then Index should returns the PMID details for each query
