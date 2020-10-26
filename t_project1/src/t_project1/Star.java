package t_project1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Star extends JFrame { 
	private JTable table;
	
	public Star() {
		setTitle("즐겨찾기");
		JPanel NewWindowContainer = new JPanel();
		setContentPane(NewWindowContainer);
		NewWindowContainer.setBackground(SystemColor.inactiveCaption);
		NewWindowContainer.setBounds(100, 100, 1000, 400);
		NewWindowContainer.setLayout(null);
		this.setSize(1000,400);
        setResizable(true);
        setVisible(true);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 30, 190, 50);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"시내버스", "13", "5001-1", "5003B", "5000B"}));
		comboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		NewWindowContainer.add(comboBox);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(65, 90, 190, 50);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"스쿨버스","명지대역"}));
		comboBox2.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		NewWindowContainer.add(comboBox2);

		JButton addbookmarking = new JButton("즐겨찾기 추가");
		addbookmarking.setBackground(SystemColor.menu);
		addbookmarking.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		addbookmarking.setBounds(90, 168, 140, 50);
		addbookmarking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data[]= {comboBox.getSelectedItem().toString()};
				String data2[]= {comboBox2.getSelectedItem().toString()};
				if(comboBox.getSelectedItem()=="시내버스"&&comboBox2.getSelectedItem()=="스쿨버스") {
					JOptionPane.showMessageDialog(null, "버스를 선택하세요!" );
				}
				else if((comboBox.getSelectedItem())!="시내버스"&&comboBox2.getSelectedItem()=="스쿨버스") {
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data);		
				}
				else if(comboBox.getSelectedItem()=="시내버스"&&(comboBox2.getSelectedItem())!="스쿨버스"){
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data2);
				    
				}
				else if((comboBox.getSelectedItem())!="시내버스"&&(comboBox2.getSelectedItem())!="스쿨버스"){
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data);
					tblModel.addRow(data2);
				    
				}
			}
			
			
		});
		
		NewWindowContainer.add(addbookmarking);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 50, 580, 230);
		NewWindowContainer.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {"버스번호"}) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
				int SR=table.getSelectedRow();
				String value=(String)tblModel.getValueAt(SR, 0);
				
				
				if(e.getClickCount()==2) {
					if(value=="13") {
						new b_13();
					}
					else if(value=="5001-1") {
						new b_5001_1();
					}
					else if(value=="5000B") {
						new b_5000B();
					}
					else if(value=="5003B") {
						new b_5003B();
					}
					else if(value=="명지대역") {
						new b_School();
					}
				}
			}
		});
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(3500);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer tblModel = new DefaultTableCellRenderer();
		tblModel.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(tblModel);
		
		
		JButton btnDelete = new JButton("즐겨찾기 삭제");
		btnDelete.setBounds(90, 243, 140, 50);
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
				if(table.getSelectedRowCount()==1) {
					tblModel.removeRow(table.getSelectedRow());
				}
				else {
					if(table.getRowCount()==0) {
						//테이블에 데이터가 없을때
						JOptionPane.showMessageDialog(null, "즐겨찾기 목록이 비었습니다." );
					}else {
						JOptionPane.showMessageDialog(null, "삭제할 버스를 한개만 선택해주세요." );
					}
				}
			}
		});
		NewWindowContainer.add(btnDelete);
		}
}

