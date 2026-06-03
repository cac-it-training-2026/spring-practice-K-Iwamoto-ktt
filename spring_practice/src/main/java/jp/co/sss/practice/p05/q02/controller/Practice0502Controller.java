package jp.co.sss.practice.p05.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0502Controller {

	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/list/sort/season")
	public String getAllOrder(Model model) {

		model.addAttribute("fruits", repository.findAllByOrderBySeasonMonthAsc());

		return "practice05/02/fruits_list";
	}

}
