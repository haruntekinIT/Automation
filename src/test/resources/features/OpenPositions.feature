Feature: the user should be able to filter jobs by Location: Istanbul, Turkey, Department: Quality Assurance and to display jobs list on the Open Positions page

  Background:
    Given the user is on the Insider home page
    When the user navigates to "More" "Careers"
    And the user clicks on Find your dream job button under Ready to disrupt header

  Scenario: the user should be able to filter jobs by Location: Istanbul, Turkey, Department: Quality Assurance and to display jobs list
    When the user clicks on drop-down menu under "Filter by Location" label
    And the user selects Istanbul, Turkey from the menu
    And the user clicks on drop-down menu under "Filter by Department" label
    And the user selects Quality Assurance from the menu
    Then the user should be able to display the number of listed jobs at the right of Open Positions header as equal or greater than one
    And the all jobs' position contains "Quality Assurance"
    And the all jobs' department contains "Quality Assurance"
    And the all jobs' location contains "Istanbul, Turkey"

  Scenario: the user should be able to display the page of the position h/she clicked on
    When the user clicks on drop-down menu under "Filter by Location" label
    And the user selects Istanbul, Turkey from the menu
    And the user clicks on drop-down menu under "Filter by Department" label
    And the user selects Quality Assurance from the menu
    And the user clicks on the Apply Now button of the Software Quality Assurance Engineer position
    Then the title of the newly opened page is "Insider. - Software Quality Assurance Engineer"


    

