package com.matilda.encryptdecrypt.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//spring annotation
@Configuration
public class JasyptConfig {

    //common method
    //used in classes - JasyptConfig.java and EncryptDecryptPwd.java
    public static SimpleStringPBEConfig getSimpleStringPBEConfig() {
        final SimpleStringPBEConfig pbeConfig = new SimpleStringPBEConfig();
        //can be picked via the environment variablee
        //TODO - hardcoding to be removed
       // pbeConfig.setPassword("javacodegeek");  //encryptor private key
        pbeConfig.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        pbeConfig.setKeyObtentionIterations("1000");
        pbeConfig.setPoolSize("1");
        pbeConfig.setProviderName(null);
        pbeConfig.setIvGenerator(null);
        pbeConfig.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        pbeConfig.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        pbeConfig.setStringOutputType("base64");

        return pbeConfig;
    }

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor encryptor() {
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(getSimpleStringPBEConfig());

        return pbeStringEncryptor;
    }
}
