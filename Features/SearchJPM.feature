Feature: J.P. Morgan Company name Search in Google

  Background: 
    Given User launch browser and navigate to Google.com

  Scenario Outline: Search Company name in Google Input Company Name and Click Enter
    Then User search with company name as <companyName>
    And User click's on the first results returned in the search
    When The page user clicked loads successfully with <pageTitle> and <pageUrl> <testFlag>
    Then User validate the <logoDetails> logo displayed <testFlag>

    Examples: 
      | companyName | testFlag | logoDetails      | pageTitle   | pageUrl          |
      | JP Morgan   | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J.P. Morgan | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J P Morgan  | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J.P. Morgan | false    | other logo       | other title | www.other.com    |

  Scenario Outline: Search Company name in Google and select from AutoSuggestion Dropdown option
    Then User search with company name <companyName> and selelct from AutoSuggestion
    And User click's on the first results returned in the search
    When The page user clicked loads successfully with <pageTitle> and <pageUrl> <testFlag>
    Then User validate the <logoDetails> logo displayed <testFlag>

    Examples: 
      | companyName | testFlag | logoDetails      | pageTitle   | pageUrl          |
      | JP Morgan   | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J.P. Morgan | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J P Morgan  | true     | J.P. Morgan logo | J.P. Morgan | www.jpmorgan.com |
      | J.P. Morgan | false    | other logo       | other title | www.other.com    |
