package studentdb.model;

import java.sql.ResultSet;

public interface DAOService {

	void connectDB();

	boolean verfiyCredentials(String email, String password);

	void saveRegistration(String name, String fathername, String mothername, String gender, String email, String mobile,
			String course);

	ResultSet getAllReg();

	void deleteReg(String name, String email, String mobile);

	void updateReg(String name, String email, String mobile);

}
