Feature: the user should be able to display job description, requirements, APPLY FOR THIS JOB button of the position h/she clicked on at the Open Positions page and to open submit your application page

  Background:
    Given the user is on the Insider home page
    When the user navigates to "More" "Careers"
    And the user clicks on Find your dream job button under Ready to disrupt header
    And the user clicks on drop-down menu under "Filter by Location" label
    And the user selects Istanbul, Turkey from the menu
    And the user clicks on drop-down menu under "Filter by Department" label
    And the user selects Quality Assurance from the menu
    And the user clicks on the Apply Now button of the Software Quality Assurance Engineer position

  Scenario: the user should be able to display job description, requirements and APPLY FOR THIS JOB button of the position h/she clicked on
    Then the job description section is displayed
    And the job requirements section is displayed
    And APPLY FOR THIS JOB button is displayed

  Scenario: the user should be able to display submit your application page
    When the user clicks on the APPLY FOR THS JOB button
    Then the user should be able to display SUBMIT YOUR APPLICATION header