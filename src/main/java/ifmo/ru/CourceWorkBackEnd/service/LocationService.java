package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.District;
import ifmo.ru.CourceWorkBackEnd.model.Factory;
import ifmo.ru.CourceWorkBackEnd.repository.CityRepository;
import ifmo.ru.CourceWorkBackEnd.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<String> getDistrictsByCity(String nameCity) {
        int city = cityRepository.findByName(nameCity).getId();
        return districtRepository.getNamebyCity(city);
    }

    public District getDistrictByNameAndCity(String cityName, String nameDistr) {
        int city = cityRepository.findByName(cityName).getId();
        return districtRepository.findByIdCityAndName(city, nameDistr);
    }


}
