package database_console;
import java util *;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RequestURLPull{
	
	public String api_key = "";
	private static final String dbHost = "iproxy.use01.plat.priv:10201";
	private static String database = "attribution_shared";
	private static final String dbUser = "";
	private static final String dbPassword = "";
	public String click_id = "";
	public String install_id = "";
	public String open_id = "";
	public String event_id = "";
	public String postback_id = "";

	public String returnRequestURL(String type_of_id, String id){
		String value = type_of_id.toLowerCase();
		if(value.contains("click")){
			click_id = id;
			return click_id;
		}
		else if(value.contains("install")){
			install_id = id;
			return install_id;
		}
		else if(value.contains("open")){
			open_id = id;
			return open_id;
		}
		else if(value.contains("event")){
			event_id = id;
			return event_id;
		}
		else if(value.contains("postback")){
			postback_id = id;
			return postback_id;
		}
		else
			System.out.println("Please input a click id, install id, open id, event id or postback id.");
		return;
	}

	public static String viewTable(String username, String password) throws SQLException {
		Statement stmt = null;
    	String query = "SELECT api_key FROM user_interface_api_keys WHERE advertiser_id = " + advertiser_id + " AND statis = 'actitve' LIMIT 1;";    		
		String url = "iproxy.use01.plat.priv:10201";
		String un = username;
		String pw = password;
		System.out.println("Connecting database...");
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			System.out.println("Database connected!");
			ResultSet rs = stmt.executeQuery(query);
			api_key = rs.getString("api_key");
		}
		catch (SQLException e){
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		finally{
			if(stmt != null)
				stmt.close();
		}

		return api_key;
	}

/*site.name%2Cpublisher.name&filter_cthulhu=%5B%5D&session_token=8786b6842c27d4f289a6b8074b6210d011aca27e&
start_date=2016-05-26T00%3A00%3A00.000&end_date=2016-05-26T23%3A59%3A59.999&
response_format=json&limit=1001&sorts=created%20desc&api_key=a9402b339436fa7df70e0515d1c49b74*/



/*String request = "https://api.mobileapptracking.com/v3/logs/advertisers/" 
+ advertiser_id 
+ "/opens?fields=request_url%2Ccreated" 
+ filters[i]+"&filter_cthulu=5B%5D&sesstion_token=" 
+ sessiontoken + "&start_date=" + start_date + "&end_date" + end_date
+ "&response_format=json&limit=1&sorts=created%20desc&api_key=" + api_key;*/












}	