package world.ntdi.hackthejava.services;

import org.springframework.web.client.RestTemplate;

public class PredictionModelServiceImpl implements PredictionModelService{
    @Override
    public int predictCost(String insurance, String description) {
        final String uri = "http://127.0.0.1:5000/api/predict?ins=" + insurance + "&desc=" + description; // default flask server

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        if (result == null) {
            throw new NullPointerException();
        }
        return Integer.parseInt(result);
    }
}
