package com.leocaloni.qrcode.generator.controller;

import com.leocaloni.qrcode.generator.dto.qrcode.QrCodeGenerateRequest;
import com.leocaloni.qrcode.generator.dto.qrcode.QrCodeGenerateResponse;
import com.leocaloni.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        try {
            QrCodeGenerateResponse response =  this.qrCodeGeneratorService.generateQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
