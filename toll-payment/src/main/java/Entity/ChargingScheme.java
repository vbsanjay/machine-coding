package Entity;

public class ChargingScheme {
    private int bikeRate;
    private int carRate;
    private int truckRate;
    private int overSizedVehicleRate;

    public ChargingScheme(int bikeRate, int carRate, int truckRate, int overSizedVehicleRate) {
        this.bikeRate = bikeRate;
        this.carRate = carRate;
        this.truckRate = truckRate;
        this.overSizedVehicleRate = overSizedVehicleRate;
    }

    public int getBikeRate() {
        return bikeRate;
    }

    public void setBikeRate(int bikeRate) {
        this.bikeRate = bikeRate;
    }

    public int getCarRate() {
        return carRate;
    }

    public void setCarRate(int carRate) {
        this.carRate = carRate;
    }

    public int getTruckRate() {
        return truckRate;
    }

    public void setTruckRate(int truckRate) {
        this.truckRate = truckRate;
    }

    public int getOverSizedVehicleRate() {
        return overSizedVehicleRate;
    }

    public void setOverSizedVehicleRate(int overSizedVehicleRate) {
        this.overSizedVehicleRate = overSizedVehicleRate;
    }
}
