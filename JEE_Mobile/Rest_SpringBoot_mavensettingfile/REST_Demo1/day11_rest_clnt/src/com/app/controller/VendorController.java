package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.DataService;
import com.app.service.VendorService;

import pojos.Part;
import pojos.Vendor;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService service;

	@Autowired
	private DataService dataService;

	@GetMapping("/list")
	public String listAllVendors(Model map) {
		System.out.println("in list vendors " + map);
		map.addAttribute("vendor_list", service.listVendors());
		return "/vendor/list";
	}

	@GetMapping("/register")
	public String showRegForm(Vendor v, Model map) {
		System.out.println("in show reg form " + v);
		map.addAttribute("cities", dataService.getCities());
		map.addAttribute("amounts", dataService.getAmounts());
		return "/vendor/register";

	}

	@PostMapping("/register")
	public String processRegForm(@Valid Vendor v,BindingResult result, Model map, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + v +"\n res "+result);
		//chk for P.L errs
		if(result.hasFieldErrors())
		{
			System.out.println("p.l errs ");
			map.addAttribute("cities", dataService.getCities());
			map.addAttribute("amounts", dataService.getAmounts());
			return "/vendor/register";
		}
		flashMap.addFlashAttribute("status", service.registerVendor(v));
		return "redirect:/vendor/registered?vid="+v.getId();

	}
	@GetMapping("/registered")
	public String forwardToView() {
		System.out.println("in forward to view ");
		return "/vendor/registered";

	}

	@GetMapping("/add_part")
	public String showAddPartForm(@RequestParam int vid,Part p,HttpSession hs) {
		System.out.println("in add part form " + p+" "+vid);
		hs.setAttribute("vendor_id",vid);
		return "/vendor/add_part";

	}

	@PostMapping("/add_part")
	public String processAddPart(Part p, HttpSession hs, RedirectAttributes flashMap) {
		System.out.println("in process add part " + p);
		flashMap.addFlashAttribute("status", service.addPart((Integer) hs.getAttribute("vendor_id"), p));
		return "redirect:/vendor/list";

	}

	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int vid, Model map) {
		System.out.println("in show update form " + vid);
		// fetch vendor details by id
		Vendor v = service.getVendorDetails(vid);
		map.addAttribute("vendor", v);
		map.addAttribute("cities", dataService.getCities());
		map.addAttribute("amounts", dataService.getAmounts());
		return "/vendor/update";

	}

	@PostMapping("/update")
	public String processUpdateForm(Vendor v) {
		System.out.println("in process update form " + v);
		service.updateVendor(v);
		return "redirect:/vendor/list";

	}

}
