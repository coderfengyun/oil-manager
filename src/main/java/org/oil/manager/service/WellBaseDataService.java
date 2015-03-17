package org.oil.manager.service;

import java.util.LinkedList;
import java.util.List;

import org.oil.manager.entity.WellBaseData;
import org.oil.manager.model.WellBaseDataModel;
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

	public List<WellBaseDataModel> queryAllWellBaseData() {
		return convert2(this.wellBaseDataReposity.findAll());
	}

	private List<WellBaseDataModel> convert2(List<WellBaseData> findAll) {
		List<WellBaseDataModel> result = new LinkedList<WellBaseDataModel>();
		for (WellBaseData item : findAll) {
			result.add(WellBaseDataModel.build(item.getId(),
					item.getWellDepth(), item.getCasingOutterDiameter(),
					item.getCasingInnerDiameter(),
					item.getReservoirTemperature(),
					item.getTubingOutterDiameter(),
					item.getTubingInnerDiameter()));
		}
		return result;
	}

}
