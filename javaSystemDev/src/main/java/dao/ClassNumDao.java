package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import bean.Classnum;
import bean.School;

public class ClassNumDao extends Dao{
	public String get(String class_num,School school)throws Exception{
		ClassNum classNum=new ClassNum();
		Connection connection=getConnection();
		PreparedStatenment statement=null;
		try {
			statement=connection.prepareStatement("select * from class_num where class_num=? and school_cd=?");
			statement.setString(1,class_num);
			statement.setString(2,school.getCd());
			ResultSet rSet=statement.executeQuery();
			SchoolDao sDao=new SchoolDao();
			if (rSet.next()) {
				classNum.setClass_num(rSet.getString("class_num"));
				classNum.setSchool(sDao.get(rSet.getString("school_cd")));
				}
			else {
				classNum=null;
				}
			}
		catch (Exception e){
			throw e;
			}
		finally {
			if (statement !=null) {
				try {
					statement.close();
					}
				catch (SQLException sqle) {
					throw sqle;
					}
				}
			if (connection !=null){
				try {
					connection.close();
					}
				catch (SQLException sqle) {
					throw sqle;
					}
				}
			}
		return classNum;
	}
	public List<String>filter(School school)throws Exception{
		List<String>list=new Arraylist<>();
		Connecion connection=getConnection();
		PreparedStartement statement=null;
		try {
			statement=connection.prepareStatement("select class_num from class_num where school_cd=? order by class_num");
			statement.setString(1,school.getCd());
			Reseulset rSet=statement.executrQuery();
			while (rSet.next()) {
				list.add(rSet.getString("class_num"));
				}
			}
		catch (Exception e){
			throw e;
			}
		finally {
			if (statement !=null) {
				try {
					statement.close();
					}
				catch (SQLException sqle) {
					throw sqle;
					}
				}
			if (connection !=null){
				try {
					connection.close();
					}
				catch (SQLException sqle) {
					throw sqle;
					}
				}
			}
		return list;
	}
	}
	public boolean save(ClassNum classNum)throws Exception{
		
	}
	public boolean save(ClassNum classNum,string newClassNum)throws Exception{
	}
}