package Themas;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
@ManagedBean
public class ThemeSwitcherBean {
	private Map<String, String> themes;
	private List<Theme> advacedThemes;
	private String theme;
	@ManagedProperty(value="#{guestPreferences}")
	private GuestPreferences gp;
	public List<Theme> getAdvacedThemes() {
		return advacedThemes;
	}
	public GuestPreferences getGp() {
		return gp;
	}
	public String getTheme() {
		return theme;
	}
	public Map<String, String> getThemes() {
		return themes;
	}
	@PostConstruct
	public void init(){
		System.out.println("Init Theme");
		theme = gp.getTheme();
		advacedThemes = new ArrayList<Theme>();
		advacedThemes.add(new Theme("aristo"));
		advacedThemes.add(new Theme("cupertino"));
		advacedThemes.add(new Theme("trontastic"));
		themes = new TreeMap<String, String>();
		themes.put("Aristo", 	 	 "aristo");
		themes.put("Black-Tie",  	 "black-tie");
		themes.put("Blitzer", 	 	 "blitzer");
		themes.put("Bluesky", 	 	 "bluesky");
		themes.put("Casablanca", 	 "casablanca");
		themes.put("Cupertino",  	 "cupertino");
		themes.put("Dark-Hive",   	 "dark-hive");
		themes.put("Dot-Luv", 	  	 "dot-luv");
		themes.put("Eggplant", 	  	 "Eggplant");
		themes.put("Excite-Bike", 	 "excite-bike");
		themes.put("Flick", 	  	 "flick");
		themes.put("Glass-X", 	  	 "glass-x");
		themes.put("Hot-Speaks",  	 "hot-speaks");
		themes.put("Humanity",    	 "humanity");
		themes.put("Le-Frog", 	  	 "le-frog");
		themes.put("Midnight", 	  	 "midnight");
		themes.put("Mint-Choc",   	 "mint-choc");
		themes.put("Overcast", 	  	 "overcast");
		themes.put("Pepper-Grinder", "pepper-grinder");
		themes.put("Redmond", 	  	 "redmond");
		themes.put("Rocket",		 "rocket");
		themes.put("Smoothness", 	 "smoothness");
		themes.put("Sout-Stret",	 "sout-street");
		themes.put("Start",			 "start");
		themes.put("Sunny",			 "sunny");
		themes.put("Swanky-Purse",	 "swanky-purse");
		themes.put("Trontastic",	 "trontastic");
		themes.put("UI-Darkness",	 "ui-darkness");
		themes.put("UI-Lightness",	 "ui-lightness");
		themes.put("Vader",			 "vader");
	}
	public void saveTheme(){
		System.out.println("saveTheme");
		gp.setTheme(theme);
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public void setAdvacedThemes(List<Theme> advacedThemes) {
		this.advacedThemes = advacedThemes;
	}
	public void setGp(GuestPreferences gp) {
		this.gp = gp;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public void setThemes(Map<String, String> themes) {
		this.themes = themes;
	}
}