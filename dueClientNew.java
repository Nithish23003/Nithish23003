public class DueClientCalculator {

    /**
     * Calculates Due Client amount based on
     * reportOpOnStmt configuration.
     *
     * AC1:
     * reportOpOnStmt = Yes
     * Include overpayment amount.
     *
     * AC2:
     * reportOpOnStmt = No
     * Exclude overpayment amount.
     */
    public double calculateDueClient(
            double dueClientAmount,
            double overpaymentAmount,
            boolean reportOpOnStmt) {

        if (reportOpOnStmt) {
            return dueClientAmount + overpaymentAmount;
        }

        return dueClientAmount;
    }

    public static void main(String[] args) {

        DueClientCalculator calculator =
                new DueClientCalculator();

        // AC1
        double dueClientWithOP =
                calculator.calculateDueClient(
                        1000.00,
                        200.00,
                        true);

        System.out.println(
                "Due Client (reportOpOnStmt=Yes): "
                        + dueClientWithOP);

        // AC2
        double dueClientWithoutOP =
                calculator.calculateDueClient(
                        1000.00,
                        200.00,
                        false);

        System.out.println(
                "Due Client (reportOpOnStmt=No): "
                        + dueClientWithoutOP);
    }
}
