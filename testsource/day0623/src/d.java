

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class SqlTest {
	// 创建返回集合
	private List<String> list;
	// 执行为list赋值
    public void connect() {
		ResultSet rs = null;
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.56.116.251:3306/cpx";
        String user = "cpxdev";
        String password = "jwsoho3102";

        try {
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);

            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();

            con.setAutoCommit(false);

            //要执行的SQL语句
            String sql = "SELECT * FROM material WHERE shopId = 2017";

            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs1 = statement.executeQuery(sql);

            con.commit(); //事务提交
            con.setAutoCommit(true); // 更改jdbc事务的默认提交方式

            list = new ArrayList<String>();

            while (rs1.next()) {
                list.add(rs1.getString(7));
            }

            if ((list != null) && (list.size() > 0)) {
                String[] arr = new String[list.size()];

                for (int i = 0; i < list.size(); i++) {
                    arr[i] = list.get(i);
                }

                //输出数组
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
            System.out.println("数据库数据成功获取！！");
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
		//输出集合
		System.out.println(result.get(0));
	}
}
