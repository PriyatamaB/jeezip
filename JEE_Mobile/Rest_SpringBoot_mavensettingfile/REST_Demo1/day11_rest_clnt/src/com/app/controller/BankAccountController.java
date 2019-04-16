package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pojos.BankAccount;

@Controller
@RequestMapping("/bank")
public class BankAccountController {
	@Value("#{abc.REST_GET_URL}")
	private String getURL;
	@Value("#{abc.REST_POST_URL}")
	private String postURL;

	@GetMapping("/summary")
	public String showSummaryForm() {
		System.out.println("show summary form");
		return "/bank/summary";
	}

	@PostMapping("/summary")
	public String processSummaryForm(@RequestParam int id, @RequestParam int pin, RestTemplate template,
			RedirectAttributes flashMap) {
		System.out.println("in process summary form " + getURL);
		try {
			// Invoke REST API to fetch a/c summary from Net Banking server.
			BankAccount a = template.getForObject(getURL, BankAccount.class, id, pin);
			flashMap.addFlashAttribute("status", "A/C Summary " + a);
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", e.getMessage());
		}
		return "redirect:/vendor/list";
	}

	@GetMapping("/create")
	public String showCreateAcForm(BankAccount a) {
		System.out.println("show create ac form " + a);
		return "/bank/create";
	}

	@PostMapping("/create")
	public String processCreateForm(BankAccount a, RestTemplate template, RedirectAttributes flashMap) {
		System.out.println("in process create a/c  form " + postURL + " " + a);
		try {
			// Invoke REST API to create new a/c1
			String sts = template.postForObject(postURL, a, String.class);
			flashMap.addFlashAttribute("status", sts);
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", e.getMessage());
		}
		return "redirect:/vendor/list";
	}

}
