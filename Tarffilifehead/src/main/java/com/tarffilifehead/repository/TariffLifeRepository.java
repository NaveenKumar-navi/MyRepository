package com.tarffilifehead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarffilifehead.model.TariffLife;

public interface TariffLifeRepository extends JpaRepository<TariffLife,String>{

	TariffLife findByMtmMapCode(String mthMapCode);

}
