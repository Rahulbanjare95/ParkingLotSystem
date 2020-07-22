public class Owner {
    boolean isLotFull;
    public void parkingLotFull() {
        isLotFull = true;
    }

    public boolean isCapacityFull() {
        return  this.isLotFull;
    }
}
