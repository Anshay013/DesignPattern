package carRentalSystem.Tripservice;

import carRentalSystem.model.Trip;

public class TripStartServiceImpl extends TripStartService{


    @Override
    public void startTrip(Trip trip) {
          trip.setHasStarted(true);
    }
}
