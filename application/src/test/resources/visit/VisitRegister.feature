@VisitRegister
Feature: Enregistrement un visite

  Scenario: Enregistrerment d'une nouvelle visite
    Given �tant donn� que je suis un employ� de l'agence de s�curit�
    When j'acc�de au syst�me d'enregistrement de visite
    And que je souhaite enregistrer un nouveau visiteur
    Then je saisis les informations requises telles que le nom, la soci�t� et le num�ro de t�l�phone
    And je prends une photo du visiteur pour l'identification
    And recherche les informations de l'employ�
    And j'affecte un badge au visiteur
    When je valide l'enregistrement
    Then La visite est enregistr�e
    And le visiteur est autoris� � entrer dans les locaux
