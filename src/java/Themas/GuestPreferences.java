package Themas;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theme = "start";
	public String getTheme() {
		System.out.println("getTheme:" +theme);
		//theme = new String();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if( params.containsKey(theme) ){
			theme = params.get(theme);
		}/*
		try {
			ThemeSwitcherBean ts = new ThemeSwitcherBean();
			ts.saveTheme();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}*/
		return theme;
	}
	public void setTheme(String theme) {
		System.out.println("setTheme:" +theme);
		this.theme = theme;
	}
}