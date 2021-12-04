package ifmo.ru.CourceWorkBackEnd.service;

import ifmo.ru.CourceWorkBackEnd.model.District;
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

    public List<District> getDistrictByCity(String nameCity){
        int city = cityRepository.findByName(nameCity).getId();
        return districtRepository.getNamebyCity(city);
    }

    public District getDistrictById(int id){

       return districtRepository.findById(id);
    }
}
