package com.sst.cryptomiddleware;
import java.util.*;

import org.springframework.context.annotation.Configuration;

import com.amazon.ion.*;
import com.amazon.ion.system.*;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.qldbsession.QldbSessionClient;
import software.amazon.qldb.*;



public final class TransactionHandler {
    public static IonSystem ionSys = IonSystemBuilder.standard().build();
    public static QldbDriver qldbDriver;

    public static void setUp() {
        System.out.println("Initializing the driver");
        qldbDriver = QldbDriver.builder()
            .ledger("sst-general-ledger")
            .transactionRetryPolicy(RetryPolicy
                .builder()
                .maxRetries(3)
                .build())
            .sessionClientBuilder(QldbSessionClient.builder().region(Region.US_EAST_1))
            .build();
    }
}