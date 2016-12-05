/*
 * Copyright (C) 2016 Cyrille Hamel <cyrille.hamel.auditeur@lecnam.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Projet CNAM Formation Analyste-Programmeur UE NFA031 de Cyrille Hamel
 */

package dicegame;

import java.util.Scanner;
import java.util.Random;

/**
 * Classe principale
 * @since 1.0
 * @author Cyrille Hamel <cyrille.hamel.auditeur@lecnam.net>
 * @version 1.0
 */
public class DiceGame
{

    /**
     * Affichage du message de fin suivant que le joueur est gagnant ou perdant
     * @param winnerIndice Indice du joueur gagnant
     * @since 1.0
     */
    public static void displayWinLooseMessage(int winnerIndice)
    {
        if (winnerIndice == 0)
        {
            System.out.println(" /$$     /$$                        /$$      /$$ /$$                 /$$ /$$ /$$");
            System.out.println("|  $$   /$$/                       | $$  /$ | $$|__/                | $$| $$| $$");
            System.out.println(" \\  $$ /$$//$$$$$$  /$$   /$$      | $$ /$$$| $$ /$$ /$$$$$$$       | $$| $$| $$");
            System.out.println("  \\  $$$$//$$__  $$| $$  | $$      | $$/$$ $$ $$| $$| $$__  $$      | $$| $$| $$");
            System.out.println("   \\  $$/| $$  \\ $$| $$  | $$      | $$$$_  $$$$| $$| $$  \\ $$      |__/|__/|__/");
            System.out.println("    | $$ | $$  | $$| $$  | $$      | $$$/ \\  $$$| $$| $$  | $$                  ");
            System.out.println("    | $$ |  $$$$$$/|  $$$$$$/      | $$/   \\  $$| $$| $$  | $$       /$$ /$$ /$$");
            System.out.println("    |__/  \\______/  \\______/       |__/     \\__/|__/|__/  |__/      |__/|__/|__/");
        }
        else
        {
            System.out.println(" /$$     /$$                        /$$");
            System.out.println("|  $$   /$$/                       | $$");
            System.out.println(" \\  $$ /$$//$$$$$$  /$$   /$$      | $$  /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$");
            System.out.println("  \\  $$$$//$$__  $$| $$  | $$      | $$ /$$__  $$ /$$__  $$ /$$_____/ /$$__  $$");
            System.out.println("   \\  $$/| $$  \\ $$| $$  | $$      | $$| $$  \\ $$| $$  \\ $$|  $$$$$$ | $$$$$$$$");
            System.out.println("    | $$ | $$  | $$| $$  | $$      | $$| $$  | $$| $$  | $$ \\____  $$| $$_____/");
            System.out.println("    | $$ |  $$$$$$/|  $$$$$$/      | $$|  $$$$$$/|  $$$$$$/ /$$$$$$$/|  $$$$$$$");
            System.out.println("    |__/  \\______/  \\______/       |__/ \\______/  \\______/ |_______/  \\_______/");
        }
    }

    /**
     * Affichage du message de démarrage
     * @param playerName Nom du joueur
     * @since 1.0
     */
    public static void displayStartMessage(String playerName)
    {
        System.out.println();
        System.out.println("Bonjour " + playerName + ", la partie commence.");
        System.out.println("A tout moment, au début de votre tour, vous avez accès à diverses commandes.");
        System.out.println("Essayez la commande help.");
        System.out.println();
    }

    /**
     * Affichage du message de début de tour
     * @param nbTurn Numéro du tour en cours
     * @since 1.0
     */
    public static void displayTurnMessage(int nbTurn)
    {
        System.out.println("*******************************************************************************");
        System.out.println("*                                                                             *");
        System.out.print("*       Numéro du tour      ");
        System.out.print(nbTurn);
        for (int loop = 0; loop < 50 - Integer.toString(nbTurn).length() ; loop++)
        {
            System.out.print(" ");
        }
        System.out.println("*");
        System.out.println("*                                                                             *");
        System.out.println("*******************************************************************************");
        System.out.println("");
    }

    /**
     * Affichage du menu (help)
     * @since 1.0
     */
        public static void displayHelp()
    {
        System.out.println();
        System.out.println("Commandes disponibles :");
        System.out.println("help, h        Afficher ce message d'aide.");
        System.out.println("rules, r       Afficher les règles de ce jeu.");
        System.out.println("scoring        Afficher le barème des combinaisons.");
        System.out.println("score, s       Afficher le score de tous les joueurs.");
        System.out.println("play, p        Lancer les dés pour le joueur en cours.");
        System.out.println("quit, q        Quitter le jeu.");
        System.out.println();
    }

