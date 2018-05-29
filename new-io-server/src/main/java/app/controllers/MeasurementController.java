package app.controllers;

import app.domain.Measurement;
import app.kafka.Sender;
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
    private Sender sender;

    @Autowired
    private MeasurementRepository measurementRepository;


    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> newMeasurement(@RequestBody Measurement measurement) {

        System.out.println(measurement);

        measurementRepository.save(measurement);
        sender.send(measurement);

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
