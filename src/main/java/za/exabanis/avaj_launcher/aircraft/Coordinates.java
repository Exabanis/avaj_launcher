package za.exabanis.avaj_launcher.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    /**
     *
     * This constructs coordinates according to the specified longitude, latitude and height
     * @param longitude
     * @param latitude
     * @param height
     */
    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = this.getHeight() + height > 100 ? 100 : this.getHeight() + height < 0 ? 0 : height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    /**
     *
     * @return the coordinates of an Aircraft longitude, latitude and the height
     *
     */
    @Override
    public String toString() {
        return String.format("longitude(%s), latitude(%s), height(%s)",getLongitude(), getLatitude(), getHeight());
    }
}
