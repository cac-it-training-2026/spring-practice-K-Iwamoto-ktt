package jp.co.sss.practice.p06.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {

	@Autowired
	FruitsAreaRepository fruitRepository;

	@Autowired
	AreaRepository areaRepository;

	@RequestMapping(path = "/fruits/select/area", method = RequestMethod.GET)
	public String showArea(Model model) {

		model.addAttribute("area", areaRepository.findAllByOrderByAreaIdAsc());
		return "practice06/02/area_select";
	}

	@RequestMapping(path = "/fruits/select/area/result", method = RequestMethod.GET)
	public String showResult(Integer areaId, Model model) {

		Area area = areaRepository.getReferenceById(areaId);
		model.addAttribute("areaName", area.getAreaName());

		model.addAttribute("fruits", fruitRepository.findByAreaOrderByFruitIdAsc(area));

		return "practice06/02/fruits_list";

	}

}
