public class Earth extends Apple {
    protected int howMany;
    protected String climate;
    public Earth(boolean human, int size, String type, int howMany, String climate ) {
        super(type, size, human);
        this.howMany = howMany;
        this.climate = climate;

    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
}
