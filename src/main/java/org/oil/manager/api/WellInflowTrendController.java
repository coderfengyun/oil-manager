package org.oil.manager.api;

import java.util.LinkedList;
import java.util.List;

import org.oil.manager.entity.WellInflowTrend;
import org.oil.manager.model.WellInflowTrendModel;
import org.oil.manager.service.WellInflowTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{wellId}/inflowTrend")
public class WellInflowTrendController {
	@Autowired
	private WellInflowTrendService wellInflowTrendService;

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public boolean add(@PathVariable int wellId,
			@RequestParam double producedFluidVolume,
			@RequestParam double wellBotomFlowPressure) {
		System.out.println("enter WellInflowTrendService.add");
		return this.wellInflowTrendService.addAInflowTrend(wellId,
				producedFluidVolume, wellBotomFlowPressure);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<WellInflowTrendModel> queryAllByWellId(@PathVariable int wellId) {
		System.out.println("enter queryAllWellInflorTrendByWellid");
		return convert2(this.wellInflowTrendService.queryAllByWellId(wellId));
	}

	private List<WellInflowTrendModel> convert2(
			List<WellInflowTrend> queryAllByWellId) {
		List<WellInflowTrendModel> result = new LinkedList<WellInflowTrendModel>();
		for (WellInflowTrend item : queryAllByWellId) {
			result.add(WellInflowTrendModel.build(item.getId(),
					item.getProducedFluidVolume(),
					item.getWellBotomFlowPressure(), item.getWell().getId()));
		}
		return result;
	}
}
