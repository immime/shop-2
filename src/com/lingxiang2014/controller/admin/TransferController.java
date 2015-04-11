package com.lingxiang2014.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lingxiang2014.Pageable;
import com.lingxiang2014.controller.shop.BaseController;
import com.lingxiang2014.entity.Member;
import com.lingxiang2014.entity.Transfer.Method;
import com.lingxiang2014.service.BankService;
import com.lingxiang2014.service.MemberService;
import com.lingxiang2014.service.SnService;
import com.lingxiang2014.service.TransferService;

@Controller("adminMemberTransferController")
@RequestMapping("/admin/transfer")
public class TransferController extends BaseController {

	private static final int PAGE_SIZE = 10;

	@Resource(name = "memberServiceImpl")
	private MemberService memberService;
	@Resource(name = "transferServiceImpl")
	private TransferService transferService;
	@Resource(name = "bankServiceImpl")
	private BankService bankService;
	@Resource(name = "snServiceImpl")
	private SnService snService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Integer pageNumber, ModelMap model) {
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("page", transferService.findPage(null, null,Method.transform, pageable));
		return "admin/transfer/list";
	}

	@RequestMapping(value = "/list1", method = RequestMethod.GET)
	public String list1(Integer pageNumber, ModelMap model) {
		Member member = memberService.getCurrent();
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("page", transferService.findPage(member, member,Method.exchange, pageable));
		return "admin/transfer/list1";
	}
}