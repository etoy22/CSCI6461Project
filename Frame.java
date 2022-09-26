import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField GPR0BitField;
	private JTextField GPR1BitField;
	private JTextField GPR2BitField;
	private JTextField GPR3BitField;
	private JTextField X1BitField;
	private JTextField X2BitField;
	private JTextField X3BitField;
	private JTextField IRBitField;
	private JTextField PCBitField;
	private JTextField MARBitField;
	private JTextField MBRBitField;
	private JTextField textField_1;
	private JTextField MFRBitField;
	private JTextField CCBitField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel bitPanel = new JPanel();
		bitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton bit_15 = new JToggleButton("15");
		
		bitPanel.add(bit_15);
	
		JToggleButton bit_14 = new JToggleButton("14");
		bitPanel.add(bit_14);
		
		JToggleButton bit_13 = new JToggleButton("13");
		bitPanel.add(bit_13);
		
		JToggleButton bit_12 = new JToggleButton("12");
		bitPanel.add(bit_12);
		
		JToggleButton bit_11 = new JToggleButton("11");
		bitPanel.add(bit_11);
		
		JToggleButton bit_10 = new JToggleButton("10");
		bitPanel.add(bit_10);
		
		JToggleButton bit_9 = new JToggleButton("9");
		bitPanel.add(bit_9);
		
		JToggleButton bit_8 = new JToggleButton("8");
		bitPanel.add(bit_8);
		
		JToggleButton bit_7 = new JToggleButton("7");
		bitPanel.add(bit_7);
		
		JToggleButton bit_6 = new JToggleButton("6");
		bitPanel.add(bit_6);
		
		JToggleButton bit_5 = new JToggleButton("5");
		bitPanel.add(bit_5);
		
		JToggleButton bit_4 = new JToggleButton("4");
		bitPanel.add(bit_4);
		
		JToggleButton bit_3 = new JToggleButton("3");
		bitPanel.add(bit_3);
		
		JToggleButton bit_2 = new JToggleButton("2");
		bitPanel.add(bit_2);
		
		JToggleButton bit_1 = new JToggleButton("1");
		bitPanel.add(bit_1);
		
		
		
		
		
		
		
		JPanel labelBitPanel = new JPanel();
		
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
						.addComponent(bitPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
						.addComponent(labelBitPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(commandPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(bitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelBitPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(commandPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel GPR0Label = new JLabel("GPR0");
		GPR0Label.setBounds(167, 11, 48, 23);
		panel.add(GPR0Label);
		
		
		//Load GPR0 Button
		JButton GPR0Button = new JButton("Load");
		GPR0Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Goes here
				
			}
		});
		
		
		GPR0Button.setBounds(225, 11, 62, 23);
		panel.add(GPR0Button);
		
		GPR0BitField = new JTextField();
		GPR0BitField.setEditable(false);
		GPR0BitField.setText("0000000000000000");
		GPR0BitField.setBounds(297, 11, 105, 23);
		panel.add(GPR0BitField);
		GPR0BitField.setColumns(10);
		
		JLabel GPR1Label = new JLabel("GPR1");
		GPR1Label.setBounds(167, 45, 48, 23);
		panel.add(GPR1Label);
		
		JButton GPR1Button = new JButton("Load");
		GPR1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR1Button.setBounds(225, 45, 62, 23);
		panel.add(GPR1Button);
		
		GPR1BitField = new JTextField();
		GPR1BitField.setText("0000000000000000");
		GPR1BitField.setEditable(false);
		GPR1BitField.setColumns(10);
		GPR1BitField.setBounds(297, 45, 105, 23);
		panel.add(GPR1BitField);
		
		JLabel GPR2Label = new JLabel("GPR2");
		GPR2Label.setBounds(167, 79, 48, 23);
		panel.add(GPR2Label);
		
		JButton GPR2Button = new JButton("Load");
		GPR2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR2Button.setBounds(225, 79, 62, 23);
		panel.add(GPR2Button);
		
		GPR2BitField = new JTextField();
		GPR2BitField.setText("0000000000000000");
		GPR2BitField.setEditable(false);
		GPR2BitField.setColumns(10);
		GPR2BitField.setBounds(297, 79, 105, 23);
		panel.add(GPR2BitField);
		
		JLabel GPR3Label = new JLabel("GPR3");
		GPR3Label.setBounds(167, 113, 48, 23);
		panel.add(GPR3Label);
		
		JButton GPR3Button = new JButton("Load");
		GPR3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR3Button.setBounds(225, 113, 62, 23);
		panel.add(GPR3Button);
		
		GPR3BitField = new JTextField();
		GPR3BitField.setText("0000000000000000");
		GPR3BitField.setEditable(false);
		GPR3BitField.setColumns(10);
		GPR3BitField.setBounds(297, 113, 105, 23);
		panel.add(GPR3BitField);
		
		JLabel X1Label = new JLabel("X1");
		X1Label.setBounds(412, 11, 48, 23);
		panel.add(X1Label);
		
		JButton X1Button = new JButton("Load");
		X1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		X1Button.setBounds(470, 11, 62, 23);
		panel.add(X1Button);
		
		X1BitField = new JTextField();
		X1BitField.setText("0000000000000000");
		X1BitField.setEditable(false);
		X1BitField.setColumns(10);
		X1BitField.setBounds(542, 11, 105, 23);
		panel.add(X1BitField);
		
		JLabel X2Label = new JLabel("X2");
		X2Label.setBounds(412, 45, 48, 23);
		panel.add(X2Label);
		
		JButton X2Button = new JButton("Load");
		X2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		X2Button.setBounds(470, 45, 62, 23);
		panel.add(X2Button);
		
		X2BitField = new JTextField();
		X2BitField.setText("0000000000000000");
		X2BitField.setEditable(false);
		X2BitField.setColumns(10);
		X2BitField.setBounds(542, 45, 105, 23);
		panel.add(X2BitField);
		
		JLabel X3Label = new JLabel("X3");
		X3Label.setBounds(412, 79, 48, 23);
		panel.add(X3Label);
		
		JButton X3Button = new JButton("Load");
		X3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		X3Button.setBounds(470, 79, 62, 23);
		panel.add(X3Button);
		
		X3BitField = new JTextField();
		X3BitField.setText("0000000000000000");
		X3BitField.setEditable(false);
		X3BitField.setColumns(10);
		X3BitField.setBounds(542, 79, 105, 23);
		panel.add(X3BitField);
		
		JLabel IRLabel = new JLabel("IR");
		IRLabel.setBounds(167, 264, 48, 23);
		panel.add(IRLabel);
		
		JButton IRButton = new JButton("Load");
		IRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IRButton.setBounds(225, 264, 62, 23);
		panel.add(IRButton);
		
		IRBitField = new JTextField();
		IRBitField.setText("0000000000000000");
		IRBitField.setEditable(false);
		IRBitField.setColumns(10);
		IRBitField.setBounds(297, 264, 105, 23);
		panel.add(IRBitField);
		
		JLabel PCLabel = new JLabel("PC");
		PCLabel.setBounds(167, 162, 48, 23);
		panel.add(PCLabel);
		
		JButton PCButton = new JButton("Load");
		PCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PCButton.setBounds(225, 162, 62, 23);
		panel.add(PCButton);
		
		PCBitField = new JTextField();
		PCBitField.setText("000000000000");
		PCBitField.setEditable(false);
		PCBitField.setColumns(10);
		PCBitField.setBounds(297, 162, 82, 23);
		panel.add(PCBitField);
		
		JLabel MARLabel = new JLabel("MAR");
		MARLabel.setBounds(167, 196, 48, 23);
		panel.add(MARLabel);
		
		JButton MARButton = new JButton("Load");
		MARButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MARButton.setBounds(225, 196, 62, 23);
		panel.add(MARButton);
		
		MARBitField = new JTextField();
		MARBitField.setText("000000000000");
		MARBitField.setEditable(false);
		MARBitField.setColumns(10);
		MARBitField.setBounds(297, 196, 82, 23);
		panel.add(MARBitField);
		
		JLabel MBRLabel = new JLabel("MBR");
		MBRLabel.setBounds(167, 230, 48, 23);
		panel.add(MBRLabel);
		
		JButton MBRButton = new JButton("Load");
		MBRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MBRButton.setBounds(225, 230, 62, 23);
		panel.add(MBRButton);
		
		MBRBitField = new JTextField();
		MBRBitField.setText("0000000000000000");
		MBRBitField.setEditable(false);
		MBRBitField.setColumns(10);
		MBRBitField.setBounds(297, 230, 105, 23);
		panel.add(MBRBitField);
		
		JLabel MemoryAtMARLabel = new JLabel("Memory at MAR");
		MemoryAtMARLabel.setBounds(412, 196, 120, 23);
		panel.add(MemoryAtMARLabel);
		
		textField_1 = new JTextField();
		textField_1.setText("0000000000000000");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(542, 197, 105, 23);
		panel.add(textField_1);
		
		JLabel MFRLabel = new JLabel("MFR");
		MFRLabel.setBounds(412, 230, 120, 23);
		panel.add(MFRLabel);
		
		MFRBitField = new JTextField();
		MFRBitField.setText("0000");
		MFRBitField.setEditable(false);
		MFRBitField.setColumns(10);
		MFRBitField.setBounds(542, 230, 32, 23);
		panel.add(MFRBitField);
		
		JLabel CCLabel = new JLabel("CC");
		CCLabel.setBounds(412, 264, 48, 23);
		panel.add(CCLabel);
		
		JButton CCButton = new JButton("Load");
		CCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CCButton.setBounds(470, 264, 62, 23);
		panel.add(CCButton);
		
		CCBitField = new JTextField();
		CCBitField.setText("0000");
		CCBitField.setEditable(false);
		CCBitField.setColumns(10);
		CCBitField.setBounds(542, 265, 32, 23);
		panel.add(CCBitField);
		
		//Store Button
		JButton storeButton = new JButton("Store");
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(MBRBitField.getText());

				//Put code here
			}
		});
		
		
		
		commandPanel.add(storeButton);
		
		//Load Button
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MBRBitField.setText(textField_1.getText());
				
				
				//Put code here
				
			}
		});
		commandPanel.add(loadButton);
		
		JToggleButton bit_0 = new JToggleButton("0");
		bitPanel.add(bit_0);
		
		JLabel opCodeLabel = new JLabel("Opcode");
		opCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opCodeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel IXLabel = new JLabel("IX");
		IXLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		IXLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel RLabel = new JLabel("R");
		RLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		RLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ILabel = new JLabel("I");
		ILabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ILabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setAlignmentX(0.5f);
		GroupLayout gl_labelBitPanel = new GroupLayout(labelBitPanel);
		gl_labelBitPanel.setHorizontalGroup(
			gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_labelBitPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(opCodeLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(IXLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(RLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ILabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
		);
		gl_labelBitPanel.setVerticalGroup(
			gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_labelBitPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(IXLabel)
						.addComponent(opCodeLabel)
						.addComponent(RLabel)
						.addComponent(ILabel)
						.addComponent(addressLabel))
					.addGap(13))
		);
		labelBitPanel.setLayout(gl_labelBitPanel);
		contentPane.setLayout(gl_contentPane);
	}

	protected void alert(int i) {
		// TODO Auto-generated method stub
		
	}

	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
}
