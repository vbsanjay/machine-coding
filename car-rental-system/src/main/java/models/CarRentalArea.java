package models;

import java.util.List;

public class CarRentalArea {
    static int idProvider = 0;
    private int id;
    private int noOfPlatforms;
    private int noOfSUVsPerPlatform;
    private int noOfHatchbacksPerPlatform;
    private int noOfSedansPerPlatform;
    private int noOfBikesPerPlatform;
    List<Platform> platforms;

    public CarRentalArea(int noOfPlatforms, int noOfSUVsPerPlatform, int noOfHatchbacksPerPlatform, int noOfSedansPerPlatform, int noOfBikesPerPlatform, List<Platform> platforms) {
        this.id = CarRentalArea.idProvider++;
        this.noOfPlatforms = noOfPlatforms;
        this.noOfSUVsPerPlatform = noOfSUVsPerPlatform;
        this.noOfHatchbacksPerPlatform = noOfHatchbacksPerPlatform;
        this.noOfSedansPerPlatform = noOfSedansPerPlatform;
        this.noOfBikesPerPlatform = noOfBikesPerPlatform;
        this.platforms = platforms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfPlatforms() {
        return noOfPlatforms;
    }

    public void setNoOfPlatforms(int noOfPlatforms) {
        this.noOfPlatforms = noOfPlatforms;
    }

    public int getNoOfSUVsPerPlatform() {
        return noOfSUVsPerPlatform;
    }

    public void setNoOfSUVsPerPlatform(int noOfSUVsPerPlatform) {
        this.noOfSUVsPerPlatform = noOfSUVsPerPlatform;
    }

    public int getNoOfHatchbacksPerPlatform() {
        return noOfHatchbacksPerPlatform;
    }

    public void setNoOfHatchbacksPerPlatform(int noOfHatchbacksPerPlatform) {
        this.noOfHatchbacksPerPlatform = noOfHatchbacksPerPlatform;
    }

    public int getNoOfSedansPerPlatform() {
        return noOfSedansPerPlatform;
    }

    public void setNoOfSedansPerPlatform(int noOfSedansPerPlatform) {
        this.noOfSedansPerPlatform = noOfSedansPerPlatform;
    }

    public int getNoOfBikesPerPlatform() {
        return noOfBikesPerPlatform;
    }

    public void setNoOfBikesPerPlatform(int noOfBikesPerPlatform) {
        this.noOfBikesPerPlatform = noOfBikesPerPlatform;
    }

    public static int getIdProvider() {
        return idProvider;
    }

    public static void setIdProvider(int idProvider) {
        CarRentalArea.idProvider = idProvider;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
}
