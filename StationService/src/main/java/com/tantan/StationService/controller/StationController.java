package com.tantan.StationService.controller;

import com.tantan.StationService.request.StationRequest;
import com.tantan.StationService.response.DataResponse;
import com.tantan.StationService.service.IStationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {
    //    @Autowired
//    private  final ProductClient productClient;
//    private static Logger log = LoggerFactory.getLogger(InventoryController.class);
//
//    public StationController(ProductClient productClient) {
//        this.productClient = productClient;
//    }
//
//    @GetMapping("/")
//    @CircuitBreaker(name = "productService",
//            fallbackMethod = "getCircuitBreak"
//    )
////    @Cacheable(value = "inventoryCaching")
//    public String getInventory()
//    {
//       String nameProduct =  productClient.getNameProduct();
//       log.info("id");
//       return "inventory" + nameProduct;
//    }
//
//    private String getCircuitBreak(Exception e)
//    {
//        return "Lỗi rồi bạn ơi. Bật lại sv hoặc cache dữ liệu cũ";
//    }
    @Autowired
    private IStationService iStationService;

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createNewStation(@RequestBody StationRequest stationRequest) {
        iStationService.createNewStation(stationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse(false, HttpStatus.OK.value(), "Insert successfully", null)
        );

    }
}
