package com.surgiconn.connect.controllers;

//import com.surgiconn.connect.models.AboutUs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.surgiconn.connect.models.nppes.NPPES;
import com.surgiconn.connect.models.nppes.NPI;
//import com.surgiconn.connect.services.NPPESService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/nppes")
@Api(value = "NPPES NPI Registry", description = "NPPES Read API Interactive Application")
public class NPPESController {
    @Value("${serviceURL}")
    String serviceURL;

    private static final Logger logger = LoggerFactory.getLogger(NPPESController.class);

    @ApiOperation(value = "NPI Registry check with NPI number")
    @GetMapping(path = "/check")
    public ResponseEntity<?> getNPIRegistry(@RequestParam String npi) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("GET ALL::: "+ restTemplate.getForObject(serviceURL + "&number=" + npi, String.class));
            NPPES readValue = mapper.readValue(restTemplate.getForObject(serviceURL + "&number=" + npi, String.class), NPPES.class);
            System.out.println("readValue: "+ readValue.getResults().get(0).getBasic().getFirst_name());
            return ResponseEntity.ok().body(readValue.getResults().stream().findFirst().get().getBasic());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}