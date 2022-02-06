package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.model.equipment.Asset;
import mas.myitil.model.equipment.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    public List<Asset> findAll() {

        return assetRepository.findAll();
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
        log.info("Asset with id: {} deleted from repository", id);
    }
}
