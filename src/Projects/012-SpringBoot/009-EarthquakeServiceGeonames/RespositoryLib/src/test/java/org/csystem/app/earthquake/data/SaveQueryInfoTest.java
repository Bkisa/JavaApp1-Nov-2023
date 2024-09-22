package org.csystem.app.earthquake.data;

import org.csystem.app.earthquake.data.entity.EarthquakeInfo;
import org.csystem.app.earthquake.data.entity.RegionInfo;
import org.csystem.app.earthquake.data.repository.IRegionInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveQueryInfoTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    public void givenValue_whenEarthquake_thenSaveDoesNotThrowSQLException()
    {
        var regionInfo = RegionInfo.builder()
                .east(23.4)
                .west(21.4)
                .north(20.4)
                .south(29.4)
                .build();

        m_regionInfoRepository.save(regionInfo);

        var earthquakeInfo = EarthquakeInfo.builder()
                .regionInfoId(regionInfo.id)
                .dateTime("2023-02-06 04:00:00")
                .depth(100)
                .latitude(45.67)
                .longitude(40.67)
                .earthquakeId("Test earthquake")
                .magnitude(7.6)
                .locality("Test locality")
                .street("Test street")
                .postalCode("67100")
                .distance("100")
                .countryCode("TR")
                .countryName("Turkey")
                .build();

        m_regionInfoRepository.saveEarthquake(earthquakeInfo);

        assertDoesNotThrow(() -> m_regionInfoRepository.saveEarthquakeQueryInfo(1));
    }
}
