package application.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import application.com.ibm.cloud.trip.TripStatusRequest;
import application.com.ibm.cloud.trip.TripStatusResponse;
import application.service.TripStatusService;

@Endpoint
public class TripStatusEndpoint {

    @Autowired
    private TripStatusService service;

    @PayloadRoot(namespace = "http://www.ibm.com/cloud/trip",
    localPart = "TripStatusRequest")
    @ResponsePayload
    public TripStatusResponse getTripStatusResponse(@RequestPayload TripStatusRequest request) {
        TripStatusResponse response = new TripStatusResponse();
        response.setTrip(service.getTripStatus(request.getTrip()));
        return response;

    }
}
