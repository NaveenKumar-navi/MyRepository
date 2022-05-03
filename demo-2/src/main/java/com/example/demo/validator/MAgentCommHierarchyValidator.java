package com.example.demo.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.MAgentCommHierarchy;
import com.example.demo.bean.MAgentCommHierarchyList;
import com.example.demo.dto.MAgentCommHierarchyMultipleSaveDto;
import com.example.demo.dto.MAgentCommHierarchySubListDto;
import com.example.demo.handler.ObjectInvalidException;
import com.example.demo.repository.MAgentCommHierarchyRepository;
import com.example.demo.service.MAgentCommHierarchyService;
import com.example.demo.util.ValidationUtil;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })
public class MAgentCommHierarchyValidator {

	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;

	private @NonNull MAgentCommHierarchyService agentService;
	private @NonNull MAgentCommHierarchyRepository repo;

	public ValidationResult validate(MAgentCommHierarchy request) {

		errors = new ArrayList<>();
		MAgentCommHierarchy obj = null;

		if (ValidationUtil.isNull(request.getAcmSysId()))

		{
			Optional<MAgentCommHierarchy> optional = agentService
					.findByAcmAgentCodeAndAcmCompCodeAndAcmProdCodeAndAcmSchFmCode(request.getAcmAgentCode(),
							request.getAcmCompCode(), request.getAcmProdCode(), request.getAcmSchFmCode());

			if (optional.isPresent()) {
				throw new ObjectInvalidException("Already Exist ");
			}

		}

		else {

			Optional<MAgentCommHierarchy> lobOptional = repo.findById(request.getAcmSysId());

			obj = lobOptional.get();
		}

		ValidationResult result = new ValidationResult();
		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}

		if (null == obj) {

			obj = MAgentCommHierarchy.builder().acmCompCode(request.getAcmCompCode())
					.acmProdCode(request.getAcmProdCode()).acmSchFmCode(request.getAcmSchFmCode())
					.acmSchToCode(request.getAcmSchToCode()).acmAgentCode(request.getAcmAgentCode())
					.acmRmAgentCode(request.getAcmRmAgentCode()).acmLevel(request.getAcmLevel())
					.acmLevelDesc(request.getAcmLevelDesc()).acmPolTermFm(request.getAcmPolTermFm())
					.acmPolTermTo(request.getAcmPolTermTo()).acmPolYearFm(request.getAcmPolYearFm())
					.acmPolYearTo(request.getAcmPolYearTo()).acmCommRate(request.getAcmCommRate())
					.acmCommTargetRate(request.getAcmCommTargetRate()).acmEffFmDt(request.getAcmEffFmDt())
					.acmEffToDt(request.getAcmEffToDt()).acmStatus(request.getAcmStatus())
					.acmCommType(request.getAcmCommType()).build();

		} else {
			obj.setAcmSysId(request.getAcmSysId());
			obj.setAcmCompCode(request.getAcmCompCode());
			obj.setAcmProdCode(request.getAcmProdCode());
			obj.setAcmSchFmCode(request.getAcmSchFmCode());
			obj.setAcmSchToCode(request.getAcmSchToCode());
			obj.setAcmAgentCode(request.getAcmAgentCode());
			obj.setAcmRmAgentCode(request.getAcmRmAgentCode());
			obj.setAcmLevel(request.getAcmLevel());
			obj.setAcmLevelDesc(request.getAcmLevelDesc());
			obj.setAcmPolTermFm(request.getAcmPolTermFm());
			obj.setAcmPolTermTo(request.getAcmPolTermTo());
			obj.setAcmPolYearFm(request.getAcmPolYearFm());
			obj.setAcmPolYearTo(request.getAcmPolYearTo());
			obj.setAcmCommRate(request.getAcmCommRate());
			obj.setAcmCommTargetRate(request.getAcmCommTargetRate());
			obj.setAcmEffFmDt(request.getAcmEffFmDt());
			obj.setAcmEffToDt(request.getAcmEffToDt());
			obj.setAcmStatus(request.getAcmStatus());
			obj.setAcmCommType(request.getAcmCommType());

		}

		result.setObject(obj);
		return result;
	}
	
