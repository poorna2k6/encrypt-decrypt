package com.matilda.encryptdecrypt.controller;

import com.matilda.encryptdecrypt.service.EncryptDecryptPwd;
import com.matilda.encryptdecrypt.model.EncryptDecryptRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@Api(value = "Encryptor", description = "Encode and Decode a String")
public class EncryptDecryptController {

    @Autowired
    EncryptDecryptPwd encryptDecryptPwd;

    @ApiOperation(value = "Return Encrypted Key")
    @GetMapping("/encrypt")
    @ResponseStatus(HttpStatus.OK)
    public String getEncrypted(EncryptDecryptRequest request) {
        return encryptDecryptPwd.encryptKey(request.getStringValue(),request.getKey());
    }

    @ApiOperation(value = "Return Decrypted Key")
    @PostMapping("/decrypt")
    @ResponseStatus(HttpStatus.OK)
    public String getDecrypted(EncryptDecryptRequest request) {
        return encryptDecryptPwd.decryptKey(request.getStringValue(),request.getKey());
    }

}