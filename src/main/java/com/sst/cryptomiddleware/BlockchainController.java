package com.sst.cryptomiddleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
