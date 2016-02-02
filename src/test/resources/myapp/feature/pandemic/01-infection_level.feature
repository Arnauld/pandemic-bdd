Feature: Infection Level

  Scenario: City Infection

    Given Paris is not infected
    When Paris is infected
    Then Paris's level of infection should be 1


    @simplified_world
  Scenario: Outbreak

    Given the following levels of infection:
      | city    | level |
      | Paris   | 3     |
      | London  | 1     |
      | Essen   | 2     |
      | Milan   | 0     |
      | Algiers | 0     |
      | Madrid  | 0     |
      | NewYork | 0     |
    When Paris is infected
    Then Paris should outbreak
    And the levels of infection should be:
      | city   | level |
      | Paris  | 3     |
      | London | 2     |