package org.oil.manager.service;

import java.util.Optional;

import org.oil.manager.entity.WellBaseData;
import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<T> {
	@Autowired
	private WellBaseDataRepository wellBaseRepository;

	Optional<WellBaseData> fetchWell(int wellId) {
		Optional<WellBaseData> well = this.wellBaseRepository.find(wellId);
		if (!well.isPresent()) {
			throw new RuntimeException(
					this.buildExceptionMessageThatWellNotExist(wellId));
		}
		return well;
	}

	private String buildExceptionMessageThatWellNotExist(int wellId) {
		return "Well with wellId" + wellId + " don't exist.";
	}
}
