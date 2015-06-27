package org.customerMgr.service;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class TestRunner {
	   public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(CustomerServiceImplTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	         //System.out.println(failure.getMessage());
	      }
	      	      
	        System.out.println(result.wasSuccessful());
	   }
	} 
