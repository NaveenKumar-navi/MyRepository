package com.tarffilifehead.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tarffilifehead.model.TariffLife;
import com.tarffilifehead.repository.TariffLifeRepository;
import com.tarffilifehead.service.TariffLifeService;

public class TariffLifeServiceImpl implements TariffLifeService{
	@Autowired
    private TariffLifeRepository repository;
	
    public TariffLife saveTariffLife(TariffLife product){
        return repository.save(product);
    }
    public List<TariffLife> saveTariffLifes(List<TariffLife> products){
        return (List<TariffLife>) repository.saveAll(products);
    }
    public List<TariffLife> getTariffLifes(){
        return  (List<TariffLife>) repository.findAll();
    }
    public TariffLife getTariffLifeByMtmMapCode(String mthMapCode){
        return repository.findByMtmMapCode(mthMapCode);
    }
    public String deleteTariffLife(String mthMapCode){
        repository.deleteById(mthMapCode);
        return "Deleted!";
    }
    public TariffLife updateTariffLife(TariffLife product){
    	TariffLife existingProduct= repository.findByMtmMapCode((String) product.getMtmMapCode());
        existingProduct.setMtmCode((String)product.getMtmCode());
        existingProduct.setMtmDesc((String)product.getMtmDesc());
        existingProduct.setMtmMapFm((String)product.getMtmMapFm());
        existingProduct.setMtmMapTo((String)product.getMtmMapTo());
        existingProduct.setMtmMapName((String)product.getMtmMapName());
        existingProduct.setPsaf_code((String)product.getPsaf_code());
        existingProduct.setPsaf_lvl((String)product.getPsaf_lvl());
        existingProduct.setPsaf_type((String)product.getPsaf_type());
        existingProduct.setPsaf_dflt_yn((String)product.getPsaf_dflt_yn());
        existingProduct.setPsaf_long_desc((String)product.getPsaf_long_desc());
        existingProduct.setPsaf_long_desc_bl((String)product.getPsaf_long_desc_bl());
        existingProduct.setPsaf_value((String)product.getPsaf_value());
        existingProduct.setPsaf_eff_fm_dt((Date)product.getPsaf_eff_to_dt());
        existingProduct.setPsaf_eff_to_dt((Date)product.getPsaf_eff_fm_dt());
        existingProduct.setPsaf_round_off((Long) product.getPsaf_round_off());

        return repository.save(existingProduct);
    }
	@Override
	public List<TariffLife> getTariffLife() {
		 return  (List<TariffLife>) repository.findAll();
	}

}