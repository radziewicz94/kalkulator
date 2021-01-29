//wyrzucic pozniej
public enum GetNextNumber {

    YES(1, "Tak"),
    NO(2, "Nie");
    GetNextNumber(int value, String description) {
        this.value = value;
        this.description = description;
    }
    int value;
    String description;

    static void printOption(){
        for (GetNextNumber value : GetNextNumber.values()) {
            System.out.println(value);
        }
    }
    static GetNextNumber getOption(int option){
        return GetNextNumber.values()[option - 1];
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
}
