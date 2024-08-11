package org.csystem.app.service.earthquake.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.csystem.app.earthquake.data.entity.EarthquakeAddress;
import org.csystem.app.earthquake.data.entity.EarthquakeCountryInfo;
import org.csystem.app.earthquake.data.entity.EarthquakeInfo;
import org.csystem.app.earthquake.data.entity.EarthquakeInfoDetails;
import org.csystem.app.earthquake.data.entity.EarthquakesInfo;
import org.csystem.app.service.earthquake.dto.EarthquakeDetails;
import org.csystem.app.service.earthquake.dto.EarthquakeDetailsAddress;
import org.csystem.app.service.earthquake.dto.EarthquakeDetailsCountryInfo;
import org.csystem.app.service.earthquake.dto.EarthquakeDetailsInfo;
import org.csystem.app.service.earthquake.dto.EarthquakesDetails;
import org.csystem.app.service.earthquake.geonames.dto.GeonamesEarthquakeDetails;
import org.csystem.app.service.earthquake.geonames.dto.GeonamesEarthquakeInfoDetails;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-10T15:42:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class EarthquakeMapperImpl implements IEarthquakeMapper {

    @Override
    public EarthquakeInfo toEarthquakeInfo(EarthquakeDetailsInfo earthquakeDetailsInfo) {
        if ( earthquakeDetailsInfo == null ) {
            return null;
        }

        EarthquakeInfo.EarthquakeInfoBuilder earthquakeInfo = EarthquakeInfo.builder();

        earthquakeInfo.dateTime( earthquakeDetailsInfo.dateTime );
        earthquakeInfo.depth( earthquakeDetailsInfo.depth );
        earthquakeInfo.latitude( earthquakeDetailsInfo.latitude );
        earthquakeInfo.longitude( earthquakeDetailsInfo.longitude );
        earthquakeInfo.earthquakeId( earthquakeDetailsInfo.earthquakeId );
        earthquakeInfo.magnitude( earthquakeDetailsInfo.magnitude );

        return earthquakeInfo.build();
    }

    @Override
    public EarthquakeAddress toEarthquakeAddress(EarthquakeDetailsAddress earthquakeDetailsAddress) {
        if ( earthquakeDetailsAddress == null ) {
            return null;
        }

        EarthquakeAddress.EarthquakeAddressBuilder earthquakeAddress = EarthquakeAddress.builder();

        earthquakeAddress.locality( earthquakeDetailsAddress.locality );
        earthquakeAddress.street( earthquakeDetailsAddress.street );
        earthquakeAddress.postalCode( earthquakeDetailsAddress.postalCode );

        return earthquakeAddress.build();
    }

    @Override
    public EarthquakeCountryInfo toEarthquakeCountryInfo(EarthquakeDetailsCountryInfo earthquakeDetailsCountryInfo) {
        if ( earthquakeDetailsCountryInfo == null ) {
            return null;
        }

        EarthquakeCountryInfo.EarthquakeCountryInfoBuilder earthquakeCountryInfo = EarthquakeCountryInfo.builder();

        earthquakeCountryInfo.distance( earthquakeDetailsCountryInfo.distance );
        earthquakeCountryInfo.countryCode( earthquakeDetailsCountryInfo.countryCode );
        earthquakeCountryInfo.countryName( earthquakeDetailsCountryInfo.countryName );

        return earthquakeCountryInfo.build();
    }

    @Override
    public EarthquakesDetails toEarthquakeDetails(GeonamesEarthquakeInfoDetails geonamesEarthquakeDetails) {
        if ( geonamesEarthquakeDetails == null ) {
            return null;
        }

        EarthquakesDetails earthquakesDetails = new EarthquakesDetails();

        earthquakesDetails.earthquakes = geonamesEarthquakeDetailsListToEarthquakeDetailsList( geonamesEarthquakeDetails.earthquakes );

        return earthquakesDetails;
    }

    @Override
    public EarthquakesDetails toEarthquakeDetails(EarthquakesInfo earthquakesInfo) {
        if ( earthquakesInfo == null ) {
            return null;
        }

        EarthquakesDetails earthquakesDetails = new EarthquakesDetails();

        earthquakesDetails.earthquakes = earthquakeInfoDetailsListToEarthquakeDetailsList( earthquakesInfo.earthquakes );

        return earthquakesDetails;
    }

    protected EarthquakeDetails geonamesEarthquakeDetailsToEarthquakeDetails(GeonamesEarthquakeDetails geonamesEarthquakeDetails) {
        if ( geonamesEarthquakeDetails == null ) {
            return null;
        }

        EarthquakeDetails earthquakeDetails = new EarthquakeDetails();

        return earthquakeDetails;
    }

    protected List<EarthquakeDetails> geonamesEarthquakeDetailsListToEarthquakeDetailsList(List<GeonamesEarthquakeDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<EarthquakeDetails> list1 = new ArrayList<EarthquakeDetails>( list.size() );
        for ( GeonamesEarthquakeDetails geonamesEarthquakeDetails : list ) {
            list1.add( geonamesEarthquakeDetailsToEarthquakeDetails( geonamesEarthquakeDetails ) );
        }

        return list1;
    }

    protected EarthquakeDetails earthquakeInfoDetailsToEarthquakeDetails(EarthquakeInfoDetails earthquakeInfoDetails) {
        if ( earthquakeInfoDetails == null ) {
            return null;
        }

        EarthquakeDetails earthquakeDetails = new EarthquakeDetails();

        return earthquakeDetails;
    }

    protected List<EarthquakeDetails> earthquakeInfoDetailsListToEarthquakeDetailsList(List<EarthquakeInfoDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<EarthquakeDetails> list1 = new ArrayList<EarthquakeDetails>( list.size() );
        for ( EarthquakeInfoDetails earthquakeInfoDetails : list ) {
            list1.add( earthquakeInfoDetailsToEarthquakeDetails( earthquakeInfoDetails ) );
        }

        return list1;
    }
}