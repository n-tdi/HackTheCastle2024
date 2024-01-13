package world.ntdi.hackthejava.services;

public interface PredictionModelService {

    int predictCost(final String insurance, final String description);
}
