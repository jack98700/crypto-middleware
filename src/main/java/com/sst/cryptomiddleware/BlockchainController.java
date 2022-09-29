package com.sst.cryptomiddleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlockchainController {

	@Autowired
	private BlockchainService blockchainService;
	
	 @RequestMapping("/ledger")
	    @ResponseBody
	  
	    @GetMapping
	    public String getGLLedger()
	    {
		 blockchainService.getBalance();
	        return "success";
	    }
	 
	   @RequestMapping("/transaction")
	   @PostMapping
	   @ResponseBody
	   public void submitTransaction(@RequestBody Transaction transaction) 
	   
	    {
		 blockchainService.submitTransaction(transaction);
	      
	    }
	
		
}
