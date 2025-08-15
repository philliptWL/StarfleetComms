public class Cruiser implements VoxComms{
    private String name;
    private String designation;
    private String classification;

    public Cruiser(String name, String designation, String classification){
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
        message = messageEncryption(message);
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
                
                BROADCASTING FROM SANCTIFIED IMPERIAL CRUISER
                %s
                
                +++GLORIA IMPERATOR+++
                """,getName()
        );
    }
    private static String messageEncryption(String message) {
        if(message.isBlank()) return "";
        return message
                .replace("e", "3").replace("E", "3")
                .replace("a", "4").replace("A", "4")
                .replace("i", "1").replace("I", "1")
                .replace("o", "0").replace("O", "0")
                .replace("s", "5").replace("S", "5")
                .replace("t", "7").replace("T", "7")
                .replace("g", "9").replace("G", "9")
                .replace("b", "8").replace("B", "8")
                .replace("l", "1").replace("L", "1");
    }
}
