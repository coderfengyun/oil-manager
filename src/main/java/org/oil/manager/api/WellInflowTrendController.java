package org.oil.manager.api;

import java.util.List;

import org.oil.manager.entity.WellInflowTrend;
import org.oil.manager.service.WellInflowTrendService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{wellId}/inflowTrend")
public class WellInflowTrendController {
	private WellInflowTrendService wellInflowTrendService;

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public boolean add(@PathVariable int wellId,
			@RequestParam double producedFluidVolume,
			@RequestParam double wellBotomFlowPressure) {
		this.wellInflowTrendService.addAInflowTrend(wellId,
				producedFluidVolume, wellBotomFlowPressure);
		return true;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<WellInflowTrend> queryAllByWellId(@PathVariable int wellId) {
		return this.wellInflowTrendService.queryAllByWellId(wellId);
	}
}
