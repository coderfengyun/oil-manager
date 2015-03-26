package org.oil.manager.api;

import java.util.LinkedList;
import java.util.List;

import org.oil.manager.entity.WellPressureDistribution;
import org.oil.manager.model.WellPressureDistributionModel;
import org.oil.manager.service.WellPressureDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{wellId}/pressureDistribution")
public class WellPressureDistributionController {
	@Autowired
	private WellPressureDistributionService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<WellPressureDistributionModel> queryAll(@PathVariable int wellId) {
		return convert2(this.service.findAllByWellId(wellId));
	}

	private List<WellPressureDistributionModel> convert2(
			List<WellPressureDistribution> findAllByWellId) {
		List<WellPressureDistributionModel> result = new LinkedList<WellPressureDistributionModel>();
		for (WellPressureDistribution item : findAllByWellId) {
			result.add(WellPressureDistributionModel.build(item.getPumpDepth(),
					item.getSinkingPressure(), item.getFulfillCoefficient(),
					item.getWell().getId()));
		}
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public boolean add(@PathVariable int wellId,
			@RequestParam double pumpDepth,
			@RequestParam double sinkingPressure,
			@RequestParam double fulfillCoefficient) {
		return this.service.add(pumpDepth, sinkingPressure, fulfillCoefficient,
				wellId);
	}
}
