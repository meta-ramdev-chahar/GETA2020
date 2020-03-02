package com.metacube.parkingSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.parkingSystem.models.VehicleModel;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.service.impl.VehicleService;

@SuppressWarnings("unused")
@Controller
public class VehController {
	
	private int k;

	public void send(int j)
	{
		k = j;
	}

	@Autowired
	private VehicleService vehservice;

	@GetMapping("/vehicleRegister")
	public String vehicleRegister(Model model,HttpServletRequest req) 
	{
		int p = HomeController.j;
		VehicleModel	vehCommands  =  new VehicleModel();vehCommands.setVid(p);
		model.addAttribute("veh",vehCommands);
		String empname = req.getParameter("empname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String conno = req.getParameter("conno");
		String org = req.getParameter("organization");
		model.addAttribute("empname",empname);
		model.addAttribute("email",email);
		model.addAttribute("password",password);
		model.addAttribute("conno",conno);
		model.addAttribute("organization",org);
		
		return "veh";
	}

	@PostMapping("/vehicleRegister")
	public ModelAndView doVehicleRegister(@Validated @ModelAttribute("veh") VehicleModel vehicle, BindingResult bindingResult,HttpServletRequest req) 
	{

		ModelAndView mv = new ModelAndView();

		if (bindingResult.hasErrors())
		{
			mv.setViewName("veh");
			return mv;
		} 
		else
		{

			if(vehicle.getVehtype().equals("cycle"))
			{
				mv.setViewName("price");
				return mv;
			}
			else if(vehicle.getVehtype().equals("bike"))
			{
				mv.setViewName("price2");
				return mv;
			}
			else
				mv.setViewName("redirect:/signup");
			return mv;

		}
	}

}
