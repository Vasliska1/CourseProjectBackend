package ifmo.ru.CourceWorkBackEnd.controller;


import ifmo.ru.CourceWorkBackEnd.repository.CityRepository;
import ifmo.ru.CourceWorkBackEnd.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LocationController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LocationService locationService;

    /*@GetMapping("/city")
    public long getId(@RequestBody String name) {
        return cityRepository.findByName(name).getId();
    }
*/
    @GetMapping("/cities")
    public ResponseEntity<?>  getAllCity()
    {
        return ResponseEntity.ok( cityRepository.findAllCity());
    }

    @GetMapping("/districts")
    public ResponseEntity<?> getDisctrictsByCity(@RequestParam("city") String city){
        System.out.println(city);
        return ResponseEntity.ok(locationService.getDistrictsByCity(city));
    }

}
