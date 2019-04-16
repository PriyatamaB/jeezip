package com.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test")
public class TestController {
	@GetMapping("/uri/{name}/{age}/{joinDate}")
	public String testPathVars(RedirectAttributes flashMap, @PathVariable String name, @PathVariable int age,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date joinDate) {
		flashMap.addFlashAttribute("nm", name);
		flashMap.addFlashAttribute("age", age);
		flashMap.addFlashAttribute("dt", joinDate);
		return "redirect:/test/display";
	}

	@GetMapping("/display")
	public String forwardToView() {
		System.out.println("in forward to view");
		return "/test/display";
	}

	@GetMapping("/resp1")
	public @ResponseBody String testResp1() {
		System.out.println("in forward to view");
		return "Skipping View Layer!!!!";
	}

	@GetMapping("/resp2")
	public @ResponseBody List<Integer> testResp2() {
		System.out.println("in forward to view");
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}

}
