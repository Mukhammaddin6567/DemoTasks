package designPatterns.behavioralPatterns;

class Expense {
    private final double amount;

    public Expense(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

interface Approver {
    void setNextApprover(Approver nextApprover);

    void processRequest(Expense expense);
}

// Concrete Handler: Team Lead
class TeamLead implements Approver {
    private Approver nextApprover;

    @Override
    public void processRequest(Expense expense) {
        if (expense.getAmount() <= 1000)
            System.out.println("Team Lead approves the expense of $" + expense.getAmount());
        else if (nextApprover != null) nextApprover.processRequest(expense);
    }

    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

// Concrete Handler: Project Manager
class ProjectManager implements Approver {
    private Approver nextApprover;

    @Override
    public void processRequest(Expense expense) {
        if (expense.getAmount() <= 5_000)
            System.out.println("Project Manager approves the expense of $" + expense.getAmount());
        else if (nextApprover != null) nextApprover.processRequest(expense);
    }

    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

// Concrete Handler: Director
class Director implements Approver {
    private Approver nextApprover;

    @Override
    public void processRequest(Expense expense) {
        if (expense.getAmount() <=10_000) System.out.println("Director approves the expense of $" + expense.getAmount());
        else System.out.println("Expense of $" + expense.getAmount() + " requires board approval");
    }

    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

class ChainOfResponsibility {
    public static void main(String[] args) {
        // Create the chain of responsibility
        Approver teamLead = new TeamLead();
        Approver projectManager = new ProjectManager();
        Approver director = new Director();

        teamLead.setNextApprover(projectManager);
        projectManager.setNextApprover(director);

        // Create some expenses
        Expense expense1 = new Expense(500);
        Expense expense2 = new Expense(2_500);
        Expense expense3 = new Expense(5_000);
        Expense expense4 = new Expense(7_500);
        Expense expense5 = new Expense(10_000);
        Expense expense6 = new Expense(15_000);

        teamLead.processRequest(expense1);
        teamLead.processRequest(expense2);
        teamLead.processRequest(expense3);
        teamLead.processRequest(expense4);
        teamLead.processRequest(expense5);
        teamLead.processRequest(expense6);
    }
}