public ValidationResult validate(MAgentCommHierarchyMultipleSaveDto request) {
		
		errors = new ArrayList<>();

		MAgentCommHierarchyList list = new MAgentCommHierarchyList();


		if (ValidationUtil.isNull(request.getAcmCompCode())) {
			throw new ObjectInvalidException("Company code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmCompCode(), 12)) {
			errors.add("AcmCompCode length should be 12");
		} else {
			request.setAcmCompCode(request.getAcmCompCode());
		}

		if (ValidationUtil.isNull(request.getAcmProdCode())) {
			throw new ObjectInvalidException("Product code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmProdCode(), 12)) {
			errors.add("AcmProdCode should be 12");
		} else {
			request.setAcmProdCode(request.getAcmProdCode());
		}

		if (ValidationUtil.isNull(request.getAcmSchFmCode())) {
			throw new ObjectInvalidException("Scheme code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmSchFmCode(), 12)) {
			errors.add("AcmSchFmCode length should be 12");
		} else {
			request.setAcmSchFmCode(request.getAcmSchFmCode());
		}

		if (ValidationUtil.isNull(request.getAcmSchToCode())) {
			throw new ObjectInvalidException("Scheme to code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmSchToCode(), 12)) {
			errors.add("AcmSchToCode length should be 12");
		} else {
			request.setAcmSchToCode(request.getAcmSchToCode());
		}

		if (ValidationUtil.isNull(request.getAcmAgentCode())) {
			throw new ObjectInvalidException("Agent code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmAgentCode(), 12)) {
			errors.add("AcmAgentCode length should be 12");
		} else {
			request.setAcmAgentCode(request.getAcmAgentCode());
		}
		
		if (ValidationUtil.isNull(request.getAcmRmAgentCode())) {
			throw new ObjectInvalidException("Rm Agent code is required");
		} else if (ValidationUtil.isValidLength(request.getAcmRmAgentCode(), 12)) {
			errors.add("AcmRmAgentCode length should be 12");
		} else {
			request.setAcmRmAgentCode(request.getAcmRmAgentCode());
		}
		
		if (ValidationUtil.isNull(request.getAcmLevelDesc())) {
			throw new ObjectInvalidException("Acm Level Desc is required");
		} else if (ValidationUtil.isValidLength(request.getAcmLevelDesc(), 500)) {
			errors.add("AcmLevelDesc length should be 500");
		} else {
			request.setAcmLevelDesc(request.getAcmLevelDesc());
		}
		
		List<MAgentCommHierarchy> dataList = repo
				.findByAcmCompCodeAndAcmProdCodeAndAndAcmSchFmCodeAndAcmAgentCodeAndAcmRmAgentCodeAndAcmLevelAndAcmLevelDescAndAcmPolTermFmAndAcmPolTermTo(
					 request.getAcmCompCode(),request.getAcmProdCode(), request.getAcmSchFmCode(),request.getAcmAgentCode(),request.getAcmRmAgentCode(),request.getAcmLevel(),
						request.getAcmLevelDesc(),request.getAcmPolTermFm(), request.getAcmPolTermTo());

		if (request.getCheck() != null) {
			if (!dataList.isEmpty()) {
				throw new ObjectInvalidException("Already Exists");
			}
		}

		if (request.getAcmSubList() == null) {
			throw new ObjectInvalidException("No items in the Sublist");
		}

		List<MAgentCommHierarchy> validateList = validateList(request, errors);

		ValidationResult result = new ValidationResult();
		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}

		list.setMAgentCommHierarchyDto(validateList);

		result.setObject(list);
		result.setErrors(errors);
		return result;

	}

	private List<MAgentCommHierarchy> validateList(MAgentCommHierarchyMultipleSaveDto request, List<String> errors2) {
		List<MAgentCommHierarchy> list = new ArrayList<MAgentCommHierarchy>();

		for (MAgentCommHierarchySubListDto object : request.getAcmSubList()) {

			MAgentCommHierarchy obj = null;

			if (ValidationUtil.isValidLength(object.getAcmCommRate(), 999)) {
				errors.add("Acm CommRate length should be 999");
			} else {
				object.setAcmCommRate(object.getAcmCommRate());
			}

			if (ValidationUtil.isValidLength(object.getAcmCommTargetRate(), 999)) {
				errors.add("AcmCommTargetRate length should be 999");
			} else {
				object.setAcmCommTargetRate(object.getAcmCommTargetRate());
			}

			if (ValidationUtil.isGreaterThan(object.getAcmEffFmDt(), object.getAcmEffToDt())) {
				errors.add("Eff From date should be greater than Eff To date");
			}

			if (!ValidationUtil.isNull(object.getAcmSysId())) {
				Optional<MAgentCommHierarchy> applTerms = repo.findById(object.getAcmSysId());

				if (applTerms.isPresent()) {
					obj = applTerms.get();
				}
			}

			if (errors.size() > 0) {
				String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
				throw new ObjectInvalidException(errorMessage);
			}
			if (null == obj) {

				obj = MAgentCommHierarchy.builder().acmCompCode(request.getAcmCompCode())
						.acmProdCode(request.getAcmProdCode()).acmSchFmCode(request.getAcmSchFmCode())
						.acmSchToCode(request.getAcmSchToCode()).acmAgentCode(request.getAcmAgentCode())
						.acmRmAgentCode(request.getAcmRmAgentCode()).acmLevel(request.getAcmLevel())
						.acmLevelDesc(request.getAcmLevelDesc()).acmPolTermFm(request.getAcmPolTermFm())
						.acmPolTermTo(request.getAcmPolTermTo()).acmPolYearFm(object.getAcmPolYearFm())
						.acmPolYearTo(object.getAcmPolYearTo()).acmCommRate(object.getAcmCommRate())
						.acmCommTargetRate(object.getAcmCommTargetRate()).acmEffFmDt(object.getAcmEffFmDt())
						.acmEffToDt(object.getAcmEffToDt()).acmStatus("A").build();
				list.add(obj);

			} else {
				obj.setAcmSysId(object.getAcmSysId());
				obj.setAcmCompCode(request.getAcmCompCode());
				obj.setAcmProdCode(request.getAcmProdCode());
				obj.setAcmSchFmCode(request.getAcmSchFmCode());
				obj.setAcmSchToCode(request.getAcmSchToCode());
				obj.setAcmAgentCode(request.getAcmAgentCode());
				obj.setAcmRmAgentCode(request.getAcmRmAgentCode());
				obj.setAcmLevel(request.getAcmLevel());
				obj.setAcmLevelDesc(request.getAcmLevelDesc());
				obj.setAcmPolTermFm(request.getAcmPolTermFm());
				obj.setAcmPolTermTo(request.getAcmPolTermTo());
				obj.setAcmPolYearFm(object.getAcmPolYearFm());
				obj.setAcmPolYearTo(object.getAcmPolYearTo());
				obj.setAcmCommRate(object.getAcmCommRate());
				obj.setAcmCommTargetRate(object.getAcmCommTargetRate());
				obj.setAcmEffFmDt(object.getAcmEffFmDt());
				obj.setAcmEffToDt(object.getAcmEffToDt());
				obj.setAcmStatus(object.getAcmStatus());
				list.add(obj);
			}

		}
		return list;
	}

}
