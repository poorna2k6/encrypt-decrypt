package com.matilda.encryptdecrypt.service;

import com.matilda.encryptdecrypt.config.JasyptConfig;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.stereotype.Component;

@Component
public class EncryptDecryptPwd {

    //encrypt the plan text
    public  String encryptKey(final String plainKey,String password) {
        final SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        pbeConfig.setPassword(password);
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);

        System.out.println("Encrypted key = "+ pbeStringEncryptor.encrypt(plainKey));
        return pbeStringEncryptor.encrypt(plainKey);
    }


    //decrypt the encrypted text
	public static String decryptKey(final String encryptedKey,String password) {
    	final SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        pbeConfig.setPassword(password);
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);

        System.out.println("Decrypted key = "+ pbeStringEncryptor.decrypt(encryptedKey));
        return pbeStringEncryptor.decrypt(encryptedKey);
    }
}
