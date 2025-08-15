import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CentralComms {
    public static void start(){
        Scanner input = new Scanner(System.in);
        ArrayList<String> logVoxComms = new ArrayList<>();
        String block;
        String[] lines;
        int response = -1;

        ArrayList<Cruiser> cruisers = initializeCruisers();
        ArrayList<StarFort> starForts = initializeStarForts();
        ArrayList<VoxOfficer> voxOfficers = initializeVoxOfficers();

        while(response != 0) {
            block = """
                    +++COGITATOR ACCESS POINT+++
                    
                    BY THE OMNISSIAH'S WILL, THIS TERMINAL IS SANCTIFIED. BY THE EMPEROR'S LIGHT, THIS DATA IS PURE.
                    
                    +++ENTER CREDENTIALS+++
                    
                    IDENTIFICATION SIGIL: ██████████
                    
                    """;

            lines = block.split("\n");

            promptBlockTimed(lines);

            String idSigil = input.nextLine();

            idSigil = "IDENTIFICATION SIGIL: " + idSigil.toUpperCase();

            System.out.println("CLEARANCE RANK: ██████████");

            String clearanceRank = input.nextLine();

            clearanceRank = "CLEARANCE RANK: " + clearanceRank.toUpperCase();

            block = """
                    LITANY OF ACCESS: RECITE THE THIRD CANTICLE OF AWAKENING
                    
                    SECURITY CHALLENGES: BYPASSED
                    
                    VOICEPRINT AUTHENTICATION - PENDING
                    
                    ROSETTE SEAL SCAN - PENDING
                    
                    MACHINE SPIRIT BENEDICTION - PENDING
                    
                    +++WARNING+++
                    
                    UNAUTHORIZED ACCESS IS PUNSIHABLE BY SUMMARY EXECUTION UNDER LEX IMPERIALIS, ARTICLE 447: HERESY VIA DATA-CORRUPTION
                    
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
                System.out.print(".\n");
            }
            System.out.printf("""
                    
                    +++ACCESS GRANTED+++
                    %s
                    %s
                    
                    +++NAVIS IMPERIALIS VOX COMMAND COGITATOR+++
                    
                    AWAITING BLESSED INPUT FROM AUTHORIZED SERVANT OF THE EMPEROR.
                    
                    +++GLORIA IMPERATOR+++
                    
                    """, idSigil, clearanceRank);


            while(response != 0) {
                response = menuResponse(input, """
                    +++CHOOSE VOX COMMUNICATIONS RELAY ORIGIN+++
                    
                    [1] IMPERIAL CRUISER
                    [2] ASTRAL BASTION
                    [3] ASTRA MILITARUM VOX OFFICER
                    
                    [4] VIEW VOX COMMUNICATIONS LOG
                    
                    [0] TERMINATE PROGRAM
                    
                    """);
                switch (response) {
                    case 1:
                        listCruisers(cruisers);
                        response = menuResponse(input, "CHOOSE IMPERIAL CRUISER:");
                        cruisers.get(response - 1).identify();
                        generateMessage(cruisers.get(response - 1),logVoxComms);
                        response = -1;
                        break;
                    case 2:
                        listStarForts(starForts);
                        response = menuResponse(input, "CHOOSE ASTRAL BASTION:");
                        starForts.get(response - 1).identify();
                        generateMessage(starForts.get(response - 1),logVoxComms);
                        response = -1;
                        break;
                    case 3:
                        listVoxOfficers(voxOfficers);
                        response = menuResponse(input, "CHOOSE IMPERIAL OFFICER:");
                        voxOfficers.get(response - 1).identify();
                        generateMessage(voxOfficers.get(response - 1),logVoxComms);
                        response = -1;
                        break;
                    case 4:
                        for(String log : logVoxComms){
                            System.out.println(log);
                        }
                        response = -1;
                        break;
                    case 0:
                        System.out.println("""
                                +++THE EMPEROR PROTECTS+++
                                """);
                        break;
                    default:
                        System.out.println("INVALID OPTION");
                }
            }
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

    private static ArrayList<Cruiser> initializeCruisers() {
        ArrayList<Cruiser> cruisers = new ArrayList<>();
        cruisers.add(new Cruiser("HIS ETERNAL WRATH", "IMPERIAL CRUISER", "LUNAR-CLASS"));
        cruisers.add(new Cruiser("SWORD OF VENGEANCE", "IMPERIAL CRUISER", "GOTHIC-CLASS"));
        cruisers.add(new Cruiser("HAMMER OF THE OMNISSIAH", "IMPERIAL CRUISER", "DICTATOR-CLASS"));
        return cruisers;
    }

    private static ArrayList<StarFort> initializeStarForts() {
        ArrayList<StarFort> starForts = new ArrayList<>();
        starForts.add(new StarFort("BASTION INVICTUS", "IMPERIAL ASTRAL BASTION", "RAMILIES-CLASS"));
        starForts.add(new StarFort("WARD OF TERRA", "IMPERIAL ASTRAL BASTION", "PHALANX-TYPE"));
        return starForts;
    }

    private static ArrayList<VoxOfficer> initializeVoxOfficers() {
        ArrayList<VoxOfficer> voxOfficers = new ArrayList<>();
        voxOfficers.add(new VoxOfficer("SEPTIMUS HALE", "IMPERIAL VOX OFFICER", "LORD-CAPTAIN"));
        voxOfficers.add(new VoxOfficer("GARAN VOSS", "IMPERIAL VOX OFFICER", "COLONEL"));
        voxOfficers.add(new VoxOfficer("HELENA DRAIK", "IMPERIAL VOX OFFICER", "COMMISSAR"));
        voxOfficers.add(new VoxOfficer("MIRELLA VANE", "IMPERIAL VOX OFFICER", "LIEUTENANT-COMMANDER"));
        voxOfficers.add(new VoxOfficer("HADRUS KELL", "IMPERIAL VOX OFFICER", "MASTER OF ORDNANCE"));
        return voxOfficers;
    }

    private static void listCruisers(ArrayList<Cruiser> cruisers) {
        System.out.println("""
                +++IMPERIAL CRUISERS+++
                """);
        for (int i = 0; i< cruisers.size();i++) {
            System.out.printf("""
        [%d] %s
        """,i + 1, cruisers.get(i).getName()
            );
        }
        System.out.println("""
                
                [0] RETURN TO PREVIOUS MENU
                """);
    }

    private static void listStarForts(ArrayList<StarFort> starForts) {
        System.out.println("""
                +++ASTRAL BASTIONS+++
                """);
        for (int i = 0; i< starForts.size();i++) {
            System.out.printf("""
        [%d] %s
        """,i + 1, starForts.get(i).getName()
            );
        }
        System.out.println("""
                
                [0] RETURN TO PREVIOUS MENU
                """);
    }

    private static void listVoxOfficers(ArrayList<VoxOfficer> voxOfficers) {
        System.out.println("""
                +++IMPERIAL VOX OFFICERS+++
                """);
        for (int i = 0; i< voxOfficers.size();i++) {
            System.out.printf("""
                    [%d] %s %s
                    """,i + 1, voxOfficers.get(i).getRank(),voxOfficers.get(i).getName()
            );
        }
        System.out.println("""
                
                [0] RETURN TO PREVIOUS MENU
                """);
    }

    private static void generateMessage(Object object, ArrayList<String> logVoxComms){
        switch(object){
            case Cruiser cruiser -> messageCruiser(cruiser,logVoxComms);
            case StarFort starFort -> messageStarFort(starFort,logVoxComms);
            case VoxOfficer voxOfficer -> messageVoxOfficer(voxOfficer,logVoxComms);
            default -> {}
        }
    }

    private static void messageCruiser(Cruiser cruiser, ArrayList<String> logVoxComms){
        double random = Math.random();
        System.out.println("\n+++CRUISER BROADCAST+++");
        if(random <= 0.3) {
            logMessage(Optional.of(cruiser),Optional.empty(),Optional.empty(),cruiser.transmit("""
                VESSEL MAINTAINING STRATEGIC PATROL FORMATION
                PRIMARY BATTERIES AT FULL READINESS
                SECONDARY ARMAMENTS CALIBRATED
                """),logVoxComms);
            System.out.println("\n+++FOR THE EMPEROR+++");
        } else if (random <= 0.6) {
            logMessage(Optional.of(cruiser),Optional.empty(),Optional.empty(),cruiser.transmit("""
                TARGETS ACQUIRED – WEAPONS FREE ON COMMAND
                ALL HANDS AT ACTION STATIONS
                VOID SHIELDS HOLDING STEADY
                """
            ),logVoxComms);
            System.out.println("\n+++PURGE THE HERETIC+++");
        }else{
            logMessage(Optional.of(cruiser),Optional.empty(),Optional.empty(),cruiser.transmit("""
                    COURSE LAID IN FORMATION WITH BATTLEFLEET ELEMENTS
                    COMMUNICATIONS CHANNELS SECURE
                    ORDNANCE STOCKPILES AT MISSION CAPACITY
                    """
            ),logVoxComms);
            System.out.println("\n+++NO MERCY, NO RESPITE+++");
        }
    }

    private static void messageStarFort(StarFort starFort, ArrayList<String> logVoxComms){
        double random = Math.random();
        System.out.println("\n+++ASTRAL BASTION BROADCAST+++");
        if(random <= 0.3) {
            logMessage(Optional.empty(),Optional.of(starFort),Optional.empty(),
                    starFort.transmit("NOMINAL"),logVoxComms);
        } else if (random <= 0.6) {
            logMessage(Optional.empty(),Optional.of(starFort),Optional.empty(),
                    starFort.transmit("UNDER DURESS"),logVoxComms);
        }else{
            logMessage(Optional.empty(),Optional.of(starFort),Optional.empty(),
                    starFort.transmit("MACHINE SPIRIT AGITATED"),logVoxComms);
        }
    }

    private static void messageVoxOfficer(VoxOfficer voxOfficer, ArrayList<String> logVoxComms){
        double random = Math.random();
        System.out.println("\n+++VOX OFFICER BROADCAST+++");
        if(random <= 0.3) {
            logMessage(Optional.empty(),Optional.empty(),Optional.of(voxOfficer),
                    voxOfficer.transmit("SECURE THE WESTERN APPROACH TO THE RIDGE; HOLD UNTIL THE RELIEF OF THE 22ND."),
                    logVoxComms);
            System.out.println("\n+++FOR THE EMPEROR+++");
        } else if (random <= 0.6) {
            logMessage(Optional.empty(),Optional.empty(),Optional.of(voxOfficer),
                    voxOfficer.transmit("PURGE THE HERETIC ELEMENTS IN THE HAB-BLOCKS OF DECKS XIV TO XVI; REPORT TO COMMAND ON COMPLETION."),
                    logVoxComms);
            System.out.println("\n+++PURGE THE HERETIC+++");
        }else{
            logMessage(Optional.empty(),Optional.empty(),Optional.of(voxOfficer),
                    voxOfficer.transmit("DEPLOY THE 3RD COHORT TO THE DOCKING BAY OF BASTION INVICTUS; ESTABLISH A PERIMETER."),
                    logVoxComms);
            System.out.println("\n+++NO MERCY, NO RESPITE+++");
        }
    }
    private static void logMessage(Optional<Cruiser> cruiser, Optional<StarFort> starFort,
                                      Optional<VoxOfficer> voxOfficer,String message, ArrayList<String> logVoxComms){
        if(cruiser.isPresent()) {
            logVoxComms.add(cruiser.get().getName() + " - " + cruiser.get().getClassification() + " - "
                    + cruiser.get().getDesignation() + ":\n" + message);
        } else if(starFort.isPresent()) {
            logVoxComms.add(starFort.get().getName() + " - " + starFort.get().getClassification() + " - "
            + starFort.get().getDesignation() + ":\n" + message);
        } else if(voxOfficer.isPresent()) {
            logVoxComms.add(voxOfficer.get().getName() + " - " + voxOfficer.get().getRank() + " - "
            + voxOfficer.get().getDesignation() + ":\n" + message);
        } else {
            System.out.println("INVALID OPTION");
        }
        System.out.println(message);
    }

}

