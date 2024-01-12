public enum NotesAndCoins {
    PENCE1(1,"1p"),
    PENCE2(2,"2p"),
    PENCE5(5,"5p"),
    PENCE10(10,"10p"),
    PENCE20(20,"20p"),
    PENCE50(50,"50p"),
    POUND1(100,"£1"),
    POUND2(200,"£2"),
    POUND5(500,"£5"),
    POUND10(1000,"£10"),
    POUND20(2000,"£20"),
    POUND50(5000,"£50");

    //how many pence is each constant worth
    private int valueInP;
    //a user friendly name for the constant
    private String name;

    //add constructors and getters for valueInP and name

    NotesAndCoins(int valueInP, String name) {
        this.valueInP = valueInP;
        this.name = name;
    }

    public int getValueInP() {
        return valueInP;
    }

    public void setValueInP(int valueInP) {
        this.valueInP = valueInP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
