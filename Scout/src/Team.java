public class Team {
    public int number;
    public String name;
    public int east;
    public String place;
    public int counos_num_high;
    public int counos_littel;
    public int cube_high;
    public int cube;
    public int cube_littel;
    public int cube_low;

    public int getCounos_num_high() {
        return counos_num_high;
    }

    public void setCounos_num_high(int counos_num_high) {
        this.counos_num_high = counos_num_high;
    }

    public int getCounos_littel() {
        return counos_littel;
    }

    public void setCounos_littel(int counos_littel) {
        this.counos_littel = counos_littel;
    }

    public int getCube_high() {
        return cube_high;
    }

    public void setCube_high(int cube_high) {
        this.cube_high = cube_high;
    }

    public int getCube() {
        return cube;
    }

    public void setCube(int cube) {
        this.cube = cube;
    }

    public int getCube_littel() {
        return cube_littel;
    }

    public void setCube_littel(int cube_littel) {
        this.cube_littel = cube_littel;
    }

    public int getQual() {
        return qual;
    }

    public void setQual(int qual) {
        this.qual = qual;
    }

    public int qual;

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int low;
    public Team(int number, String name, int east, String place, int counos_num_high, int cube_high, int cube_low, int low) {
        setNumber(number);
        setName(name);
        setEast(east);
        setPlace(place);

    }

    public int getCube_low() {
        return cube_low;
    }

    public void setCube_low(int cube_low) {
        this.cube_low = cube_low;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    }


