package mas.myitil.controller;

import mas.myitil.model.equipment.Asset;
import mas.myitil.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @PostMapping("/add")
    public void addAsset(@RequestBody Asset asset) throws Exception {

        assetService.addAsset(asset);
    }

    @GetMapping("/list")
    public List<Asset> findAllAssets() {
        return assetService.findAll();
    }


    @GetMapping("/delete/{id}")
    public void deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
    }
}
