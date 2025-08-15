public class StarFort implements VoxComms{
    private String name;
    private String designation;
    private String classification;

    public StarFort(String name, String designation, String classification){
        this.name = name;
        this.designation = designation;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getClassification() {
        return classification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String transmit(String message) {
        String date = String.format("%03d", (int)(Math.random()*999)) + ".532.M41";
        return String.format("""
                +++TRANSMISSION ORDER+++
                
                +++CHRONO-LOG: %s+++
                %s
                
                +++GLORY TO THE OMNISSIAH+++
                """,date,message);
    }

    @Override
    public void identify() {
        System.out.printf("""
                +++IDENTITY VERIFICATION COMPLIANCE+++
                
                BROADCASTING FROM IMPERIAL ASTRAL BASTION
                %s
                
                +++GLORIA IMPERATOR+++
                """,name
        );
    }

    private String broadcastStatus(String message) {
        String status = switch (message.toUpperCase()) {
            case "NOMINAL" -> """
                DOCKING BAYS: OPERATIONAL
                MACROCANNONS: AT FULL READINESS
                GELLER FIELD: STABLE
                SPIRITUS MACHINA: CALM
                """;
            case "UNDER DURESS" -> """
                VOID SHIELDS: 78%
                MACROCANNONS: CONTINUOUS FIRE ORDER
                GELLER FIELD: STABLE
                SPIRITUS MACHINA: FOCUSED
                """;
            case "MACHINE SPIRIT AGITATED" -> """
                VOID SHIELDS: 96%
                MACROCANNONS: OPERATIONAL – PRIMARY SPIRIT IRRITATED
                GELLER FIELD: RITUAL STABILIZATION IN PROGRESS
                SPIRITUS MACHINA: RESTLESS
                """;
            default -> """
                VOID SHIELDS: 100%
                MACROCANNONS: OPERATIONAL
                GELLER FIELD: ACTIVE
                SPIRITUS MACHINA: CALM
                """;
        };

        return String.format("""
            +++%s STATUS+++
            
            %s
            +++GLORIA IMPERATOR+++
            """, name, status);
    }

}
