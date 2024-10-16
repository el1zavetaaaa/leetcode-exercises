package yl.lbnts.leetcode.algorithm.parcking_system;

public class ParkingSystem {
    int [] big_parking_lot, medium_parking_lot, small_parking_lot;
    int big_car_count, medium_car_count, small_car_count;

    public ParkingSystem(int big, int medium, int small) {
        big_parking_lot = new int[big];
        medium_parking_lot = new int[medium];
        small_parking_lot = new int[small];
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                boolean freeParkPlaceBig = checkWhetherThereIsAFreeParkingLot(big_parking_lot, big_car_count);
                if(freeParkPlaceBig){
                    big_car_count ++;
                }
                return freeParkPlaceBig;
            case 2:
                boolean freeParkPlaceMed = checkWhetherThereIsAFreeParkingLot(medium_parking_lot, medium_car_count);
                if(freeParkPlaceMed){
                    medium_car_count ++;
                }
                return freeParkPlaceMed;
            case 3:
                boolean freeParkPlaceSmall = checkWhetherThereIsAFreeParkingLot(small_parking_lot, small_car_count);
                if(freeParkPlaceSmall){
                    small_car_count ++;
                }
                return freeParkPlaceSmall;
            default:
                return false;
        }
    }

    private boolean checkWhetherThereIsAFreeParkingLot(int [] parkingLot, int car_count){
        return car_count < parkingLot.length;
    }
}
