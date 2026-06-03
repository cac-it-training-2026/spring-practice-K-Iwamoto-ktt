package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {

	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/update", method = RequestMethod.GET)
	public String fruitUpdate(Model model) {

		model.addAttribute("fruits", repository.findAll());

		return "practice05/06/fruit_select";
	}

	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	public String updateComplete(Integer fruitId, Model model) {

		FruitsSeason fruitSeason = repository.getReferenceById(fruitId);
		FruitsSeasonBean fruitSeasonBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitSeason, fruitSeasonBean);
		model.addAttribute("fruit", fruitSeason);

		return "practice05/06/fruit_input";

	}

	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	public String showUpdate(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {

		FruitsSeason fruitSeason = repository.getReferenceById(fruitId);
		BeanUtils.copyProperties(fruitForm, fruitSeason, "fruitId");
		fruitSeason = repository.save(fruitSeason);

		FruitsSeasonBean fruitSeasonBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitSeason, fruitSeasonBean);
		model.addAttribute("fruit", fruitSeasonBean);

		return "practice05/06/fruit_detail";
	}

}
