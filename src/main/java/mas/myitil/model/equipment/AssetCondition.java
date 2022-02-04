package mas.myitil.model.equipment;

public enum AssetCondition {
    IN_STOCK("In Stock"),
    IN_REPAIR("In Repair"),
    DEPLOYED("Deployed");

    private String name;

    AssetCondition(String name ) {
        this.name = name;
    }

    public String getAssetCondition() {
        return name;
    }
}
