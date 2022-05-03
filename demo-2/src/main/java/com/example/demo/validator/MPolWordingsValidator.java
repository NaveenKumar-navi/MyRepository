        package com.example.demo.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.MPolWordings;
import com.example.demo.dto.MPolWordingsDto;
import com.example.demo.handler.ObjectInvalidException;
import com.example.demo.service.MPolWordingsService;
import com.example.demo.util.ValidationUtil;

import lombok.AllArgsConstructor;
import lombok.NonNull;


@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })
public class MPolWordingsValidator {

	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;

	private @NonNull MPolWordingsService Service;

	public ValidationResult validate(MPolWordingsDto request) {

		errors = new ArrayList<>();
		MPolWordings mProd = null;
		
		if(ValidationUtil.isNull(request.getPwSysId())) {
			throw new ObjectInvalidException("Sys Id required"); 
		}else {
			request.setPwSysId(request.getPwSysId());
		}
		
		if(ValidationUtil.isNull(request.getPwProductCode())) {
			throw new ObjectInvalidException("Product Code required"); 
		}else if(ValidationUtil.isValidLength(request.getPwProductCode(), 12)){
			throw new ObjectInvalidException("Product length should be 12");
		}else {
			request.setPwProductCode(request.getPwProductCode());
		}

		if (!ValidationUtil.isNull(request.getPwSysId())) {

			Optional<MPolWordings> optional = Service.findByPwSysId(request.getPwSysId());

			mProd = optional.get();

		}
		
	
		
		if(ValidationUtil.isValidLength(request.getPwWordingType(), 50)){
			errors.add("PwWordingType length should be 50");
		}else {
			request.setPwWordingType(request.getPwWordingType());
		}

		if(ValidationUtil.isValidLength(request.getPwPageName(), 50)){
			errors.add("PwPageName length should be 50");
		}else {
			request.setPwPageName(request.getPwPageName());
		}
		
		if(ValidationUtil.isValidLength(request.getPwPageOrder(), 10)){
			errors.add("PwPageOrder length should be 10");
		}else {
			request.setPwPageOrder(request.getPwPageOrder());
		}
		
		if(ValidationUtil.isValidLength(request.getPwPageLineNo(), 9999)){
			errors.add("PwPageLineNo length should be 9999");
		}else {
			request.setPwPageLineNo(request.getPwPageLineNo());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDisplayText1(), 4000)) {
			errors.add("PwDisplayText1 Max Length Should Be 4000");

		} else {
			request.setPwDisplayText1(request.getPwDisplayText1());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDisplayText2(), 4000)) {
			errors.add("PwDisplayText2 Max Length Should Be 4000");

		} else {
			request.setPwDisplayText2(request.getPwDisplayText2());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDisplayText3(), 4000)) {
			errors.add("PwDisplayText3 Max Length Should Be 4000");

		} else {
			request.setPwDisplayText3(request.getPwDisplayText3());
		}
		
		if(ValidationUtil.isValidLength(request.getPwAllignment(), 1)) {
			errors.add("Allignment Max Length Should be 1");
		}else {
			request.setPwAllignment(request.getPwAllignment());
		}

		if(ValidationUtil.isValidLength(request.getPwTextformat(), 1)) {
			errors.add("PwTextformat Max Length Should be 1");
		}else {
			request.setPwTextformat(request.getPwTextformat());
		}
		
		if(ValidationUtil.isValidLength(request.getPwFontsize(), 10)) {
			errors.add("PwFontsize Max Length Should be 10");
		}else {
			request.setPwFontsize(request.getPwFontsize());
		}
		
		if(ValidationUtil.isValidLength(request.getPwCoverCode(), 240)) {
			errors.add("PwCoverCode Max Length Should be 240");
		}else {
			request.setPwCoverCode(request.getPwCoverCode());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDynamicColumn1(), 2000)) {
			errors.add("PwDynamicColumn1 Max Length Should Be 2000");

		} else {
			request.setPwDynamicColumn1(request.getPwDynamicColumn1());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDynamicColumn2(), 2000)) {
			errors.add("PwDynamicColumn2 Max Length Should Be 2000");

		} else {
			request.setPwDynamicColumn2(request.getPwDynamicColumn2());
		}
		
		if (ValidationUtil.isValidLength(request.getPwDynamicColumn3(), 2000)) {
			errors.add("PwDynamicColumn3 Max Length Should Be 2000");

		} else {
			request.setPwDynamicColumn3(request.getPwDynamicColumn3());
		}

		ValidationResult result = new ValidationResult();
		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}

		if (null == mProd) {
			mProd = MPolWordings.builder().pwProductCode(request.getPwProductCode())
					.pwWordingType(request.getPwWordingType()).pwCoverCode(request.getPwCoverCode())
					.pwPageName(request.getPwPageName()).pwPageno(request.getPwPageno()).pwLvl(request.getPwLvl())
					.pwPageLineNo(request.getPwPageLineNo()).pwPageOrder(request.getPwPageOrder())
					.pwDisplayText1(request.getPwDisplayText1()).pwAllignment(request.getPwAllignment())
					.pwFontsize(request.getPwFontsize()).pwTextformat(request.getPwTextformat())
					.pwDisplayText2(request.getPwDisplayText2()).pwDisplayText3(request.getPwDisplayText3())
					.pwDynamicColumn1(request.getPwDynamicColumn1()).pwDynamicColumn2(request.getPwDynamicColumn2())
					.pwDynamicColumn3(request.getPwDynamicColumn3()).build();

		} else {

			mProd.setPwSysId(request.getPwSysId());
			mProd.setPwProductCode(request.getPwProductCode());
			mProd.setPwWordingType(request.getPwWordingType());
			mProd.setPwCoverCode(request.getPwCoverCode());
			mProd.setPwPageName(request.getPwPageName());
			mProd.setPwPageno(request.getPwPageno());
			mProd.setPwLvl(request.getPwLvl());
			mProd.setPwPageLineNo(request.getPwPageLineNo());
			mProd.setPwPageOrder(request.getPwPageOrder());
			mProd.setPwDisplayText1(request.getPwDisplayText1());
			mProd.setPwAllignment(request.getPwAllignment());
			mProd.setPwFontsize(request.getPwFontsize());
			mProd.setPwTextformat(request.getPwTextformat());
			mProd.setPwDisplayText2(request.getPwDisplayText2());
			mProd.setPwDisplayText3(request.getPwDisplayText3());
			mProd.setPwDynamicColumn1(request.getPwDynamicColumn1());
			mProd.setPwDynamicColumn2(request.getPwDynamicColumn2());
			mProd.setPwDynamicColumn3(request.getPwDynamicColumn3());

		}

		result.setObject(mProd);
		return result;

	}

}

