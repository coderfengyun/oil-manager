package org.oil.manager.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{wellId}/inflowTrend")
public class WellInflowTrendController {
	@RequestMapping("/add")
	@ResponseBody
	public boolean add(@RequestParam double producedFluidVolume,
			@RequestParam double wellBotomFlowPressure) {
		return true;
	}
}
