package test;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.*;

import cn.com.zhongway.eoms.ws.SNSheetServiceStub;


/**
 * 
 */

/**   
 * 
 * 类名称：test
 * 类描述：
 * 作 者：赵保恩
 * 日 期：Sep 9, 2014
 * @version
 */
public class Debug extends JFrame{
	public Debug(){
		JPanel panel = new JPanel();  
		final JTextArea intextArea = new JTextArea();  
		intextArea.setLineWrap(true);
		//当TextArea里的内容过长时生成滚动条  
		JButton button = new JButton("debug");
		final JTextArea ouTextArea = new JTextArea();
		ouTextArea.setLineWrap(true);
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				new Thread(new Runnable(){
					public void run() {
						try {
							String pos = intextArea.getText();
							System.out.println("pos:"+pos);
							SNSheetServiceStub stub = new SNSheetServiceStub();
							SNSheetServiceStub.PublicMethod s = new SNSheetServiceStub.PublicMethod();
							s.setRequestXML(pos);
							String res = stub.PublicMethod(s).getPublicMethodReturn();
							ouTextArea.setText(res);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		});

		panel.add(intextArea);  
		panel.add(button);
		panel.add(ouTextArea);
		intextArea.setBounds(1, 10, 500, 150);
		button.setBounds(1, 165, 100, 30);
		ouTextArea.setBounds(1, 200, 500, 150);
		panel.setBounds(0, 0, 600, 400);
		panel.setLayout(null);
		this.add(panel);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400); 
		this.setLayout(null);
		this.setVisible(true);  
	}

	public static void main(String[] args) throws RemoteException {
		//new Debug().setVisible(true);
		/*String login="{\"route\":{\"phone\":\"152451215\",\"time\":\"2012-12-20 12:01:11\",\"service_name\":\"doCheck\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"userId\":\"system\",\"user_password\":\"\"}}";
		String send="{\"route\":{\"phone\":\"152451215\",\"time\":\"2012-12-20 12:01:11\",\"service_name\":\"doSend\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"userId\":\"system\",\"pagetotal\":0,\"currentnum\":1,\"pagesize\":10}}";
		String postil="{\"route\":{\"phone\":\"152451215\",\"time\":\"2012-12-20 12:01:11\",\"service_name\":\"doPostil\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"order_code\":\"2013030102658535\",\"postil_content\":\"批注内容包含批注人、单位部门、过程描述\",\"postil_level\":\"\",\"postil_time\":\"\",\"eoms_user_id\":\"\",\"postil_noteInfo\":\"\"}}";
		String returN="{\"route\":{\"phone\":\"152451215\",\"time\":\"2014-12-20 12:01:11\",\"service_name\":\"doForward\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"order_code\":\"2013112502969258\",\"forward_content\":\"霸王硬测试\",\"forward_dept\":\"200508169999\",\"forward_time\":\"2014-12-12 12:23:12\",\"eoms_user_id\":\"system\",\"eoms_flow_id\":\"2015010111323276\",\"forward_noteInfo\":\"ceshi\"}}";
		String pos="{\"interfacemsg\":{\"postil_noteInfo\":\"纬度:34.245016,经度:108.916528(陕西省西安市碑林区高新路12号)\",\"postil_content\":\"批注测试\",\"order_code\":\"2014101004082178\",\"postil_level\":\"0\",\"postil_time\":\"2014-27-10 02:11:35\",\"eoms_user_id\":\"zsyw\"},\"route\":{\"phone\":\"zsyw\",\"time\":\"2014-27-10 02:11:35\",\"service_name\":\"doPostil\",\"msg_id\":67}}";
		SNSheetServiceStub stub = new SNSheetServiceStub();
		pos = "{\"route\":{\"phone\":\"152451215\",\"time\":\"2012-12-20 12:01:11\",\"service_name\":\"doCheck\","+
		"\"msg_id\":\"4556\" }, \"interfacemsg\": { \"userId\":\"zsyw\", \"user_password\":\"b59c67bf196a4758191e42f76670ceba\""+
		"} }";*/
		SNSheetServiceStub stub = new SNSheetServiceStub();
		//String fowuser = "{\"route\":{\"phone\":\"152451215\",\"time\":\"2014-12-20 12:01:11\",\"service_name\":\"doSheetDetail\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"order_code\":\"2013070102909886\",\"user_id\":\"system\"}}";
		String fowuser = "{\"route\":{\"phone\":\"\",\"time\":\"2015-01-26 10:48:47\",\"service_name\":\"doSheetToDept\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"order_code\":\"2015012604413184\",\"eoms_user_id\":\"sjjk\"}}";
		String hungup = "{\"route\":{\"phone\":\"\",\"time\":\"2015-01-26 10:48:47\",\"service_name\":\"doPostilQuery\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"order_code\":\"2011100501694966\",\"user_id\":\"sjjk\"}}";
		String dosend = "{\"route\":{\"phone\":\"152451215\",\"time\":\"2012-12-20 12:01:11\",\"service_name\":\"doSend\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"userId\":\"zsyw\",\"order_state\":0,\"currentnum\":1,\"pagesize\":10}}";
		String dosheetdesc = "{\"route\":{\"service_name\":\"login\",\"msg_id\":\"4556\"},\"interfacemsg\":{\"user_id\":\"zsyw\",\"order_code\":\"2015030404498497\"}}";
		System.out.println(dosheetdesc);
		SNSheetServiceStub.PublicMethod s = new SNSheetServiceStub.PublicMethod();
		s.setRequestXML(dosheetdesc);
        System.out.println(stub.PublicMethod(s).getPublicMethodReturn());
	}
}
