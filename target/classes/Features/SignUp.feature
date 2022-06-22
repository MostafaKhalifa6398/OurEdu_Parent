Feature: signup
  Scenario: user open OurEdu website and sign up as a parent
    When user click on sign up as a parent
    And user enter his national id for check
    And user enter his mobile number and verification code
    And user enter his data
    Then user can sign up successfully