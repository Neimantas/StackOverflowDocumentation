package service.impl;

import models.enums.Languages;
import service.ILanguageService;

public class LanguageServiceImpl implements ILanguageService {

	@Override
	public Languages setEnums(String langName) {
		// TODO Auto-generated method stub
		Languages tempLang = null;
		Languages lang;
		if(langName.toLowerCase().equals("java")) {
			lang = Languages.Java;
			return lang;
		}
		if(langName.toLowerCase().equals("csharp")) {
			lang = Languages.Csharp;
			return lang;
		}		
		if(langName.toLowerCase().equals("javascript")) {
			lang = Languages.JavaScript;
			return lang;
		}
		if(langName.toLowerCase().equals("swift")) {
			lang = Languages.Swift;
			return lang;
		}
		return tempLang;
	}

}
