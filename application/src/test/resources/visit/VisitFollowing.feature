@VisitFollowing
Feature: Suivre les visiteurs pr�sents

  Scenario: Suivre les visiteurs presents dans un local
    Given je suis un employ� de l'agence de s�curit�
    When j'acc�de au syst�me d'enregistrement de visite
    And je souhaite suivre les visiteurs pr�sents dans les locaux
    Then le syst�me affiche une liste en temps r�el des visiteurs actuellement enregistr�s
    And  je peux voir leur emplacement sur un plan des locaux
    And je peux acc�der � l'historique des visites pr�c�dentes de chaque visiteur
    And je peux consulter les d�tails des personnes qu'ils rencontrent
    And je peux g�n�rer des rapports sur l'affluence des visiteurs dans diff�rents secteurs