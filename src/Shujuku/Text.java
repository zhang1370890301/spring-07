package Shujuku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		//��ʽ jdbc:mysql://����ip���˿ں�/���ݿ���
	     String url="jdbc:mysql://192.168.80.140:3306/zhang?useUnicode=true&characterEncoding=utf8";
	     String user="root";
	     String password="123456";
	     Connection con=null;
	     PreparedStatement psmpt=null;
	     ResultSet rs=null;
			try {
				//ѡ��Ҫ���������ݿ������--�������������䣩
				Class.forName("com.mysql.jdbc.Driver");
				//�������� ����ip �˿ں� �û��� ����  //ѡ��Ҫ���������ݿ�
				 con = DriverManager.getConnection(url, user, password);
				//������ڣ�дsql��䣩
		          psmpt = con.prepareStatement("insert into student(name,b_id,garden) values(?,?,?)");
				
				//����sql��䲢�鿴���  �������ɾ�ģ��򷵻���Ӱ�������������ǲ�ѯ�����ص��ǲ�ѯ���
				//���е�ʱ��ע�� �������ɾ�������executeUpdate ����int  ����ǲ�ѯ�������executeQuery,����ResultSet
				//ע�����
		          psmpt.setString(1,"�ų�");
		          psmpt.setInt(2, 2);
		          psmpt.setInt(3, 0);
		          //ִ�����
				int i=psmpt.executeUpdate();
				System.out.println(i);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)
					rs.close();
					if(psmpt!=null)
						psmpt.close();
					if(con!=null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		
		
		
	}

}
