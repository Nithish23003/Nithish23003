public class DueClientCalculator {
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
