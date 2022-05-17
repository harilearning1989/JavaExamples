package com.local;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class LocaleExamples {

	public static void main(String args[]) {
		//getLanguages();
		//getCountries();

		//getCountryAndLanguage();
		//getListOfCountries();

		final String [] languages ={"eng", "deu", "jpn", "fra", "spa", "pol", "ita", "rus",
				"ces", "zho", "nld", "por", "swe", "hrv", "hin", "hun", "vie", "ara", "tur"};
		// Java Locale uses ISO 639-2 rather than 639-3 so we currently only support the subset of
		// the languages on Glosbe which are in ISO 639-2. "Chinese Mandarin" ("cmn") for example
		// is not supported, but "Chinese" ("zho") is.
		for (String l : languages) {
			Locale locale = new Locale(l);
			System.out.println(locale.getDisplayLanguage()+"==="+locale.getISO3Language());
		}
		getCountryAndLanguage();
	}

	private static Map<String, String> languagesMap = new TreeMap<String, String>();

	public LocaleExamples() {
		initLanguageMap();
	}
	public void initLanguageMap() {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale obj : locales) {
			if ((obj.getDisplayCountry() != null) && (!"".equals(obj.getDisplayCountry()))) {
				languagesMap.put(obj.getCountry(), obj.getLanguage());
			}
		}
	}
	public static void getListOfCountries() {
		String[] countries = Locale.getISOCountries();
		int supportedLocale = 0, nonSupportedLocale = 0;
		for (String countryCode : countries) {
			Locale obj = null;
			if (languagesMap.get(countryCode) == null) {
				obj = new Locale("", countryCode);
				nonSupportedLocale++;
			} else {
				obj = new Locale(languagesMap.get(countryCode), countryCode);
				supportedLocale++;
			}
			System.out.println("Country Code = " + obj.getCountry() 
			+ ", Country Name = " + obj.getDisplayCountry(obj)
			+ ", Languages = " + obj.getDisplayLanguage());
		}
		System.out.println("nonSupportedLocale : " + nonSupportedLocale);
		System.out.println("supportedLocale : " + supportedLocale);
	}

	private static void getCountryAndLanguage() {
		Locale[] locales = Locale.getAvailableLocales();
		Map<String,HashSet<String>> countryLanguageMap = new HashMap<>();

		for (Locale locale : locales) {
			String country = locale.getDisplayCountry(), language = locale.getLanguage();
			if(!country.isEmpty() && !language.isEmpty()) {
				if(countryLanguageMap.containsKey(country))
					countryLanguageMap.get(country).add(language);
				else
					countryLanguageMap.put(country, new HashSet<String>(Arrays.asList(language)));
			}
		}
		countryLanguageMap.forEach((k,v) -> {
			System.out.println(k+"==="+v);
		});
	}

	private static void getCountries() {
		String [] countries = Locale.getISOCountries();

		System.out.println("Countries:\n"+countries.length);
		for (int i = 0; i < countries.length; i++) {
			//System.out.println(countries[i]);
		}
	}

	private static void getLanguages() {

		String[] languages = Locale.getISOLanguages();

		System.out.println("\nLanguages:\n");
		for (int i = 0; i < languages.length; i++) {
			System.out.println(languages[i]);
		}


		Locale currentLocale = Locale.getDefault();
		Locale locales[] = { Locale.TAIWAN, Locale.KOREA, Locale.ITALY, Locale.CANADA,
				Locale.CANADA_FRENCH };
		System.out.println("CURRENT LOCALE:");
		describeLocale(currentLocale);
		System.out.println("OTHER LOCALES:");
		for (int i = 0; i < locales.length; ++i)
			describeLocale(locales[i]);
	}

	static void describeLocale(Locale l) {
		System.out.println("Country: " + l.getDisplayCountry());
		System.out.println("Language: " + l.getDisplayLanguage());
		System.out.println();
	}

}
