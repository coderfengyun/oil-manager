package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.WellProductData;
import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellBaseDataService {
	@Autowired
	private WellBaseDataRepository wellBaseDataReposity;

	public boolean addAWellBaseData(double wellDepth,
			double casingOutterDiameter, double casingInnerDiameter,
			double reservoirTemperature, double tubingOutterDiameter,
			double tubingInnerDiameter) {
		this.wellBaseDataReposity.attach(WellBaseData
				.buildWithoutId(wellDepth, casingOutterDiameter,
						casingInnerDiameter, reservoirTemperature,
						tubingOutterDiameter, tubingInnerDiameter));
		return true;
	}

	public List<WellBaseData> queryAllWellBaseData() {
		return this.wellBaseDataReposity.findAll();
	}

	public boolean updateProductData(int wellId, String pumpingMachineType,
			double producingOilRate, double production, double pumpDiameter,
			double stroke, int bluntTimes, double wellHeadCasingPressure,
			double pumpDepth, double volumetricMoistureContent,
			double workingFluidLevel, double sternTubeLength) {
		WellBaseData well = this.wellBaseDataReposity.find(wellId);
		well.setWellProductData(WellProductData.buildWithoutId(
				pumpingMachineType, producingOilRate, production, pumpDiameter,
				stroke, bluntTimes, wellHeadCasingPressure, pumpDepth,
				volumetricMoistureContent, workingFluidLevel, sternTubeLength));
		this.wellBaseDataReposity.update(well);
		return true;
	}

	// private List<WellBaseDataModel> convert2(List<WellBaseData> findAll) {
	// List<WellBaseDataModel> result = new LinkedList<WellBaseDataModel>();
	// for (WellBaseData item : findAll) {
	// result.add(WellBaseDataModel.build(item.getId(),
	// item.getWellDepth(), item.getCasingOutterDiameter(),
	// item.getCasingInnerDiameter(),
	// item.getReservoirTemperature(),
	// item.getTubingOutterDiameter(),
	// item.getTubingInnerDiameter()));
	// }
	// return result;
	// }

}
