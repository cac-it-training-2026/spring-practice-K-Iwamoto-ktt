package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {

	@RequestMapping(path = "/show/redirect_page")
	public String first() {
		System.out.println("firstが実行されました");
		return "practice02/02/redirect_link";
	}

	@RequestMapping(path = "/absolute")
	public String google() {
		System.out.println("googleが実行されました。");
		return "redirect:https://www.google.co.jp";
	}

	@RequestMapping(path = "/relative")
	public String redirect() {
		System.out.println("redirectが実行されました。");
		return "redirect:/result";
	}

	@RequestMapping(path = "/result")
	public String result() {
		System.out.println("resultが実行されました。");
		return "practice02/02/redirect_result";
	}

}
