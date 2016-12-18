package services;

import java.util.Vector;
import models.User;
import play.mvc.Http;
import play.api.mvc.Call;

public class SiteInfo{

	public String _title;
	public String _sub_title;
	public String _logo_img;
	public String _charset;
	public String _lang;
	public int _menu;
	public int _sub_menu;
	public Vector<String> _js_files = new Vector();
	public Vector<String> _css_files = new Vector();
 
 	// use controllers.routes.? is better
	//private String _public_url_prefix_path = controllers.routes.HomeController.index();

    public SiteInfo() {
		this._title = "Play Loginner";
		this._sub_title = "";
		this._logo_img =  "/assets/images/logo.jpg";
		this._charset = "utf-8";
		this._lang = "en";
		this._menu = 0;
		this._sub_menu = 2;

		String str;
		//String str = controllers.routes.Assets.versioned("javascripts/jquery-3.1.0.min.js").url; // ???
		str = "/assets/javascripts/jquery-3.1.0.min.js";
		this._js_files.add(str);
		//str = controllers.routes.Assets.versioned("semantic-ui/semantic.min.js").url;
		str = "/assets/semantic-ui/semantic.min.js";
		this._js_files.add(str);
		//str = controllers.routes.Assets.versioned("semantic-ui/semantic.min.css").url;
		str = "/assets/semantic-ui/semantic.min.css";
		this._css_files.add(str);
    }

	private String authToken(Http.Session session) {
	    return session.get("email");
	}
	
	public User getCurrentUser(Http.Session session) {
	    return User.getUserByEmail(authToken(session));
	
	}
}
