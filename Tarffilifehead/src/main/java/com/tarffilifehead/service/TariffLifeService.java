package com.tarffilifehead.service;

import java.util.List;

import com.tarffilifehead.model.TariffLife;

public interface TariffLifeService {

	TariffLife saveTariffLife(TariffLife product);

	List<TariffLife> getTariffLife();

	TariffLife getTariffLifeByMtmMapCode(String mtmMapCode);

	String deleteTariffLife(String mtmMapCode);

}
