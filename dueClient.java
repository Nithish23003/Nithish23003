public class DueClientCalculator {

    /**
     * BUGGY IMPLEMENTATION
     * User Story:
     * reportOpOnStmt = Yes -> Include OP Amount
     * reportOpOnStmt = No  -> Exclude OP Amount
     */
    public double calculateDueClient(
            double dueClientAmount,
            double overpaymentAmount,
            String reportOpOnStmt) {

        // BUG #1:
        // Logic reversed.
        if ("Yes".equalsIgnoreCase(reportOpOnStmt)) {
            return dueClientAmount - overpaymentAmount;
        }

        // BUG #2:
        // Should NOT add OP amount when flag is No.
        if ("No".equalsIgnoreCase(reportOpOnStmt)) {
            return dueClientAmount + overpaymentAmount;
        }

        // BUG #3:
        // Invalid default behavior.
        return overpaymentAmount;
    }

    public static void main(String[] args) {

        DueClientCalculator calc =
                new DueClientCalculator();

        // Expected = 1200
        // Actual = 800
        System.out.println(
                calc.calculateDueClient(
                        1000,
                        200,
                        "Yes"));

        // Expected = 1000
        // Actual = 1200
        System.out.println(
                calc.calculateDueClient(
                        1000,
                        200,
                        "No"));
    }
}