    /**
     * Affichage des règles
     * @since 1.0
     */
    public static void displayRules(int upToOpen)
    {
        System.out.println("Règles du jeu 10000 (source: Wikipédia) :");
        System.out.println("Dans le temps, ce jeu était plus particulièrement joué par les marins (ou pour les plus fantaisistes par les pirates), " +
            "on y jouait de l'argent et des verres d'alcool mais la règle la plus prisée par les marins était le coup de pied aux fesses. " +
            "Le principe de cette règle permet au gagnant de botter les fesses des perdants. Par exemple, 6 joueurs, le premier donne " +
            "6 coups et n'en prend aucun, le 2e donne 5 coups et en prend 1, le 3e en donne 4 et en prend 2, etc. Cette règle permettait " +
            "un peu de divertissement pendant les longues traversées.\n" +
            "\n" +
            "Le but du jeu est de faire exactement 10 000 points. Si on dépasse l'objectif, on perd un tour. Lorsque la première " +
            "personne atteint 10 000 points il faut finir le tour. Si dans le dernier tour un joueur fait lui aussi 10 000. Il tue " +
            "alors le premier joueur à 10 000 points. On repart alors pour le dernier tour.\n" +
            "\n" +
            "Pour avoir le droit de commencer, il faut \"ouvrir\", c'est-à-dire faire au moins " + upToOpen + " points (pour pimenter un peu le jeu, " +
            "on peut ouvrir à 1000 points).\n" +
            "\n" +
            "On commence par lancer les dés d'un coup. Si les dés permettent de marquer des points, on peut soit gagner les points, " +
            "soit rejouer les dés qui ne valent aucun point (si on n'est pas encore ouvert, il faut rejouer jusqu'à atteindre le minimum " +
            "requis).\n" +
            "\n" +
            "Lorsque la main est pleine (tous les dés valent des points), on est obligé de relancer les dés. On additionne les points de " +
            "chaque lancer. Si, lors d'un tour on ne fait aucun point, on perd tout ce qui avait été accumulé et c'est au suivant de " +
            "jouer. Si on ne fait aucun point lors d'un lancer des dés, on ne marque aucun point, on perd même 1000 points à 6 dés" +
            ", ce qui s'appelle \"faire une fleur\". Cependant, on ne peut devenir négatif. Si on était déjà ouvert, " +
            "on le reste, même si on descend en dessous du minimum requis pour ouvrir.\n" +
            "\n" +
            "Il faut obtenir les combinaisons en un seul lancer. Si on obtient un premier \"1\", puis deux autres après le deuxième lancer, " +
            "cela fait 100 + 200 = 300 points et non pas 1000 points.\n");
        System.out.println();
    }

    /**
     * Affichage du barème de points
     * @since 1.0
     */
    public static void displayScoring(int upToOpen)
    {
        System.out.println("Barème de points (source: Wikipédia) :");
        System.out.println("- Pour démarrer, il faut avoir dans un seul lancer un minimum de " + upToOpen + " points\n" +
            "- Les \"1\" valent 100 points, les \"5\" 50 ;\n" +
            "- 3 dés identiques valent 100 fois la valeur inscrite sur un des dés (600 points pour 3 \"6\"), sauf pour les \"1\" qui valent 1000 points ;\n" +
            "- un quatrième dé double ce score, un cinquième le double de nouveau ;\n" +
            "- 6 dés identiques valent mille fois la valeur inscrite sur un des dés (6000 points pour 6 \"6\", 5000 pour 6 \"5\", etc) ;\n" +
            "- Si quelqu'un fait 6 \"1\" en un seul lancer, il gagne automatiquement la partie ;\n" +
            "- 3 paires valent 600 points ;\n" +
            "- Une petite suite (de 1 à 5 ou de 2 à 6) vaut 600 points ;\n" +
            "- La grande suite (de 1 à 6) vaut 1200 points (et il faut relancer car la main est pleine).\n" +
            "\n" +
            "Exemple\n" +
            "- On lance 6 5 4 2 2 1 ;\n" +
            "- Le \"1\" et le \"5\" valent 150 points, on relance 6 4 2 2 ;\n" +
            "- On obtient 1 1 1 3, les \"1\" valent 1000 points pour un total de 1150.");
        System.out.println();
    }

    /**
     * Affichage du score en cours
     * @since 1.0
     * @param nbPlayers nombre de joueurs
     * @param playerName tableau de noms des joueurs
     * @param playerScore tableau de scores des joueurs
     * @param nbTurn nombre de tours effectués
     * @param upToGo score à atteindre
     */
    public static void displayScore(int nbPlayers, String[] playerName, int[] playerScore, int nbTurn, int upToGo, int upToOpen)
    {
        System.out.println("*******************************************************************************");
        System.out.println("* Nom des joueurs                                               * Score       *");
        System.out.println("*******************************************************************************");
        for (int loopPlayer = 0; loopPlayer < nbPlayers; loopPlayer++)
        {
            System.out.print("* " + playerName[loopPlayer]);
            for (int spaceLoop = 0; spaceLoop < 62 - playerName[loopPlayer].length(); spaceLoop++)
            {
                System.out.print(" ");
            }
            System.out.print("* " + playerScore[loopPlayer]);
            for (int spaceLoop = 0; spaceLoop < 12 - Integer.toString(playerScore[loopPlayer]).length(); spaceLoop++)
            {
                    System.out.print(" ");
            }
            System.out.println("*");
        }
        System.out.println("*******************************************************************************");
        System.out.print("* Nombre de tours effectués                                     * " + nbTurn);
        for (int spaceLoop = 0; spaceLoop < 12 - Integer.toString(nbTurn).length(); spaceLoop++)
        {
                System.out.print(" ");
        }
        System.out.println("*");
        System.out.println("*******************************************************************************");
        System.out.println("Score à atteindre : " + upToGo + " - Score pour ouvrir : " + upToOpen);
        System.out.println();
    }

