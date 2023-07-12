@VisitFollowing
Feature: Suivre les visiteurs présents

  Scenario: Suivre les visiteurs presents dans un local
    Given je suis un employé de l'agence de sécurité
    When j'accède au système d'enregistrement de visite
    And je souhaite suivre les visiteurs présents dans les locaux
    Then le système affiche une liste en temps réel des visiteurs actuellement enregistrés
    And  je peux voir leur emplacement sur un plan des locaux
    And je peux accéder à l'historique des visites précédentes de chaque visiteur
    And je peux consulter les détails des personnes qu'ils rencontrent
    And je peux générer des rapports sur l'affluence des visiteurs dans différents secteurs