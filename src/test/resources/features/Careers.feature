Feature: the user should be able to open Career page, its Locations, Teams, Jobs and Life at Insider blocks

  Background:
    Given the user is on the Insider home page
    When the user navigates to "More" "Careers"

    Scenario: the user should be able to go to Careers page by using navigation menu on the home page
      Then the title of the page is "Careers - Insider"

    Scenario: the user should be able to display listed locations on the Careers page
      When the user scrolls down to display Our Locations block
      Then the user should be able to display the Locations listed below under Our Locations block

        | Indianapolis     |
        | Sao Paulo        |
        | London           |
        | Paris            |
        | Amsterdam        |
        | Barcelona        |
        | Helsinki         |
        | Warsaw           |
        | Kiev             |
        | Moscow           |
        | Sydney           |
        | Dubai            |
        | Tokyo            |
        | Seoul            |
        | Hong Kong        |
        | Singapore        |
        | Bangkok          |
        | Jakarta          |
        | Taipei           |
        | Manila           |
        | Kuala Lumpur     |
        | Ho Chi Minh City |
        | Istanbul         |
        | Ankara           |

    Scenario: the user should be able to display all teams on the Careers page
      When the user clicks on See all teams
      Then the user should be able to display team names listed below under Find your calling block

        | Customer Success            |
        | Sales                       |
        | Product & Engineering       |
        | Finance & Business Support  |
        | Marketing                   |
        | CEO’s Executive Office      |
        | Operations                  |
        | People and Culture          |
        | Business Intelligence       |
        | Security Engineering        |
        | Partnership                 |
        | Quality Assurance           |
        | Mobile Business Unit        |
        | Partner Support Development |
        | Product Design              |

    Scenario: the user should be able to open open positions page by clicking Find your dream job button under Ready to disrupt header
      When the user clicks on Find your dream job button under Ready to disrupt header
      Then the title of the page is "Open Positions - Insider"


    Scenario: the user should be able to display Life at Insider block on the Careers page
      When the user scrolls down on the Careers page
      Then the user should be able to display Life at Insider header





