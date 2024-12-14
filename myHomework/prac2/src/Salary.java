public class Salary {
    private int pay;
    private Person chargeFrom;
    private Project earnFrom;

    public Salary(int p, Person c, Project e) {
        pay = p;
        chargeFrom = c;
        earnFrom = e;
    }

    public int getPay() {
        return pay;
    }

    public Person getChargeFrom() {
        return chargeFrom;
    }

    public Project getEarnFrom() {
        return earnFrom;
    }
}
