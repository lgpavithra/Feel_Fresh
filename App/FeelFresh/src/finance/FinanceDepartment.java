package finance;

public class FinanceDepartment {

    private static AssetManager assetManager;
    private static LiabilityManager liabilityManager;
    private static EquityManager equityManager;
    private static TransactionManager transactionManager;

    public static AssetManager getAssetManager() {
        if (assetManager == null) {
            assetManager = new AssetManager();
        }
        return assetManager;
    }

    public static EquityManager getEquityManager() {
        if (equityManager == null) {
            equityManager = new EquityManager();
        }
        return equityManager;
    }

    public static LiabilityManager getLiabilityManager() {
        if (liabilityManager == null) {
            liabilityManager = new LiabilityManager();
        }
        return liabilityManager;
    }

    public static TransactionManager getTransactionManager() {
        if (transactionManager == null) {
            transactionManager = new TransactionManager();
        }
        return transactionManager;
    }

}
