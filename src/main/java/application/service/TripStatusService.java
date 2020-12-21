package application.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import application.com.ibm.cloud.trip.Trip;

@Service
public class TripStatusService {

    public Trip getTripStatus(int tripId) {
        Trip trip = new Trip();
        try {

        StringBuffer buffer = new StringBuffer();
        buffer.append("ON TIME - ");
        //buffer.append(InetAddress.getLocalHost().getHostName());
        trip.setBus(tripId);
        trip.setOrigin("MEX");
        trip.setDestination("PUE");
        trip.setStatus(buffer.toString());

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory;

            datatypeFactory = DatatypeFactory.newInstance();
            XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
            trip.setArrivalDate(now);
            trip.setArrivalTime(now);
            trip.setDepartureDate(now);
            trip.setDepartureTime(now);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return trip;
    }
}
