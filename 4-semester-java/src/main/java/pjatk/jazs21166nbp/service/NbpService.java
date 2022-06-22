package pjatk.jazs21166nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jazs21166nbp.advice.GlobalExceptionHandler;
import pjatk.jazs21166nbp.model.Nbp;
import pjatk.jazs21166nbp.repository.NbpRepository;

import java.util.Date;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate,
                      NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public Nbp getAveragePrice(Date dateFrom, Date dateTo)   {
        String url = "http://api.nbp.pl/api/cenyzlota/";
        Nbp metalEntity = restTemplate.getForEntity( url + dateFrom + "/" + dateTo, Nbp.class).getBody();
        return metalEntity;
    }

}