    /**
     * Affichage du résultat des dés pendant le tour du joueur réel
     * @since 1.0
     * @param diceJet1 tableau du lancé de dés n°1
     * @param diceJet2 tableau du lancé de dés n°2
     * @param scoreJet1 résultat du lancé de dés n°1
     * @param scoreJet2 résultat du lancé de dés n°2
     * @param isSecondJet indique si le deuximème jet a été effectué
     */
    public static void displayDiceResult(int[] diceJet1, int[] diceJet2, int scoreJet1, int scoreJet2, boolean isSecondJet)
    {
        int nbDiceJet1 = (int) diceJet1.length;
        int nbDiceJet2 = (int) diceJet2.length;

        System.out.println("===============================================================================");
        System.out.println("| Dé n°                       |   1   |   2   |   3   |   4   |   5   |   6   |");
        System.out.println("===============================================================================");

        System.out.print("| Résultat jet 1              ");
        for (int loopDice = 0; loopDice < nbDiceJet1; loopDice++)
        {
                System.out.print("|   ");
                if (diceJet1[loopDice] == 0)
                {
                    System.out.print("-");
                }
                else
                {
                    System.out.print(diceJet1[loopDice]);
                }
                System.out.print("   ");
        }
        System.out.println("|");
        System.out.println("===============================================================================");

        if (isSecondJet)
        {
            System.out.print("| Résultat jet 2              ");
            for (int loopDice = 0; loopDice < nbDiceJet2; loopDice++)
            {
                System.out.print("|   ");
                if (diceJet2[loopDice] == 0)
                {
                    System.out.print("-");
                }
                else
                {
                    System.out.print(diceJet2[loopDice]);
                }
                System.out.print("   ");
            }
            System.out.println("|");
            System.out.println("===============================================================================");
        }

        if (!isSecondJet)
        {
            System.out.print("| Score provisoire du tour    |");
        }
        else
        {
            System.out.print("| Score définitif du tour     |");
        }
        int scoreTotal = (int) (scoreJet1 + scoreJet2);
        System.out.print("   " + scoreTotal);
        for (int spaceLoop = 0; spaceLoop < 44 - Integer.toString(scoreTotal).length(); spaceLoop++)
        {
                System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("===============================================================================");
    }
    
    /**
     * Permet le lancement des dés lors de la commande play
     * @since 1.0
     * @param playerIsOpen indique si le joueur a réussi à ouvrir
     * @param upToOpen indique le score à atteindre pour ouvrir
     * @param isAI indique si le joueur est une IA
     * @return le score obtenu et à ajouter
     */
    public static int playTheDice(boolean playerIsOpen, int upToOpen, boolean isAI)
    {
        final int LG_COMMAND_DICE_MIN   = 1;
        final int LG_COMMAND_DICE_MAX   = 12;
        final String    ASK_NUM_DICE    = "Saisir le(s) numéro(s) de dé(s) à rejouer?\n\"all\" pour tous les dés : ";
        int score                       = 0;                //  stocke le score du tour à retrouner
        int scoreTmp                    = 0;
        int scoreTmp2                   = 0;
        int nbDice                      = 6;                //  stocke le nombre de dés (défaut 6) => changement par l'utilisation d'arguments ?
        int nbDiceOk                    = 0;
        int[] valueDice                 = new int[nbDice];  //  stocke le résultat du lancer 1 de dé
        int[] valueDice2                = new int[nbDice];  //  stocke le résultat du lancer 2 de dé
        int[] numDice;                                      //  stocke les numéros de dés lancés
        int[] tabResult                 = new int[2];

        valueDice = launchTheDice(nbDice);
        tabResult = scoreCalculation(valueDice);
        scoreTmp  = tabResult[0];
        nbDiceOk  = tabResult[1];
        
        /*
         * Affichage du premier jet si non IA.
         */
        if (!isAI)
        {
            /*
             * Affichage du tableau du premier tirage de dés pour le joueur réel
            */
            displayDiceResult(valueDice, valueDice2, scoreTmp, scoreTmp2, false);
        }

        /*
         * On verifie que le joueur à ouvert ou non, si non on renvoi
         * le score de zéro et on affiche un message si nécessaire.
         */
        if (!playerHasOpen(scoreTmp, upToOpen, playerIsOpen, isAI)) return 0;

        if (!isAI)
        {
            /*
             * On demande les dés à rejeter si non IA.
             */
            String reloadDiceString = getValueFromQuestion(
                    ASK_NUM_DICE,
                    LG_COMMAND_DICE_MIN,
                    LG_COMMAND_DICE_MAX,
                    false);
            numDice = extractDiceToReloadFromString(reloadDiceString);
        }
        else
        {
            /*
             * Algorithme de l'IA pour choisir les dés.
             */
            String reloadDiceString = getStringDiceByAI(valueDice);
            numDice = extractDiceToReloadFromString(reloadDiceString);
        }

        if (numDice != null) // On traite le deuxieme Jet
        {
            for (int replaceLoop = 0; replaceLoop < nbDice; replaceLoop++)
            {
                for (int replaceLoop1 = 0; replaceLoop1 < numDice.length; replaceLoop1++)
                {
                    if (replaceLoop == numDice[replaceLoop1]-1)
                    {
                        valueDice[replaceLoop] = 0;
                        valueDice2[replaceLoop] = randomDice();
                    }
                }
            }
            tabResult   = scoreCalculation(valueDice);
            scoreTmp    = tabResult[0];
            nbDiceOk    = tabResult[1];
            tabResult   = scoreCalculation(valueDice2);
            scoreTmp2   = tabResult[0];
            
            if (nbDiceOk == nbDice && scoreTmp2 == 0)
            {
                score = -1000;
            }                    
            if (nbDiceOk == nbDice && scoreTmp2 > 0)
            {
                score = (int) (scoreTmp + scoreTmp2);
            }                    
            if (nbDiceOk < nbDice && scoreTmp2 == 0)
            {
                score = (int) (scoreTmp);
            }
            if (nbDiceOk < nbDice && scoreTmp2 > 0)
            {
                score = (int) (scoreTmp + scoreTmp2);
            }                    
        }
        else
        {
            tabResult   = scoreCalculation(valueDice);
            scoreTmp2   = tabResult[0];
            score       = scoreTmp2;
        }

        /*
         * Affichage du deuxième jet si non IA
         */
        if (!isAI)
        {
            /*
             * Affichage du tableau du premier et deuxième tirage de dés pour le joueur réel
            */
            displayDiceResult(valueDice, valueDice2, scoreTmp, scoreTmp2, true);
        }

        /*
         * On verifie que le joueur à ouvert ou non,
         * si non on renvoi le score de zéro et on affiche un message
         */
        if (!playerHasOpen(scoreTmp, upToOpen, playerIsOpen, isAI)) return 0;

        if (!isAI)
        {
            System.out.println();
        }

        return score;
    }

    /**
     * Méthode donnant le résultat aléatoire d'un dé.
     * @since 1.0
     * @return Le résultat du dé de 1 à 6
     */
    public static int randomDice()
    {
        int min     = 1;
        int max     = 6;
        Random rand = new Random();
        int dice    = rand.nextInt(max - min + 1) + min;
        return (int) dice;
    }

    /**
     * Méthode permettant de savoir si le joueur a ouvert avec le score fourni en argument.
     * @since 1.0
     * @param scoreTmp Indique le score obtenu lors du jet
     * @param upToOpen Indique le score à atteindre pour ouvrir
     * @param playerIsOpen Indique si le joueur a déjà ouvert
     * @param isAI Indique si le joueur est une IA
     * @return Vrai ou Faux
     */
    public static boolean playerHasOpen(int scoreTmp, int upToOpen, boolean playerIsOpen, boolean isAI)
    {
        if (scoreTmp < upToOpen && !playerIsOpen)
        {
            if (isAI == false)
            {
                System.out.println("Vous n'avez pas atteint l'objectif de " + upToOpen + " points en un seul jet pour ouvrir.");
                System.out.println();
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Méthode donnant le résultat d'un jet de dés suivant le nombre de dés fourni en argument.
     * @since 1.0
     * @param nbDice le nombre de dés à lancer
     * @return un tableau contenant le résultat du jet de dés
     */
    public static int[] launchTheDice(int nbDice)
    {
        int[] valueDice = new int[nbDice];
        for (int loop = 0; loop < nbDice; loop++)
        {
            valueDice[loop] = randomDice();
        }
        return valueDice;
    }

    /**
     * Algorithme de jeu IA pour choisir les dés à relancer
     * @since 1.0
     * @param valueDice le tableau du premier jet
     * @return La chaine de dés à relancer
     */
    public static String getStringDiceByAI(int[] valueDice)
    {
        int nbDice = (int) valueDice.length;
        String stringDice = "";


        return stringDice;
    }

    /**
     * Méthode extractant les numéros de dés à partir d'une chaine
     * @since 1.0
     * @param reloadDiceString la chaine contenant les numéros de dés à relancer
     * @return Le tableau des numéros de dés à relancer
     */
    public static int[] extractDiceToReloadFromString(String reloadDiceString)
    {
        if (reloadDiceString.length() > 0)
        {
            if (reloadDiceString.equals("all")){
                int[] numDice = { 1, 2, 3, 4, 5, 6};
                return numDice;
            }
            else
            {
                // enlever tous les espaces de la chaine
                // verifier qu'il n'y a que des chiffres
                // compter le nombre de chiffre
                // créer le tableau numDice et affecter les valeurs
                String diceNumber   = reloadDiceString.replaceAll(" ", "");
                int[] numDice       = new int[diceNumber.length()];
                for (int loop = 0; loop < diceNumber.length(); loop++)
                {
                    numDice[loop] = Byte.parseByte(Character.toString(diceNumber.charAt(loop)));
                }
                return numDice;
            }
        }
        else
        {
            return null;
        }
    }

     /**
     * Méthode de récupératon d'un int par questionnement
     * @since 1.0
     * @param question chaine correspondant à la question posée
     * @param min nombre minimum admissible
     * @param max nombre maximum admissible
     * @return la réponse donnée de type int
     * @see getValueFromQuestion(String question, int min, int max, boolean nothingToDo)
     */
    public static int getValueFromQuestion(String question, int min, int max)
    {
        Scanner scan    = new Scanner(System.in);
        int answer      = -1;
        System.out.print(question);
        while (answer < min || answer > max)
        {
            try
            {
                answer = scan.nextByte();
                if (answer >= min && answer <= max)
                {
                    return answer;
                }
                else
                {
                    System.out.println("La réponse n'est pas correcte. Entrez un nombre entre " + min + " et " + max + ".");
                    answer = getValueFromQuestion(question, min, max);
                }
            }
            catch (Exception e)
            {
                System.out.println("La réponse n'est pas correcte. Entrez un nombre entre " + min + " et " + max + ".");
                answer = getValueFromQuestion(question, min, max);
            }
        }
        return answer;
    }

    /**
     * Méthode de récupératon d'une chaine par questionnement
     * @since 1.0
     * @param question chaine correspondant à la question posée
     * @param min nombre minimum de caractères admissibles
     * @param max nombre maximum de caractères admissibles
     * @return la réponse donnée de type String
     * @see getValueFromQuestion(String question, int min, int max)
     */
    public static String getValueFromQuestion(String question, int min, int max, boolean nothingToDo)
    {
        Scanner scan    = new Scanner(System.in);
        String answer   = "";
        System.out.print(question);
        while (answer.length() < min || answer.length() > max)
        {
            try
            {
                answer = scan.nextLine();
                if (answer.length() >= min && answer.length() <= max)
                {
                    return answer;
                }
                else
                {
                    System.out.println("La réponse n'est pas correcte. La chaine doit comprendre de " + min + " et " + max + " caractères.");
                    answer = getValueFromQuestion(question, min, max, false);
                }
            }
            catch (Exception e)
            {
                System.out.println("La réponse n'est pas correcte. La chaine doit comprendre de " + min + " et " + max + " caractères.");
                answer = getValueFromQuestion(question, min, max, false);
            }
        }
        return answer;
    }

    /**
     * Méthode donnant le calcul du score
     * @since 1.0
     * @param valueDice tableau de résultat du jet de dé
     * @return Un tableau avec le résultat du score dans [0] et le nombre de dés valant des points dans [1] 
     */
    public static int[] scoreCalculation(int[] valueDice)
    {
        int[] result    =  new int[2];
        int nbDiceOk    = 0;
        int scoreTmp    = 0;
        int score       = 0;
        int nbValue1    = 0;
        int nbValue2    = 0;
        int nbValue3    = 0;
        int nbValue4    = 0;
        int nbValue5    = 0;
        int nbValue6    = 0;    // stocke respectivement le nombre de dés de valeur X

        for (int loop = 0; loop < valueDice.length; loop++)
        {
            switch (valueDice[loop])
            {
                case 1:
                    nbValue1 += 1;
                    break;
                case 2:
                    nbValue2 += 1;
                    break;
                case 3:
                    nbValue3 += 1;
                    break;
                case 4:
                    nbValue4 += 1;
                    break;
                case 5:
                    nbValue5 += 1;
                    break;
                case 6:
                    nbValue6 += 1;
                    break;
                default:
                    break;
            }
        }

        /*
         * Traitement des points individuels
         */
        if (nbValue1 <= 2 && nbValue1 > 0)
        {
            //  en dessous de 3 "1". les "1" valent 100 points
            scoreTmp = (int) (nbValue1 * 100);
            nbDiceOk = nbValue1;
        }
        if (nbValue5 <= 2 && nbValue5 > 0)
        {
            //  en dessous de 3 "5". les "1" valent 50 points
            scoreTmp += (int) (nbValue5 * 50);
            nbDiceOk += nbValue5;
        }      
        score += scoreTmp;

        /*
         * Traitement des multiples x3 à x5
         */
        scoreTmp = 0;
        if (nbValue1 >= 3) scoreTmp = 1000;
        if (nbValue1 >= 4) scoreTmp *= 2;
        if (nbValue1 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue1;

        scoreTmp = 0;
        if (nbValue2 >= 3) scoreTmp = 200;
        if (nbValue2 >= 4) scoreTmp *= 2;
        if (nbValue2 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue2;

        scoreTmp = 0;
        if (nbValue3 >= 3) scoreTmp = 300;
        if (nbValue3 >= 4) scoreTmp *= 2;
        if (nbValue3 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue3;

        scoreTmp = 0;
        if (nbValue4 >= 3) scoreTmp = 400;
        if (nbValue4 >= 4) scoreTmp *= 2;
        if (nbValue4 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue4;

        scoreTmp = 0;
        if (nbValue5 >= 3) scoreTmp = 500;
        if (nbValue5 >= 4) scoreTmp *= 2;
        if (nbValue5 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue5;

        scoreTmp = 0;
        if (nbValue6 >= 3) scoreTmp = 600;
        if (nbValue6 >= 4) scoreTmp *= 2;
        if (nbValue6 >= 5) scoreTmp *= 2;
        score       += scoreTmp;
        nbDiceOk    += nbValue6;

        /*
         * Traitement des triple doubles
         */
        if ((nbValue1 == 2 && nbValue2 == 2 && nbValue3 == 2) ||
                (nbValue1 == 2 && nbValue3 == 2 && nbValue4 == 2) ||
                (nbValue1 == 2 && nbValue4 == 2 && nbValue5 == 2) ||
                (nbValue1 == 2 && nbValue5 == 2 && nbValue6 == 2) ||
                (nbValue1 == 2 && nbValue2 == 2 && nbValue4 == 2) ||
                (nbValue1 == 2 && nbValue2 == 2 && nbValue5 == 2) ||
                (nbValue1 == 2 && nbValue2 == 2 && nbValue6 == 2) ||
                (nbValue1 == 2 && nbValue3 == 2 && nbValue4 == 2) ||
                (nbValue1 == 2 && nbValue3 == 2 && nbValue5 == 2) ||
                (nbValue1 == 2 && nbValue3 == 2 && nbValue6 == 2) ||
                (nbValue1 == 2 && nbValue4 == 2 && nbValue5 == 2) ||
                (nbValue1 == 2 && nbValue4 == 2 && nbValue6 == 2) ||
                (nbValue1 == 2 && nbValue5 == 2 && nbValue6 == 2) ||
                (nbValue2 == 2 && nbValue3 == 2 && nbValue4 == 2) ||
                (nbValue2 == 2 && nbValue3 == 2 && nbValue5 == 2) ||
                (nbValue2 == 2 && nbValue3 == 2 && nbValue6 == 2) ||
                (nbValue2 == 2 && nbValue4 == 2 && nbValue5 == 2) ||
                (nbValue2 == 2 && nbValue4 == 2 && nbValue6 == 2) ||
                (nbValue2 == 2 && nbValue5 == 2 && nbValue6 == 2) ||
                (nbValue3 == 2 && nbValue4 == 2 && nbValue5 == 2) ||
                (nbValue3 == 2 && nbValue4 == 2 && nbValue6 == 2) ||
                (nbValue3 == 2 && nbValue5 == 2 && nbValue6 == 2) ||
                (nbValue4 == 2 && nbValue5 == 2 && nbValue6 == 2))
        {
            score       = 600; //  en cas de triple double : 600, pas d'ajout de points
            nbDiceOk    = 6;    // Tous les dés sont utilisé
        }

        /*
         * Traitement des sextuples
         */
        if (nbValue1 == 6){
            score       = 10000;
            nbDiceOk    = 6;
        }
        if (nbValue2 == 6){
            score       = 2000;
            nbDiceOk    = 6;
        }
        if (nbValue3 == 6)
        {
            score       = 3000;
            nbDiceOk    = 6;
        }
        if (nbValue4 == 6)
        {
            score       = 4000;
            nbDiceOk    = 6;
        }
        if (nbValue5 == 6)
        {
            score       = 5000;
            nbDiceOk    = 6;
        }
        if (nbValue6 == 6)
        {
            score       = 6000;
            nbDiceOk    = 6;
        }

        /*
         * Traitement de la grande série
         */
        if (nbValue1 == 1 && nbValue2 == 1 && nbValue3 == 1 && nbValue4 == 1 && nbValue5 == 1 && nbValue6 == 1)
        {
            score       = 1200;
            nbDiceOk    = 6;
        }

        /*
         * Traitement de la petite série
         */
        if ((nbValue1 >= 1 && nbValue2 >= 1 && nbValue3 >= 1 && nbValue4 >= 1 && nbValue5 >= 1) ||
                (nbValue2 >= 1 && nbValue3 >= 1 && nbValue4 >= 1 && nbValue5 >= 1 && nbValue6 >= 1))
        {
            score       = 600;
            scoreTmp    = 0;
            nbDiceOk    = 5;
            if (nbValue1 == 2)
            {
                //  si égal 2 "1", on ajoute 100 points
                scoreTmp  = (int) (100);
                nbDiceOk += 1;
            }     
            if (nbValue5 == 2)
            {
                //  si égal 2 "5", on ajoute 50 points
                scoreTmp  = (int) (50);
                nbDiceOk += 1;
            }      
            score += scoreTmp;
        }
        
        
        result[0] = score;
        result[1] = nbDiceOk;
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*
         * Déclaration des constantes.
         */
        final int       NB_PLAYER_MIN   = 2;
        final int       NB_PLAYER_MAX   = 127;
        final int       LG_NAME_MIN     = 3;
        final int       LG_NAME_MAX     = 30;
        final int       LG_COMMAND_MIN  = 1;
        final int       LG_COMMAND_MAX  = 7;
        final String    TELL_WELCOME    = "Jeu de dés 10000";
        final String    ASK_NB_PLAYERS  = "Veuillez indiquer le nombre de joueurs. (Vous + n IA) : ";
        final String    ASK_NAME        = "Indiquez votre nom : ";
        final String    TELL_PL_NAME    = "Joueur ";

        /*
         * Déclaration des variables globales.
         */
        boolean quitTheGame     = false;    //  stocke si le jeu est fini ou non. Sert pour la boucle principale
        boolean endOfTheGame    = false;    //  Vérifie si un joueur à atteint le score nécessaire. Sert pour la boucle principale
        boolean endOfTurn       = false;    //  défini si le tour est terminé pour le joueur
        int     nbPlayers       = 2;        //  stocke le nombre de joureurs (1 humain + n IA) par défaut 2 (limite 127 ?) => changement par l'utilisation d'arguments ?
        int     winnerIndice    = -1;       //  Indice du joueur qui gagne la partie
        int     nbTurn          = 0;        //  stocke le numéro du tour actuel (démarre à #0)
        int     scoreToAdd      = 0;        //  stocke le score du tour
        int     upToGo          = 10000;    //  stocke le score à atteindre
        int     upToOpen        = 700;      //  stocke le score pour ouvrir en un seul jet
        String  playerCommand   = "";       //  stocke la commande du joueur

        /*
         * Affichage des informations de début de programme.
         */
        System.out.println(TELL_WELCOME);

        /*
         * Demande du nombre de joueurs. Limite min 2, max 127.
         */
        nbPlayers = getValueFromQuestion(ASK_NB_PLAYERS, NB_PLAYER_MIN, NB_PLAYER_MAX);

        /*
         * Déclaration des variables 'dynamiques': tableaux dépendants des réponses du joueurs.
         */
        boolean[]   playerIsAI    = new boolean[nbPlayers]; //  stocke si le joueur est une IA
        int[]       playerScore   = new int[nbPlayers];     //  stocke le score de chaque joueur (limite 32767 ?)
        String[]    playerName    = new String[nbPlayers];  //  stocke le nom du joueur [indice = numéro du joueur]
        boolean[]   playerIsOpen  = new boolean[nbPlayers]; //  stocke si le joueur a ouvert

        /*
         * Récupération du nom et initialisation du joueur réel.
         */
        playerName[0]   = getValueFromQuestion(ASK_NAME, LG_NAME_MIN, LG_NAME_MAX, false);
        playerIsAI[0]   = false;
        playerScore[0]  = 0;
        playerIsOpen[0] = false;

        /*
         * Initialisation des autres joueurs (IA).
         */
        for (int loopPlayer = 1; loopPlayer < nbPlayers; loopPlayer++)
        {
            playerName[loopPlayer]      = TELL_PL_NAME + loopPlayer;
            playerIsAI[loopPlayer]      = true;
            playerScore[loopPlayer]     = 0;
            playerIsOpen[loopPlayer]    = false;
        }

        /*
         * Affichage du message de démarrage.
         */
        displayStartMessage(playerName[0]);

        /*
         * Lancement de la boucle principale jusqu'au score final exact (et la fin du tour en cours),
         * si un (ou plusieurs) des joueurs le dépasse on ne compte pas le score de son tour et on continue.
         * quitTheGame - Le joueur veut quitter le jeu
         * endOfTheGame - Au moins un des joueurs est arrivé au score final
         */
        while (quitTheGame == false && endOfTheGame == false)
        {
            /*
             * Affichage du message de début d'un tour.
             */
            displayTurnMessage(nbTurn + 1);

            /*
             * Boucle sur tous les joueurs.
             */
            for (int loopPlayer = 0; loopPlayer < nbPlayers; loopPlayer++)
            {
                endOfTurn = false;

                /*
                 * Test si le joueur est n'est pas une IA.
                 */
                if (playerIsAI[loopPlayer] == false)
                {
                    /*
                     * Traitement du joueur réel
                     * On fait une boucle jusqu'à avoir soit 'quit' ou 'q' soit 'endOfTurn'.
                     */
                    while (!playerCommand.equals("quit") && !playerCommand.equals("q") && !endOfTurn)
                    {
                        /*
                         * Initialisation du score pour ce tour.
                         */
                        scoreToAdd = 0;

                        /*
                         * Demande de la commande à analyser.
                         */
                        playerCommand = getValueFromQuestion("[" + playerName[loopPlayer] + " - Score : " + playerScore[loopPlayer] + "  - Tour n° " + (nbTurn + 1) + "] Commande : ",
                                LG_COMMAND_MIN, LG_COMMAND_MAX, false);

                        switch (playerCommand)
                        {
                            case "h":
                            case "help":
                                displayHelp();
                                break;
                            case "r":
                            case "rules":
                                displayRules(upToOpen);
                                break;
                            case "scoring":
                                displayScoring(upToOpen);
                                break;
                            case "s":
                            case "score":
                                displayScore(nbPlayers, playerName, playerScore, nbTurn, upToGo, upToOpen);
                                break;
                            case "p":
                            case "play":
                                scoreToAdd = playTheDice(playerIsOpen[loopPlayer], upToOpen, false);
                                if (scoreToAdd >= upToOpen) playerIsOpen[loopPlayer] = true;
                                endOfTurn = true;
                                break;
                            case "q":
                            case "quit":
                                quitTheGame = true;
                                break;
                            default:
                                System.out.println("Commande inconnue...");
                        }
                    }

                    /*
                     * Si le score à ajouter est négatif (-1000), on ne peut pas descendre en dessous de 0
                     * Si le joueur ne dépasse pas le score final avec le score du tour, on l'ajoute
                     * Si le joueur a atteint le score exact, on ajoute le double
                     * (pour pouvoir annuler si plusieurs joueurs ont atteint ce score exact)
                     * Si le joueur a dépassé le score exact, on ne comptabilise pas ses points.
                     */
                    if ((playerScore[loopPlayer] + scoreToAdd) < 0)
                    {
                        playerScore[loopPlayer] = 0;
                    } 
                    else if ((playerScore[loopPlayer] + scoreToAdd) < upToGo)
                    {
                        playerScore[loopPlayer] += scoreToAdd;
                    }
                    else if ((playerScore[loopPlayer] + scoreToAdd) == upToGo)
                    {
                        playerScore[loopPlayer] += (2 * scoreToAdd);
                        endOfTheGame = true;
                    }
                    else
                    {
                        /*
                         * Dépassement du score à atteindre le joueur passe son tour.
                         */
                        System.out.println("Vous avez dépassé le score maximum. Passez votre tour.");
                    }

                    /*
                     * On sort de la boucle car le joueur veut quitter le jeu.
                     */
                    if (quitTheGame == true) break;
                }
                else
                {
                    /*
                     * On traite le joueur virtuel
                     * Même principe que pour le joueur réel en simplifié.
                     */
                    scoreToAdd = 0;
                    scoreToAdd = playTheDice(playerIsOpen[loopPlayer], upToOpen, true);
                    if (scoreToAdd >= upToOpen) playerIsOpen[loopPlayer] = true;
                    if ((playerScore[loopPlayer] + scoreToAdd) < 0) playerScore[loopPlayer] = 0; 
                    if ((playerScore[loopPlayer] + scoreToAdd) < upToGo)
                    {
                        playerScore[loopPlayer] += scoreToAdd;
                    }
                    else if ((playerScore[loopPlayer] + scoreToAdd) == upToGo)
                    {
                        playerScore[loopPlayer] += (2 * scoreToAdd);
                        endOfTheGame = true;
                    }
                }
            }

            /*
             * Incrémentation du nombre de tour.
             */
            nbTurn = nbTurn + 1;

            /*
             * Si le score final exact est atteint
             * Vérification du nombre de joueurs qui l'on atteint
             * Si plusieurs, on remet les compteurs à 'zéro' (retrait des points du dernier tour).
             */
            if(endOfTheGame == true)
            {
                int nbPlayersFinished = 0;

                for (int loopPlayer = 0; loopPlayer < nbPlayers; loopPlayer++)
                {
                    if (playerScore[loopPlayer] > upToGo) nbPlayersFinished += 1;
                }

                if (nbPlayersFinished > 1)
                {
                    /*
                     * On annule le tour pour tout le monde.
                     */
                    for (int loopPlayer = 0; loopPlayer < nbPlayers; loopPlayer++)
                    {
                        if (playerScore[loopPlayer] > upToGo) playerScore[loopPlayer] = (int) (playerScore[loopPlayer] - 2 * (playerScore[loopPlayer]-upToGo));
                    }
                    endOfTheGame = false;
                }
                else
                {
                    /*
                     * On remet le score normal pour un affichage correct.
                     */
                    for (int loopPlayer = 0; loopPlayer < nbPlayers; loopPlayer++)
                    {
                        if (playerScore[loopPlayer] > upToGo)
                        {
                            playerScore[loopPlayer] = (int) (playerScore[loopPlayer] - (playerScore[loopPlayer]-upToGo));
                            winnerIndice = loopPlayer;
                        }
                    }
                    endOfTheGame = true;
                }
            }
        }
        if (quitTheGame == true)
        {
            System.out.println("Vous avez décidé de quitter une partie non terminée.\nA bientot!!!");
            System.out.println();

        }
        else if (endOfTheGame == true)
        {
            /*
             * Affichage du tableau de score.
             */
            displayScore(nbPlayers, playerName, playerScore, nbTurn, upToGo, upToOpen);
            System.out.println("");

            /*
             * Affichage différent suivant que le gagnant est le joueur réel ou l'IA.
             */
            if (winnerIndice == 0)
            {
                displayWinLooseMessage(winnerIndice);
            }
            else
            {
                displayWinLooseMessage(winnerIndice);
            }
            System.out.println();
        }
    }
}
