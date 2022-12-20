Feature: Certificate Verification
  Scenario: Search certificate error massage
    When Open "https://certificate.ithillel.ua/" page
    And Enter random data of certificate
    And Click on Button Verify
    Then Find error massage about wrong certificate
    And Close browser