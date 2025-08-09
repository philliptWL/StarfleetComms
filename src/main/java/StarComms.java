import java.util.Scanner;

public class StarComms{
    public static void start(){
        Scanner input = new Scanner(System.in);
        String block;
        String[] lines;
        int response;

        block = """
                +++COGITATOR ACCESS POINT+++
                
                By the Omnissiah’s Will, this terminal is sanctified. By the Emperor’s Light, this data is pure.

                +++ENTER CREDENTIALS+++

                Identification Sigil: ██████████
                
                """;

        lines = block.split("\n");

        promptBlockTimed(lines);

        String idSigil = input.nextLine();

        idSigil = "Identification Sigil: " + idSigil.toUpperCase();

        System.out.println("""
                Clearance Rank: ██████████
                """);

        String clearanceRank = input.nextLine();

        clearanceRank = "Clearance Rank: " + clearanceRank.toUpperCase();

        block = """
                Litany of Access: Recite the Third Canticle of Awakening

                Security Challenges: BYPASSED

                Voiceprint Authentication – PENDING

                Rosette Seal Scan – PENDING

                Machine Spirit Benediction – PENDING

                +++WARNING+++

                Unauthorized access is punishable by summary execution under Lex Imperialis, Article 447: Heresy via Data-Corruption.
                
                
                """;

        lines = block.split("\n");

        promptBlockTimed(lines);

        System.out.println("""
                
                +++SANCTIFYING CIRCUITS+++
                """);

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\n.");
        }
        System.out.printf("""
                
                +++ACCESS GRANTED+++
                %s
                %s
                
                +++NAVIS IMPERIALIS VOX COMMAND COGITATOR+++
                
                Awaiting blessed input from authorized servant of the Emperor.
                +++GLORIA IMPERATOR+++
                
                """, idSigil, clearanceRank);

        response = menuResponse(input, """
                +++CHOOSE VOX COMMUNICATIONS RELAY ORIGIN+++
                
                [1] LUNAR CLASS CRUISER
                [2] RAMILIES-CLASS STAR FORT
                [3] ASTRA MILITARUM VOX OFFICER
                
                [0] TERMINATE PROGRAM
                
                """);

        switch (response) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 0:

                break;
        }
    }

    private static int menuResponse(Scanner input, String prompt) {
        int choice = -1;
        while (choice == -1) {
            System.out.println(prompt);
            choice = input.nextInt();
            input.nextLine();
        }
        return choice;
    }

    private static void promptBlockTimed(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
