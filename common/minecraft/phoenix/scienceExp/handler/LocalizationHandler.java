package minecraft.phoenix.scienceExp.handler;

import minecraft.phoenix.scienceExp.helper.LocalizationHelper;
import minecraft.phoenix.scienceExp.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */

public class LocalizationHandler {
	
	/**
	 * Adds language files to language file lib class
	 */
	public static void loadLanguages(){
		for(String LocationFile: Localizations.localeFiles){
			LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocaleFromFileName(LocationFile), LocalizationHelper.isXMLLanguageFile(LocationFile));
		}
	}
}