

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class SqlTest {
	// �������ؼ���
	private List<String> list;
	// ִ��Ϊlist��ֵ
    public void connect() {
		ResultSet rs = null;
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.56.116.251:3306/cpx";
        String user = "cpxdev";
        String password = "jwsoho3102";

        try {
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url, user, password);

            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();

            con.setAutoCommit(false);

            //Ҫִ�е�SQL���
            String sql = "SELECT * FROM material WHERE shopId = 2017";

            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs1 = statement.executeQuery(sql);

            con.commit(); //�����ύ
            con.setAutoCommit(true); // ����jdbc�����Ĭ���ύ��ʽ

            list = new ArrayList<String>();

            while (rs1.next()) {
                list.add(rs1.getString(7));
            }

            if ((list != null) && (list.size() > 0)) {
                String[] arr = new String[list.size()];

                for (int i = 0; i < list.size(); i++) {
                    arr[i] = list.get(i);
                }

                //�������
               /* for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }*/
            }

            rs1.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }
	public List<String> getList(){
		return this.list;
	}
}

class  d{
	public static void main(String args[]){
		SqlTest sqlTest = new SqlTest();
		sqlTest.connect();
		List<String> result = sqlTest.getList();
		//�������
		System.out.println(result.get(0));
	}
}
