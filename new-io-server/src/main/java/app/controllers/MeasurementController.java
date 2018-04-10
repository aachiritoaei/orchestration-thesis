package app.controllers;

import app.domain.Measurement;
import app.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/measurements/")
public class MeasurementController {

    @Autowired
    private MeasurementRepository measurementRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> newMeasurement(@RequestBody Map<String, Object> measurementMap) {
        Measurement measurement = new Measurement(
                measurementMap.get("deveui").toString(),
                measurementMap.get("datatype").toString(),
                measurementMap.get("rawdata").toString(),
                measurementMap.get("jsondata").toString());

        measurementRepository.save(measurement);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Measurement created successfully");
        response.put("measurement", measurement);

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAll")
    public Map<String, Object> deleteAllMeasurements() {
        measurementRepository.deleteAll();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All measurements deleted successfully");

        return response;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Measurement> getAllMeasurements() {

        return measurementRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"deveui"})
    public List<Measurement> getAllMeasurementsForOneDevice(@RequestParam(value = "deveui") String devEui) {

        return measurementRepository.findAllByDevEui(devEui);
    }
}
