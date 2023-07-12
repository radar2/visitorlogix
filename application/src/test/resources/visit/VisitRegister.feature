@VisitRegister
Feature: Enregistrement un visite

  Scenario: Enregistrerment d'une nouvelle visite
    Given Étant donné que je suis un employé de l'agence de sécurité
    When j'accède au système d'enregistrement de visite
    And que je souhaite enregistrer un nouveau visiteur
    Then je saisis les informations requises telles que le nom, la société et le numéro de téléphone
    And je prends une photo du visiteur pour l'identification
    And recherche les informations de l'employé
    And j'affecte un badge au visiteur
    When je valide l'enregistrement
    Then La visite est enregistrée
    And le visiteur est autorisé à entrer dans les locaux
