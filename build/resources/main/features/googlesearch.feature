Feature: Google Homepage Search

  As a User
  I want enter information in  google search
  So to see the results

  Scenario: User search content without results
    Given user is on the Google homepage
    When User type "*" into the search field
    And User click the Google Search button
    Then System to see a error messaje: "No se han encontrado resultados para tu búsqueda (*)."

  Scenario: User search null content in Google search
    Given user is on the Google homepage
    When User type " " into the search field
    And User click the Google Search button
    Then The system stay in Google home page

  Scenario: User to see  result page Google after
    Given user is on the Google homepage
    When User type "The name of the wind" into the search field
    And User click the Google Search button
    Then System redirect to search results page


  Scenario Outline: User can search with “Google Search”
    Given user is on the Google homepage
    When User type "<sentenceToSearch>" into the search field
    And User click the Google Search button
    Then System redirect to search results page
    And the first result is "<pageResult>"
    When I click on the first result link
    Then System redirect to the "<destinationPage>" page
    Examples:
      | sentenceToSearch     | pageResult                                              | destinationPage                                         |
      | The name of the wind | The Name of the Wind - Patrick Rothfuss                 | Patrick Rothfuss - The Books |
      | The name of the wind | El nombre del viento - Wikipedia, la enciclopedia libre | El nombre del viento - Wikipedia, la enciclopedia libre |


  Scenario: list suggestion in Google search
    Given user is on the Google homepage
    When User type "The name of the w" into the search field
    And the suggestions list is displayed

  Scenario Outline: User can search by using the suggestions
    Given user is on the Google homepage
    When User type "<sentenceToSearch>" into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then System redirect to search results page
    And the first result is "<pageResult>"
    When I click on the first result link
    Then System redirect to the "<destinationPage>" page
    Examples:
      | sentenceToSearch     | pageResult                                          | destinationPage                                          |
      | The name of the w | The Name of the Wind - Patrick Rothfuss                 | Patrick Rothfuss - The Books                            |
      | The name of the w | El nombre del viento - Wikipedia, la enciclopedia libre | El nombre del viento - Wikipedia, la enciclopedia libre      |




