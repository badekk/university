package pjatk.jazs21166nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import pjatk.jazs21166nbp.model.Nbp;
import pjatk.jazs21166nbp.service.NbpService;

import java.util.Date;

@RestController
@RequestMapping("/NBP")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation(value =  "Find average rate",
            response = Nbp.class,
            notes = "Getting averate rate from provided dates")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Data not found"),
            @ApiResponse(code = 500, message = "Unexpected error")
    })

    @GetMapping("/average/{date_from}/{date_to}")
    public ResponseEntity<Nbp> averagePrice(
        @ApiParam(name = "date_from",
            type = "date",
            value = "2021-05-25",
            example = "2021-05-26",
            required = true,
            defaultValue = "1")
        @PathVariable Date dateFrom,
        @ApiParam(name = "date_to",
                type = "date",
                value = "2021-05-27",
                example = "2021-05-28",
                required = true,
                defaultValue = "1")
        @PathVariable Date dateTo
    ) {
        return ResponseEntity.ok(nbpService.getAveragePrice(dateFrom,dateTo));
    }
}
