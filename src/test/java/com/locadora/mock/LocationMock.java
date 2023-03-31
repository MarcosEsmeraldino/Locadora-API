package com.locadora.mock;

import com.locadora.model.Location;

import static com.locadora.mock.ConstantsMock.*;

public class LocationMock {

    public static Location getMock() {
        Location location = new Location();
        location.setId(LOCATION_ID);
        location.setExpectedDate(LOCATION_EXPECTED_DATE);
        location.setStartDate(LOCATION_START_DATE);
        location.setFinishDate(LOCATION_FINISH_DATE);
        location.setUser(UserMock.getMock());
        return location;
    }
}
