package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {

	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/search/input", method = RequestMethod.GET)
	public String seasonSelect() {
		return "practice05/04/fruits_select_season";
	}

	@RequestMapping(path = "/fruits/search/result", method = RequestMethod.GET)
	public String showResult(Integer season, Model model) {

		model.addAttribute("fruits", repository.findBySeasonMonthOrderByFruitIdAsc(season));

		String month;

		if (season == 13) {
			month = "通";
		} else {
			month = season.toString();
		}

		model.addAttribute("month", month + "月");

		return "practice05/04/fruits_list";
	}

}
