package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	public String start(HttpSession session) {

		System.out.println("startが実行されました。");

		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		session.setAttribute("number", hitNumber);
		System.out.println("当たりの数字は" + hitNumber);

		return "practice04/02/numguess_start";
	}

	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	public String input() {

		System.out.println("inputが実行されました。");

		return "practice04/02/numguess_input";
	}

	@RequestMapping(path = "/numguess/judge", method = RequestMethod.GET)
	public String judge(HttpSession session, Integer inputNum) {

		System.out.println("judgeが実行されました。");

		if (((Integer) session.getAttribute("number")).equals(inputNum)) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}

	@RequestMapping(path = "/numguess/hit", method = RequestMethod.GET)
	public String hit(Model model, HttpSession session) {

		System.out.println("hitが実行されました。");

		String message = "当たりです！正解は" + (Integer) session.getAttribute("number") + "でした。";
		model.addAttribute("message", message);
		session.invalidate();

		return "practice04/02/numguess_end";
	}

}
