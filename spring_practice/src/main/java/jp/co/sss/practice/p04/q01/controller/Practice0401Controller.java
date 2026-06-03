package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {

	@RequestMapping(path = "/bmi/input", method = RequestMethod.GET)
	public String input() {
		System.out.println("inputが実行されました。");
		return "practice04/01/bmi_input";
	}

	@RequestMapping(path = "/bmi/result", method = RequestMethod.POST)
	public String result(BmiForm bmiform, Model model) {

		System.out.println("resultが実行されました。");

		model.addAttribute("name", bmiform.getName());
		model.addAttribute("height", bmiform.getHeight());
		model.addAttribute("weight", bmiform.getWeight());

		Double bmi = bmiform.getWeight() / ((bmiform.getHeight() / 100) * (bmiform.getHeight() / 100));
		bmiform.setBmi(bmi);
		model.addAttribute("bmi", bmiform.getBmi());

		return "practice04/01/bmi_result";
	}

}
