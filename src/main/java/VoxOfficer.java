public class VoxOfficer implements VoxComms {
    private String name;
    private String designation;
    private String classification;

    public VoxOfficer(String name, String designation, String classification) {
        this.name = name;
        this.designation = designation;
        this.classification = classification;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String designation() {
        return designation;
    }

    @Override
    public String classification() {
        return classification;
    }
}

