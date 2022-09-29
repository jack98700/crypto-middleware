package com.sst.cryptomiddleware;

import java.io.Console;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import software.amazon.qldb.QldbDriver;
import software.amazon.qldb.RetryPolicy;

import com.amazon.ion.IonStruct;
import com.amazon.ion.IonSystem;
import com.amazon.ion.IonValue;
import com.amazon.ion.Timestamp;
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
		    
		    Result result = txn.execute("SELECT * FROM Person WHERE LastName = ?",
		    		TransactionHandler.ionSys.newString("Logan"));
		    IonStruct person = (IonStruct) result.iterator().next();
		    System.out.println(person.get("FirstName")); // prints John
		    System.out.println(person.get("LastName")); // prints Doe
		    System.out.println(person.get("DOB")); // prints 32
		});
		
	}
	
	public void submitTransaction(Transaction transaction){
		TransactionHandler.// Insert a document
		qldbDriver.execute(txn -> {
			 System.out.println("Inserting a transaction");
			    IonStruct transactions = TransactionHandler.ionSys.newEmptyStruct();
			    transactions.put("transaction_id").newString(transaction.getTransactionId());
			    Instant instant = transaction.getTransactionDate().toInstant(ZoneOffset.UTC);
			    Date date = Date.from(instant);
			    transactions.put("transaction_date").newTimestamp(Timestamp.forDateZ(date));
			    transactions.put("description").newString(transaction.getDescription());
			   
			    txn.execute("INSERT INTO transactions ?", transactions);
			    
			    IonStruct ledger_entries = TransactionHandler.ionSys.newEmptyStruct();
			    ledger_entries.put("transaction_id").newString(transaction.getTransactionId());
			    ledger_entries.put("account_number").newString(transaction.getAccountNumber());
			    ledger_entries.put("blockchain").newString(transaction.getBlockchain().toString());
			    ledger_entries.put("transaction_type").newString(transaction.getTransactionType().toString());
			    ledger_entries.put("curreny_type").newString(transaction.getCurrencyType() != null ? transaction.getCurrencyType().toString() : null);
			    ledger_entries.put("amount").newDecimal(transaction.getAmount());
			    ledger_entries.put("asset_id").newString(transaction.getAssetId());
			    ledger_entries.put("asset_uri").newString(transaction.getAssetUri());
			  
			   
			    txn.execute("INSERT INTO ledger_entries ?", ledger_entries);
		});
		
	}
	
	
}
