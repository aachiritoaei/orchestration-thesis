package app.controllers;

import app.domain.Device;
import app.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/devices/")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> newDevice(@RequestBody Map<String, Object> deviceMap) {
        Device device = new Device(
                deviceMap.get("deveui").toString(),
                deviceMap.get("userid").toString(),
                deviceMap.get("location").toString(),
                deviceMap.get("description").toString());

        deviceRepository.save(device);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Device created successfully");
        response.put("device", device);

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAll")
    public Map<String, Object> deleteAllDevices() {
        deviceRepository.deleteAll();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All devices deleted successfully");

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Device> getAllDevices() {

        return deviceRepository.findAll();
    }
}
