package org.oil.manager.api;

import java.util.LinkedList;
import java.util.List;

import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.model.PreferredPlanModel;
import org.oil.manager.service.PreferredPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{wellId}/preferredPlan")
public class PreferredPlanController {
	@Autowired
	private PreferredPlanService service;

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public boolean add(@PathVariable int wellId,
			@RequestParam double econemicBenifits,
			@RequestParam double production,
			@RequestParam double pumpEffeciency,
			@RequestParam double systemEffeciency,
			@RequestParam double utilization) {
		return this.service.add(wellId, econemicBenifits, production,
				pumpEffeciency, systemEffeciency, utilization);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<PreferredPlanModel> queryAll(@PathVariable int wellId) {
		return convert2(this.service.findAllByWellId(wellId));
	}

	private List<PreferredPlanModel> convert2(
			List<PreferredPlan> findAllByWellId) {
		List<PreferredPlanModel> result = new LinkedList<PreferredPlanModel>();
		for (PreferredPlan item : findAllByWellId) {
			result.add(PreferredPlanModel.build(item.getId(),
					item.getEconemicBenifits(), item.getProduction(),
					item.getPumpEffeciency(), item.getSystemEffeciency(),
					item.getUtilization(), item.getWell().getId()));
		}
		return result;
	}
}
