package savefile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.shopping.util.ConnectionObject;

public class FileDao {
	
	public void saveFile(int id, String userName, String fileName, FileInputStream fileInputStream) {
		String sql="INSERT INTO documents VALUES(?,?,?,?)";
		
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fileName);
			preparedStatement.setBlob(4, fileInputStream);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public void getFile(String path, int id) {
		FileOutputStream fileOutputStream ;
		String sql="SELECT * FROM documents WHERE id =?";
		Connection connection = ConnectionObject.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int rid=resultSet.getInt(1);
				String name = resultSet.getString(2);
				String fileName= resultSet.getString(3);
				Blob blob = resultSet.getBlob(4);
				
				byte[] array = blob.getBytes(1, (int)blob.length());
				
				fileOutputStream = new FileOutputStream(path);
				fileOutputStream.write(array);
				System.out.println("downloaded successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch bloc

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
