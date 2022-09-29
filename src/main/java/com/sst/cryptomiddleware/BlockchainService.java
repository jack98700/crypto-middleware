package com.sst.cryptomiddleware;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import software.amazon.qldb.QldbDriver;
import software.amazon.qldb.RetryPolicy;

import com.amazon.ion.IonStruct;
import com.amazon.ion.IonSystem;
import com.amazon.ion.IonValue;
import com.amazon.ion.system.IonSystemBuilder;

import software.amazon.awssdk.services.qldbsession.QldbSessionClient;
import software.amazon.qldb.Result;

@Service
public class BlockchainService {
	
	//@Autowired
	// private TransactionHandler transactionHandler;
	
	
	 
	public void getBalance(){
		TransactionHandler.qldbDriver.execute(txn -> {
		    System.out.println("Querying the table");
		    
		    Result result = txn.execute("SELECT * FROM People WHERE lastName = ?",
		    		TransactionHandler.ionSys.newString("Doe"));
		    IonStruct person = (IonStruct) result.iterator().next();
		    System.out.println(person.get("firstName")); // prints John
		    System.out.println(person.get("lastName")); // prints Doe
		    System.out.println(person.get("age")); // prints 32
		});
		
	}
	
}
