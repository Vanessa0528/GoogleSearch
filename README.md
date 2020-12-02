# GoogleSearch

Scenarios to test:


Scenario: User search content without results  Given user is on the Google homepage When User type * into the search field And User click the Google Search button Then System to see a error messaje: "No se han encontrado resultados para tu búsqueda (*)."

Scenario: User search string empty content in Google search Given user is on the Google homepage When User type " " into the search field And User click the Google Search button Then The system stay in Google home page

Scenario: User see page result after to search Given user is on the Google homepage When User type "The name of the wind" into the search field And User click the Google Search button Then System redirect to search results page

Scenario Outline: User can search with “Google Search” Given user is on the Google homepage When User type "sentenceToSearch" into the search field And User click the Google Search button Then System redirect to search results page And the first result is "pageResult" When I click on the first result link Then System redirect to the "<destinationPage>" page
  
Scenario: list suggestion in Google search Given user is on the Google homepage When User type "The name of the w" into the search field And the suggestions list is displayed

Scenario Outline: User can search by using the suggestions Given user is on the Google homepage When User type "sentenceToSearch" into the search field And the suggestions list is displayed And I click on the first suggestion in the list Then System redirect to search results page And the first result is "pageResult" When I click on the first result link Then System redirect to the "destinationPage" page
   