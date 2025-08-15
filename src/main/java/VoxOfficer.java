public class VoxOfficer implements VoxComms {
    private final String name;
    private final String designation;
    private final String rank;

    public VoxOfficer(String name, String designation, String rank) {
        this.name = name;
        this.designation = designation;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String transmit(String message) {
        String date = String.format("%03d", (int)(Math.random()*999)) + ".532.M41";
        return String.format("""
                +++TRANSMISSION ORDER+++
                
                +++CHRONO-LOG: %s+++
                +++BATTLEFRONT: %s+++
                +++DIRECTIVE: %s+++
                
                +++GLORY TO THE EMPEROR+++
                """,date,battlefrontLocation(), toDirective(message)
        );
    }

    @Override
    public void identify() {
        String nameAndRank = String.format("%s %s",name,rank);

        System.out.printf("""
                +++IDENTITY VERIFICATION COMPLIANCE+++
                
                BROADCASTING FROM ASTRA MILITARUM OFFICER
                %s
                
                +++GLORIA IMPERATOR+++
                """,nameAndRank);
    }

    private String battlefrontLocation(){
        return switch (rank) {
            case "LORD-CAPTAIN" -> "ARMAGEDDON";
            case "COLONEL" -> "KRIEG";
            case "COMMISSAR" -> "VOSTROYA";
            case "LIEUTENANT-COMMANDER" -> "MORDIAN";
            case "MASTER OF ORDNANCE" -> "TALLARN";
            default -> "";
        };
    }

    private String toDirective(String message) {
        if (message == null || message.isBlank()) return "NO DIRECTIVE";
        return message.toUpperCase()
                .trim()
                .replaceAll("\\b(THE|A|AN|TO|OF)\\b", "")
                .replaceAll("\\s{2,}", " ")
                .trim();
    }

}

